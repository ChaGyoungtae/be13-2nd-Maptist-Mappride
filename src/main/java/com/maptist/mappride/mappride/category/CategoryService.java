package com.maptist.mappride.mappride.category;

import com.maptist.mappride.mappride.category.dto.CategoryCopyDto;
import com.maptist.mappride.mappride.category.dto.CategoryDto;
import com.maptist.mappride.mappride.category.dto.CategoryUpdateDto;
import com.maptist.mappride.mappride.category.dto.OtherFindCategoryDto;
import com.maptist.mappride.mappride.categoryByMember.CategoryByMember;
import com.maptist.mappride.mappride.categoryByMember.CategoryByMemberRepository;
import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.member.MemberService;
import com.maptist.mappride.mappride.notification.NotificationService;
import com.maptist.mappride.mappride.notification.dto.CategorySseResponse;
import com.maptist.mappride.mappride.photo.PhotoService;
import com.maptist.mappride.mappride.place.Place;
import com.maptist.mappride.mappride.place.PlaceRepository;
import com.maptist.mappride.mappride.place.dto.PlaceCopyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryByMemberRepository categoryByMemberRepository;
    private final MemberService memberService;
    private final PlaceRepository placeRepository;
    private final PhotoService photoService;
    private final NotificationService notificationService;

    // 카테고리 생성
    // 유효성 검사라서 비즈니스 로직임 CategoryController에서 왔음
    @Transactional
    public ResponseEntity<Long> createCategory(@RequestBody CategoryDto categoryDto) {
        // RequestParam 대신 RequestBody씀

        try{ // 중복된 이름의 카테고리가 있는지 검사
            validateDuplicateCategory(categoryDto.getName());
        } catch (IllegalStateException e){
            // 중복된 이름의 카테고리 있으면 에러발생
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(-1L);
        }

        // categoryByMember 테이블에 저장할 현재 유저 정보 가져오기
        Member member = memberService.getMember();
        // dto로부터 카테고리 객체 만듬 : fromDto
        Category category = categoryDto.toCategory();
        Long categoryId = categoryRepository.create(category);
        // categoryByMember 객체 생성 후 db에 저장함
        CategoryByMember categoryByMember = new CategoryByMember(member,category);
        categoryByMemberRepository.save(categoryByMember);
        // 확인용 로그
        log.info("Category created: {}", categoryId);
        return ResponseEntity.ok().body(categoryId); // 잘됐는지 알려줌
    }

    // 이름중복
    private void validateDuplicateCategory(String name) {
        //Exception
        List<Category> findCategory = categoryRepository.findByName(name);
        if(!findCategory.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 카테고리입니다.");
        }
    }



    // 카테고리 조회
    public List<CategoryDto> findByMemberId() {
        // 멤버 가져와서 내꺼만 조회 멤버아이디말고 객체로 받아와야된다
        Member member = memberService.getMember();
        // 멤버 객체에서 아이디만 빼옴
        Long memberId = member.getId();
        //멤버아이디를 레포지토리로 이동
        return categoryRepository.findCategoryByMemberId(memberId);
    }





    // 카테고리 수정
    @Transactional
    public Long updateCategory(CategoryUpdateDto dto) {
        System.out.println(dto);
        categoryRepository.updateCategory(dto);
        return dto.getId();
    }



    @Transactional
    // 카테고리 삭제
    public void deleteCategory(Long categoryId) {

        Optional<Category> findCategory = categoryRepository.findById(categoryId);

        if(findCategory.isEmpty()) {
            throw new RuntimeException("findCategory is null");
        }
        Member member = memberService.getMember();
        CategoryByMember categoryByMember = categoryByMemberRepository.findByMemberIdAndCategoryId(member.getId(),categoryId);

        categoryByMemberRepository.delete(categoryByMember);

    }


    // 남의 카테고리 전체 조회
    public List<OtherFindCategoryDto> findByOtherMemberId(Long memberId) {

        //멤버아이디를 레포지토리로 이동
        return categoryRepository.findCategoryByOtherMemberId(memberId);
    }

    @Transactional
    public Long copyCategory(CategoryCopyDto dto){

        try{
            validateDuplicateCategory(dto.getName());
        } catch (IllegalStateException e){
            log.error("카테고리 중복");
        }



        // categoryByMember 테이블에 저장할 현재 유저 정보 가져오기
        Member member = memberService.getMember();
        Category category = dto.toCategory();
        categoryRepository.create(category);
        // categoryByMember 객체 생성 후 db에 저장함
        CategoryByMember categoryByMember = new CategoryByMember(member,category);
        categoryByMemberRepository.save(categoryByMember);
        // 확인용 로그
        log.info("Category copied: {}", category.getId());

        // dto에 있는 categoryId 변수로 저장
        Long categoryId = dto.getCategoryId();
        List<PlaceCopyDto> placeCopyDtos = placeRepository.findPlaceCopyDtoBycategoryId(categoryId);

        for(PlaceCopyDto placeDto : placeCopyDtos) {

            Place place = placeDto.toPlace(category);
            placeRepository.save(place);

            photoService.copyPhoto(placeDto.getPlaceId(),member,place);
        }

        String nickname = member.getNickname();
        Category prevCategory = categoryRepository.findById(categoryId).get();
        String categoryName = prevCategory.getName();

        // 복사 알림 dto 만들어서 알림 전송
        CategorySseResponse categorySseResponse = CategorySseResponse.builder()
                .nickname(nickname)
                .categoryName(categoryName)
                .build();

        notificationService.customNotify(member.getId(), categorySseResponse, nickname + "님이 당신의 " + categoryName + " 을(를) 복사 했습니다.","copy");

        // 알림받은 사용자의 scrapCnt + 1
        memberService.plusScrapCnt(prevCategory.getId());


        return category.getId();
    }

}
