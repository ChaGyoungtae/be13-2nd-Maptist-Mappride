package com.maptist.mappride.mappride.categoryByMember;

import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.member.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CategoryByMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cbm_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;


    public CategoryByMember(Member member, Category category) {
        this.member = member;
        this.category = category;
    }
}
