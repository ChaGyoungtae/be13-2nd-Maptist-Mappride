package com.maptist.mappride.mappride.category.dto;

import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CategoryDto {
    private String name;
    private boolean publish;

    public Category toCategory(Member member) {
        return Category.builder()
                .name(name)
                .member(member)
                .publish(publish)
                .build();
    }


}

