package com.maptist.mappride.mappride.member;

import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.category.CategoryRepository;
import com.maptist.mappride.mappride.categoryByMember.CategoryByMember;
import com.maptist.mappride.mappride.categoryByMember.CategoryByMemberRepository;
import com.maptist.mappride.mappride.categoryByMember.DTO.CategoryByMemberResponseDto;
import com.maptist.mappride.mappride.comment.Comment;
import com.maptist.mappride.mappride.comment.CommentRepository;
import com.maptist.mappride.mappride.config.jwt.DTO.SecurityUserDto;
import com.maptist.mappride.mappride.config.s3.S3Service;
import com.maptist.mappride.mappride.member.DTO.MemberDto;
import com.maptist.mappride.mappride.member.DTO.MemberEmailDto;
import com.maptist.mappride.mappride.member.DTO.MemberNameDto;
import com.maptist.mappride.mappride.member.DTO.MemberNicknameDto;
import com.maptist.mappride.mappride.member.DTO.MemberUpdateDto;
import com.maptist.mappride.mappride.member.DTO.RegisterDto;
import com.maptist.mappride.mappride.photo.Photo;
import com.maptist.mappride.mappride.photo.PhotoRepository;
import com.maptist.mappride.mappride.place.Place;
import com.maptist.mappride.mappride.place.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final CategoryByMemberRepository categoryByMemberRepository;
    private final CommentRepository commentRepository;
    private final PhotoRepository photoRepository;
    private final S3Service s3Service;
    private final PlaceRepository placeRepository;
    private final CategoryRepository categoryRepository;

    public Optional<Member> findByEmail(String email){
        return memberRepository.findByEmail(email);
    }

    public ResponseEntity<Long> register(RegisterDto registerDto) {
        Member member = Member.createMember(registerDto);

        return ResponseEntity.ok().body(memberRepository.save(member));
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

    // 내 정보 수정
    public void updateMyInfo(MemberUpdateDto dto)
    {
        memberRepository.updateMyInfo(dto);
    }

    // 내 카테고리 조회 (페이지 이동)
    public List<CategoryByMemberResponseDto> searchCategories()
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
        Long memberIdByCategoryId = categoryByMemberRepository.findMemberIdByCategoryId(categoryId);
        // 알림 받은 멤버 조회
        Member NotifiedMember = memberRepository.findById(memberIdByCategoryId);
        // scrapCnt + 1
        NotifiedMember.plusScrapCnt();
    }

    public void deleteMember() {
        //comment, image, photo, place, cbm, category 순서대로 삭제

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

        // place 삭제
        List<CategoryByMember> categorieByMembers = categoryByMemberRepository.findByMemberId(memberId);
        List<Category> categories = new ArrayList<>();
        List<Place> places = new ArrayList<>();
        for(CategoryByMember cbm : categorieByMembers){
            Optional<Category> category = categoryRepository.findById(cbm.getCategory().getId());
            if(category.isEmpty()){
                throw new RuntimeException("카테고리 조회 실패");
            }
            categories.add(category.get());
            categoryByMemberRepository.delete(cbm);
        }
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
