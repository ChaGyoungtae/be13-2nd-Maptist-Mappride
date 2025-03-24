package com.maptist.mappride.mappride.member;

import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.category.CategoryRepository;
import com.maptist.mappride.mappride.category.dto.CategoryResponseDto;
import com.maptist.mappride.mappride.comment.Comment;
import com.maptist.mappride.mappride.comment.CommentRepository;
import com.maptist.mappride.mappride.config.jwt.DTO.SecurityUserDto;
import com.maptist.mappride.mappride.config.s3.S3Service;
import com.maptist.mappride.mappride.grade.Grade;
import com.maptist.mappride.mappride.grade.GradeRepository;
import com.maptist.mappride.mappride.member.DTO.MemberDto;
import com.maptist.mappride.mappride.member.DTO.MemberEmailDto;
import com.maptist.mappride.mappride.member.DTO.MemberNameDto;
import com.maptist.mappride.mappride.member.DTO.MemberNicknameDto;
import com.maptist.mappride.mappride.member.DTO.RegisterDto;
import com.maptist.mappride.mappride.photo.Photo;
import com.maptist.mappride.mappride.photo.PhotoRepository;
import com.maptist.mappride.mappride.place.Place;
import com.maptist.mappride.mappride.place.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;
    private final PhotoRepository photoRepository;
    private final S3Service s3Service;
    private final PlaceRepository placeRepository;
    private final CategoryRepository categoryRepository;
    private final GradeRepository gradeRepository;

    public Optional<Member> findByEmail(String email){
        return memberRepository.findByEmail(email);
    }

    public Long register(RegisterDto registerDto) {
        Grade beginner = gradeRepository.findBeginner();
        Member member = Member.createMember(registerDto, beginner);

        return memberRepository.save(member);
    }

    public Member getMember() {
        SecurityUserDto securityUserDto = (SecurityUserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = securityUserDto.getEmail();
        Optional<Member> findMember = memberRepository.findByEmail(email);
        if (findMember.isPresent()) {
            return findMember.get();
        } else {
            return null;
        }
    }


    // 내 정보 조회
    public MemberDto selectMyInfo()
    {
        // 멤버 객체에서 아이디만 빼옴
        Long memberId = getMember().getId();

        //멤버아이디를 레포지토리로 이동
        return memberRepository.selectMyInfo(memberId);
    }

    public void updateInfo(LocalDate birthday) {
        // 멤버 객체에서 아이디만 빼옴
        Long memberId = getMember().getId();
        memberRepository.updateBirthday(memberId,birthday);
    }
    public void updateInfo(String nickname) {

        Long memberId = getMember().getId();
        try
        {
            validateDuplicateNickname(nickname, memberId);
        }
        catch (IllegalStateException e)
        {
            log.error("닉네임 중복");
            throw new ResponseStatusException(HttpStatus.CONFLICT, "닉네임이 중복됩니다");
        }
        memberRepository.updateNickname(memberId,nickname);
    }

    // 닉네임 중복 체크
    private void validateDuplicateNickname(String nickname, Long memberId)
    {
        Member findMember = memberRepository.findByNickname(nickname);

        if (findMember != null && findMember.getId() != memberId)
        {
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }
    }

    // 내 카테고리 조회 (페이지 이동)
    public List<CategoryResponseDto> searchCategories()
    {
        // 유저 아이디로 부터 유저 카테고리들 조회
        Long memberId = getMember().getId();

        return memberRepository.getCategories(memberId);
    }

    // 멤버 검색 (이름)
    public List<MemberNameDto> selectOtherName(String name)
    {
        return memberRepository.selectOtherName(name);
    }

    // 멤버 검색 (이메일)
    public MemberEmailDto selectOtherEmail(String email)
    {
        return memberRepository.selectOtherEmail(email);
    }

    // 멤버 검색 (닉네임)
    public MemberNicknameDto selectOtherNickname(String nickName)
    {
        return memberRepository.selectOtherNickname(nickName);
    }

    public void plusScrapCnt(Long categoryId){
        // 카테고리 id를 이용해 멤버 id 조회
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if(categoryOptional.isEmpty()){
            throw new RuntimeException("category is not found");
        }

        Long memberIdByCategoryId = categoryOptional.get().getMember().getId();
        // 알림 받은 멤버 조회
        Member NotifiedMember = memberRepository.findById(memberIdByCategoryId);
        // scrapCnt + 1
        NotifiedMember.plusScrapCnt();
        System.out.println(NotifiedMember.getScrapCnt());
    }

    public void deleteMember() {
        //comment, image, photo, place, category 순서대로 삭제

        Member member = getMember();

        // comment 삭제
        Long memberId = member.getId();

        List<Comment> comments = commentRepository.findCommentsByMemberId(memberId);

        for(Comment comment : comments){
            commentRepository.delete(comment);
        }

        // image, photo 삭제
        List<Photo> photos = photoRepository.findByMemberId(memberId);

        for(Photo p : photos){
            String photoUrl = p.getPhotoUrl();
            s3Service.deleteFile(photoUrl);
            photoRepository.remove(p);
        }

        // category, place 삭제
        // memberId 를 통해서 그 멤버가 만든 카테고리 전체를 조회
        List<Category> categories = categoryRepository.findByMemberId(memberId);

        List<Place> places = new ArrayList<>();
        for(Category category: categories){
            places.clear();
            places = (placeRepository.findByCategoryId(category.getId()));
            for(Place place : places) {
                placeRepository.delete(place);
            }
            categoryRepository.delete(category);
        }

        //멤버 삭제
        memberRepository.delete(member);
    }
}
