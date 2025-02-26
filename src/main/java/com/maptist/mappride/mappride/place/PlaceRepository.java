package com.maptist.mappride.mappride.place;

import com.maptist.mappride.mappride.place.dto.PlaceResponseDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlaceRepository {

    private final EntityManager em;

    public List<PlaceResponseDto> findPlacesByCategoryId(Long categoryId) {
        String query = "SELECT new com.maptist.mappride.mappride.place.dto.PlaceResponseDto(p.id, p.category, p.name, p.latitude, p.longitude, p.address, p.color, p.content) FROM Place p WHERE p.category.id = :categoryId";
        return em.createQuery(query, PlaceResponseDto.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    public Long save(Place place) {
        em.persist(place);
        return place.getId();
    }
}
