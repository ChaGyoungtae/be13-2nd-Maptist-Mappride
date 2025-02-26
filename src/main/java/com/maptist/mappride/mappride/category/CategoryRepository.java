package com.maptist.mappride.mappride.category;

import com.maptist.mappride.mappride.category.dto.CategoryDto;
import com.maptist.mappride.mappride.category.dto.CategoryUpdateDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {

    private final EntityManager em;

    // 카테고리 생성
    public Long create(Category category) {
        em.persist(category);
        return category.getId();
    }


    public List<Category> findByName(String name) {
        return em.createQuery("SELECT c FROM Category c WHERE c.name = :name", Category.class)
                .setParameter("name", name)
                .getResultList();
    }




    public List<CategoryDto> findCategoryByMemberId(Long memberId) {
        //CategoryByMember 에서 입력받은 memberId를 가진 CategoryId 를 조회한다.
        String query = """
            
            SELECT new com.maptist.mappride.mappride.category.dto.CategoryDto(c.name,c.publish)
            FROM Category c
            JOIN CategoryByMember cbm ON c.id = cbm.category.id
            WHERE cbm.member.id = :memberId
            """;

        return em.createQuery(query, CategoryDto.class)
                .setParameter("memberId", memberId)
                .getResultList();
        // 위에서 조회한 CategoryId를 통해 Category들을 조회해서 DTO로 반환
    }


    // 카테고리 수정
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



    // 삭제
    public void deleteById(Category findCategory) {
        em.remove(findCategory);
    }


    // 삭제할때 조회먼저
    public Optional<Category> findById(Long categoryId) {
        return Optional.ofNullable(em.find(Category.class, categoryId));
    }


//    public List<Category> findAll() {
//        return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
//
//    }
}
