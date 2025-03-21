package com.maptist.mappride.mappride.category.dto;

import com.maptist.mappride.mappride.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
// 유저의 카테고리들 정보 Response
public class CategoryResponseDto {

    private Long id;

    private String name;

    private Boolean publish;

    private Long memberId;

    public CategoryResponseDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.publish = category.isPublish();
        this.memberId = category.getId();
    }
}