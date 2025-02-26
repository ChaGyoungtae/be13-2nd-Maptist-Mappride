package com.maptist.mappride.mappride.photo;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PhotoRepository {

    private final EntityManager em;

    public Long create(Photo photo){
        em.persist(photo);

        return photo.getId();
    }
}
