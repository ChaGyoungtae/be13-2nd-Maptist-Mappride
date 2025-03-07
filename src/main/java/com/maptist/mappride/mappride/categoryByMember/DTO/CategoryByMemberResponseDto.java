package com.maptist.mappride.mappride.categoryByMember.DTO;

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
public class CategoryByMemberResponseDto {

    private Category category;

    private Long memberId;

    public long getCategoryId() {
        return category.getId();
    }

}
