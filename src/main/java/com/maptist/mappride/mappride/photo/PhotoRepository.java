package com.maptist.mappride.mappride.photo;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PhotoRepository {

    private final EntityManager em;

    public Long create(Photo photo){
        em.persist(photo);

        return photo.getId();
    }

    public List<Photo> findByPlaceId(Long placeId){
        return em.createQuery("select p " +
                        "from Photo p " +
                        "where p.place.id =: placeId ", Photo.class)
                .setParameter("placeId", placeId)
                .getResultList();
    }

    public void remove(Photo p) {
        em.remove(p);
    }

    public Photo findById(Long id) {
        return em.find(Photo.class,id);
    }
}
