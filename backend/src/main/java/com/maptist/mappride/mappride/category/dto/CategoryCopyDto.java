package com.maptist.mappride.mappride.category.dto;

import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class CategoryCopyDto {
    private final Long categoryId;

    private final String name;

    public Category toCategory(Member member) {
        return Category.builder()
                .name(name)
                .member(member)
                .publish(true)
                .build();
    }
}
