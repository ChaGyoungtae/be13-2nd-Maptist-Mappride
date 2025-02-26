package com.maptist.mappride.mappride.category;

import com.maptist.mappride.mappride.category.dto.CategoryDto;
import com.maptist.mappride.mappride.category.dto.CategoryUpdateDto;
import com.maptist.mappride.mappride.categoryByMember.CategoryByMember;
import com.maptist.mappride.mappride.categoryByMember.CategoryByMemberRepository;
import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.member.MemberService;
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


    // 카테고리 생성
    // 유효성 검사라서 비즈니스 로직임 CategoryController에서 왔음
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

    public void updateCategory(CategoryUpdateDto dto) {
        categoryRepository.updateCategory(dto);
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



//    public List<Category> findAllCategory() {
//        return categoryRepository.findAll();
//    }

}
