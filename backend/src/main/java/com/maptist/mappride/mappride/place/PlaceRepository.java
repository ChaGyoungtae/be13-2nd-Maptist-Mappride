package com.maptist.mappride.mappride.place;

import com.maptist.mappride.mappride.place.dto.PlaceCopyDto;
import com.maptist.mappride.mappride.place.dto.PlaceInfoDto;
import com.maptist.mappride.mappride.place.dto.PlaceModifyDto;
import com.maptist.mappride.mappride.place.dto.PlacePreviewResponseDto;
import com.maptist.mappride.mappride.place.dto.PlaceRequestDto;
import com.maptist.mappride.mappride.place.dto.PlaceResponseDto;
import com.maptist.mappride.mappride.place.dto.PlacesByCategoryResponseDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PlaceRepository {

    private final EntityManager em;

    public List<PlacesByCategoryResponseDto> findPlacesByCategoryId(Long categoryId) {
        String query = "SELECT new com.maptist.mappride.mappride.place.dto.PlacesByCategoryResponseDto(" +
                "p.id, " +
                "p.category.id," +
                "p.name, " +
                "p.latitude, " +
                "p.longitude, " +
                "p.address, " +
                "p.color, " +
                "p.content, " +
                "p.reg_date," +
                "ph.photoUrl" +
                ") " +
                "FROM Place p " +
                "LEFT JOIN Photo ph ON ph.place.id = p.id " +
                "WHERE p.category.id = :categoryId";
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
            "SELECT p.id, p.category.id, p.name, p.latitude, p.longitude, " +
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
                        (Long) row[0], (Long) row[1], (String) row[2], (Double) row[3],
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
        dto = new PlaceResponseDto(dto.getId(), dto.getCategoryId(), dto.getName(),
                dto.getLatitude(), dto.getLongitude(), dto.getAddress(),
                dto.getColor(), dto.getContent(), thumbnail, dto.getPhotoUrls(), dto.getReg_date());

        return dto;
    }

    public Long updatePlace(PlaceModifyDto placeRequestDto) {

        em.createQuery("UPDATE Place p " +
                        "set p.name =: name, " +
                        "p.color =: color, " +
                        "p.content =: content " +
                        "where p.id =: placeId")
                        .setParameter("name",placeRequestDto.getName())
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

    public List<PlaceCopyDto> findPlaceCopyDtoByCategoryId(Long categoryId) {

        return em.createQuery("select new com.maptist.mappride.mappride.place.dto.PlaceCopyDto(" +
                        "p.id, " +
                        "p.name," +
                        " p.latitude," +
                        " p.longitude," +
                        " p.address," +
                        " p.color," +
                        " p.content) " +
                "from Place p " +
                "where p.category.id =: categoryId ", PlaceCopyDto.class)
                .setParameter("categoryId", categoryId)
                .getResultList();

    }

    public PlaceCopyDto findPlaceCopyDtoById(Long placeId) {

        return em.createQuery("select new com.maptist.mappride.mappride.place.dto.PlaceCopyDto(" +
                        "p.id, " +
                        "p.name," +
                        " p.latitude," +
                        " p.longitude," +
                        " p.address," +
                        " p.color," +
                        " p.content) " +
                "from Place p " +
                "where p.id =: placeId ", PlaceCopyDto.class)
                .setParameter("placeId", placeId)
                .getSingleResult();

    }

    public Place findByPhotoId(Long photoId) {
        return em.createQuery("select p " +
                        "from Photo ph " +
                        "join Place p on p.id = ph.place.id " +
                        "where ph.id =: photoId", Place.class)
                .setParameter("photoId", photoId)
                .getSingleResult();
    }

    public PlacePreviewResponseDto findPlacePreviewById(Long placeId) {

        String query = "SELECT new com.maptist.mappride.mappride.place.dto.PlacePreviewResponseDto(" +
                "p.name, p.address, p.color," +
                "(SELECT ph2.photoUrl FROM Photo ph2 WHERE ph2.place.id = p.id AND ph2.thumbnail = true ORDER BY ph2.id DESC LIMIT 1)" +
                ") " +
                "FROM Place p " +
                "LEFT JOIN Photo ph ON ph.place.id = p.id " +
                "WHERE p.id = :placeId";


        return em.createQuery(query, PlacePreviewResponseDto.class)
                .setParameter("placeId", placeId).
                getSingleResult();
    }

    public List<Place> findByCategoryId(Long categoryId) {
        return em.createQuery("select p " +
                        "from Place p " +
                        "where p.category.id =: categoryId", Place.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    public List<PlaceInfoDto> findPlacesInfoByCategoryId(long categoryId) {

        return em.createQuery(
                "select new com.maptist.mappride.mappride.place.dto.PlaceInfoDto(p.id, p.name, p.address)" +
                        "from Place p " +
                        "where p.category.id =: categoryId", PlaceInfoDto.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    public Optional<Place> findByName(String name) {
        return Optional.ofNullable(em.createQuery("select p " +
                        "from Place p " +
                        "where p.name =: placeName ", Place.class)
                .setParameter("placeName", name)
                .getSingleResult());
    }
}























