package com.maptist.mappride.mappride.categoryByMember;

import com.maptist.mappride.mappride.category.Category;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public Long findMemberIdByCategoryId(Long categoryId){
        CategoryByMember result = em.createQuery("select cbm " +
                        "from CategoryByMember cbm " +
                        "where cbm.category.id =: categoryId", CategoryByMember.class)
                .setParameter("categoryId", categoryId)
                .getSingleResult();

        return result.getId();

    }

    public List<CategoryByMember> findByMemberId(Long memberId) {

        return em.createQuery("select cbm " +
                        "from CategoryByMember cbm " +
                        "where cbm.member.id =: memberId", CategoryByMember.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
