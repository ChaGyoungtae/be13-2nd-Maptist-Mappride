package com.maptist.mappride.mappride.category;

import com.maptist.mappride.mappride.category.dto.CategoryCopyDto;
import com.maptist.mappride.mappride.category.dto.CategoryDto;
import com.maptist.mappride.mappride.category.dto.CategoryNameFindDto;
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


    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto dto) {
        categoryService.createCategory(dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<Category>>findAll() {
        List<Category> findAllCategory = categoryService.findByMemberId();
        return ResponseEntity.ok(findAllCategory);
    }


    @GetMapping("/findCategory/{name}")
    public ResponseEntity<List<CategoryNameFindDto>> searchNameCategory(@PathVariable String name ) {
        List<CategoryNameFindDto> findAllCategory = categoryService.findByCategoryName(name);
        return ResponseEntity.ok(findAllCategory);
    }

    @GetMapping("/{category-id}/places")
    public ResponseEntity<List<PlacesByCategoryResponseDto>> getPlacesByCategory(@PathVariable("category-id") Long categoryId) {

        List<PlacesByCategoryResponseDto> places = placeService.findPlacesByCategory(categoryId);

        return ResponseEntity.ok().body(places);
    }

    @PutMapping("/update")
    public ResponseEntity<Long> updateCategory(@RequestBody CategoryUpdateDto dto) {

        return ResponseEntity.ok().body(categoryService.updateCategory(dto));
    }

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

    @PostMapping("/copy")
    public ResponseEntity<Long> copyCategory(@RequestBody CategoryCopyDto dto) {
        return ResponseEntity.ok().body(categoryService.copyCategory(dto));
    }
}
