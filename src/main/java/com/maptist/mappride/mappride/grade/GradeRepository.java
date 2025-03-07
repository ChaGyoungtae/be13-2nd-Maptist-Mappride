package com.maptist.mappride.mappride.grade;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GradeRepository {

    private final EntityManager em;

    public Long create(Grade grade){
        em.persist(grade);
        return grade.getId();
    }

    public Grade findBeginner(){
        String name = "비기너";
        return em.createQuery("select g " +
                        "from Grade g " +
                        "where g.name =: name", Grade.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<Grade> findAll(){
        return em.createQuery("select g " +
                        "from Grade g " +
                        "order by g.reviewCnt asc ",Grade.class)
                .getResultList();
    }
}
