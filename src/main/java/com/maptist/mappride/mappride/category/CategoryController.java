package com.maptist.mappride.mappride.category;

import com.maptist.mappride.mappride.category.dto.CategoryCopyDto;
import com.maptist.mappride.mappride.category.dto.CategoryDto;
import com.maptist.mappride.mappride.category.dto.CategoryUpdateDto;
import com.maptist.mappride.mappride.category.dto.OtherFindCategoryDto;
import com.maptist.mappride.mappride.place.PlaceService;
import com.maptist.mappride.mappride.place.dto.PlacesByCategoryResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    private final PlaceService placeService;


    // 카테고리 생성
    // 데이터 유효성 검증완료전까진 dto로 감싸서 전달함
    @PostMapping
    public ResponseEntity<Long> createCategory(@RequestBody CategoryDto dto) {

        return categoryService.createCategory(dto);
    }


    // memberId로 카테고리 아이디 조회함 그리구 카테고리 아이디 리스트형태로 옴.
    // 각각 카테고리 아이디에 대응하는 카테고리들을 싹 다 가져와서 리스트로 저장
    // 근데 이거 select할때 dto로 넣아야함.
    // 카테고리 전체 조회
    @GetMapping
    public ResponseEntity<List<CategoryDto>>findAll() {
        List<CategoryDto> findAllCategory = categoryService.findByMemberId();
        return ResponseEntity.ok(findAllCategory);
    }


    // 카테고리 별 장소 조회
    @GetMapping("/{category-id}/places")
    public ResponseEntity<List<PlacesByCategoryResponseDto>> getPlacesByCategory(@PathVariable Long categoryId) {

        List<PlacesByCategoryResponseDto> places = placeService.findPlacesByCategory(categoryId);

        return ResponseEntity.ok().body(places);
    }


    // 카테고리 수정
    @PutMapping("/update")
    public ResponseEntity<Long> updateCategory(@RequestBody CategoryUpdateDto dto) {

        return ResponseEntity.ok().body(categoryService.updateCategory(dto));
    }


    // 카테고리 삭제
    @DeleteMapping("/{category-id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("category-id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }

    // 남의 카테고리 전체 조회
    @GetMapping("/{member-id}")
    public ResponseEntity<List<OtherFindCategoryDto>> findOtherMemberCategory(@PathVariable("member-id") Long memberId) {
        return ResponseEntity.ok().body(categoryService.findByOtherMemberId(memberId));
    }

    // 복사 카테고리 전체 복사해서 내껄로 만듦, 장소만 복사해서 내 카테고리로 가져옴.(유진언니)
    // name, id 받아오는 dto(categoryCopyDto)

    @PostMapping("/copy")
    public ResponseEntity<Long> copyCategory(@RequestBody CategoryCopyDto dto) {
        return ResponseEntity.ok().body(categoryService.copyCategory(dto));
    }

}
