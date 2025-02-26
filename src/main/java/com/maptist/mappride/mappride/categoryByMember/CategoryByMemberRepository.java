package com.maptist.mappride.mappride.categoryByMember;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryByMemberRepository {

    private final EntityManager em;

    public void save(CategoryByMember categoryByMember) {
        em.persist(categoryByMember);
    }

    public void delete(CategoryByMember categoryByMember) {
        em.remove(categoryByMember);
    }

    public CategoryByMember findByMemberIdAndCategoryId(Long memberId, Long categoryId) {

        return em.createQuery("select cbm " +
                "from CategoryByMember cbm " +
                "where cbm.category.id =: categoryId and cbm.member.id =: memberId ", CategoryByMember.class)
                .setParameter("categoryId", categoryId)
                .setParameter("memberId", memberId)
                .getSingleResult();
    }
}
