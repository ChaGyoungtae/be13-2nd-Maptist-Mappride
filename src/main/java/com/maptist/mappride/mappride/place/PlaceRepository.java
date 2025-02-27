package com.maptist.mappride.mappride.place;

import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.place.dto.PlaceRequestDto;
import com.maptist.mappride.mappride.place.dto.PlaceResponseDto;
import com.maptist.mappride.mappride.place.dto.PlacesByCategoryResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlaceRepository {

    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    public List<PlacesByCategoryResponseDto> findPlacesByCategoryId(Long categoryId) {
        String query = "SELECT new com.maptist.mappride.mappride.place.dto.PlacesByCategoryResponseDto(p.id, p.name) " +
                        "FROM Place p " +
                        "WHERE p.category.id = :categoryId ";
        return em.createQuery(query, PlacesByCategoryResponseDto.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    public Long save(Place place) {
        em.persist(place);
        return place.getId();
    }

    public Place findOne(Long placeId){
        return em.find(Place.class, placeId);
    }

    public PlaceResponseDto findPlaceResponseDtoById(Long placeId){
            List<Object[]> result = em.createQuery(
            "SELECT p.id, p.category, p.name, p.latitude, p.longitude, " +
            "p.address, p.color, p.content, " +
            "CASE WHEN ph.thumbnail = true THEN ph.photoUrl ELSE NULL END, " + // 썸네일 URL
            "ph.photoUrl, p.reg_date " +
            "FROM Place p " +
            "LEFT JOIN Photo ph ON ph.place.id = p.id " +
            "WHERE p.id =: placeId", Object[].class)
            .setParameter("placeId", placeId)
            .getResultList();

        if (result.isEmpty()) {
            return null;
        }

        PlaceResponseDto dto = null;
        List<String> photoUrls = new ArrayList<>();
        String thumbnail = null;

        for (Object[] row : result) {
            if (dto == null) {
                dto = new PlaceResponseDto(
                        (Long) row[0], (Category) row[1], (String) row[2], (Double) row[3],
                        (Double) row[4], (String) row[5], (String) row[6], (String) row[7],
                        null,  // 썸네일 초기화
                        new ArrayList<>(),  // photoUrls 리스트 초기화
                        (LocalDateTime) row[10]
                );
            }
            String photoUrl = (String) row[9];
            String thumbnailUrl = (String) row[8];

            if (thumbnail == null && thumbnailUrl != null) {
                thumbnail = thumbnailUrl; // 첫 번째 true인 썸네일을 저장
            }
            if (photoUrl != null) {
                photoUrls.add(photoUrl);
            }
        }

        dto.getPhotoUrls().addAll(photoUrls);
        dto = new PlaceResponseDto(dto.getId(), dto.getCategory(), dto.getName(),
                dto.getLatitude(), dto.getLongitude(), dto.getAddress(),
                dto.getColor(), dto.getContent(), thumbnail, dto.getPhotoUrls(), dto.getReg_date());

        return dto;
    }

    public Long updatePlace(PlaceRequestDto placeRequestDto, String address) {

        em.createQuery("UPDATE Place p " +
                        "set p.name =: name, " +
                        "p.latitude =: latitude, " +
                        "p.longitude =: longitude, " +
                        "p.address =: address, " +
                        "p.color =: color, " +
                        "p.content =: content " +
                        "where p.id =: placeId")
                        .setParameter("name",placeRequestDto.getName())
                        .setParameter("latitude",placeRequestDto.getLatitude())
                        .setParameter("longitude",placeRequestDto.getLongitude())
                        .setParameter("address",address)
                        .setParameter("color",placeRequestDto.getColor())
                        .setParameter("content",placeRequestDto.getContent())
                        .setParameter("placeId",placeRequestDto.getPlaceId())
                        .executeUpdate();

        return placeRequestDto.getPlaceId();
    }

    public Long delete(Place place) {

        em.remove(place);

        return place.getId();
    }
}
