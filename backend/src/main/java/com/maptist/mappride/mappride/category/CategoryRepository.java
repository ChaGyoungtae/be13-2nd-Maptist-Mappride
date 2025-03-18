package com.maptist.mappride.mappride.category;

import com.maptist.mappride.mappride.category.dto.CategoryDto;
import com.maptist.mappride.mappride.category.dto.CategoryNameFindDto;
import com.maptist.mappride.mappride.category.dto.CategoryUpdateDto;
import com.maptist.mappride.mappride.category.dto.OtherFindCategoryDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {

    private final EntityManager em;

    public Long create(Category category) {
        em.persist(category);
        return category.getId();
    }

    public List<Category> findByMemberId(Long memberId) {
        return em.createQuery("select c " +
                "from Category c " +
                "where c.member.id =: memberId ",Category.class)
                .setParameter("memberId",memberId)
                .getResultList();
    }

    public void updateCategory(CategoryUpdateDto categoryUpdateDto) {
        String query = """
                UPDATE Category c
                SET c.name = :name, c.publish = :publish
                WHERE c.id = :id
                """;
        em.createQuery(query)
                .setParameter("name", categoryUpdateDto.getName())
                .setParameter("publish",categoryUpdateDto.isPublish())
                .setParameter("id", categoryUpdateDto.getId())
                .executeUpdate();
    }

    public void delete(Category findCategory) {
        em.remove(findCategory);
    }

    public List<Category> findByName(String name) {
        return em.createQuery("SELECT c FROM Category c WHERE c.name = :name", Category.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<CategoryDto> findCategoryDtoByMemberId(Long memberId) {
        String query = """
            SELECT new com.maptist.mappride.mappride.category.dto.CategoryDto(c.name,c.publish)
            FROM Category c
            WHERE c.member.id = :memberId
            """;

        return em.createQuery(query, CategoryDto.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    public Category findByMemberIdAndCategoryId(Long memberId, Long categoryId) {

        return em.createQuery("select c " +
                        "from Category c " +
                        "where c.id =: categoryId and c.member.id =: memberId ", Category.class)
                .setParameter("categoryId", categoryId)
                .setParameter("memberId", memberId)
                .getSingleResult();
    }

    public Optional<Category> findById(Long categoryId) {
        return Optional.ofNullable(em.find(Category.class, categoryId));
    }

//    public List<Category> findAll() {
//        return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
//
//    }

    // 남의 카테고리 전체 조회
    public List<OtherFindCategoryDto> findCategoryByOtherMemberId(Long memberId) {
        String query = """
            
            SELECT new com.maptist.mappride.mappride.category.dto.OtherFindCategoryDto(c.id,c.name)
            FROM Category c
            WHERE c.member.id = :memberId and c.publish = true
            """;

        return em.createQuery(query, OtherFindCategoryDto.class)
                .setParameter("memberId", memberId)
                .getResultList();
        // 위에서 조회한 CategoryId를 통해 Category들을 조회해서 DTO로 반환
    }

    public List<CategoryNameFindDto> findCategoryName(String name, Long memberId) {
        return em.createQuery(
                "SELECT new com.maptist.mappride.mappride.category.dto.CategoryNameFindDto(c.name, c.id, c.publish) " +
                        "FROM Category c WHERE c.member.id =:memberId and c.name LIKE :name", CategoryNameFindDto.class)
                .setParameter("name", "%" + name + "%")
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
