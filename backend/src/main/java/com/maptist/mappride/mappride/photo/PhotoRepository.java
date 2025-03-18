package com.maptist.mappride.mappride.photo;

import com.maptist.mappride.mappride.photo.dto.PhotoResponseDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
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

    public List<PhotoResponseDto> findPhotosByPlaceId(Long placeId) {
        return em.createQuery("select new com.maptist.mappride.mappride.photo.dto.PhotoResponseDto(p.id,p.photoUrl,p.thumbnail) " +
                "from Photo p " +
                "where p.place.id =: placeId", PhotoResponseDto.class)
                .setParameter("placeId", placeId)
                .getResultList();
    }

    public Photo findByThumbnail(Long placeId) {

        return em.createQuery("select p from Photo p where p.thumbnail = true and p.place.id =: placeId ", Photo.class)
                .setParameter("placeId", placeId)
                .getSingleResult();

    }

    public void thumbnailToGeneral(Long photoId) {
        em.createQuery("update Photo p " +
                "set p.thumbnail = false " +
                "where p.id =: photoId ")
                .setParameter("photoId",photoId)
                .executeUpdate();
    }

    public void generalToThumbnail(Long photoId) {
        em.createQuery("update Photo p " +
                        "set p.thumbnail = true " +
                        "where p.id = : photoId")
                .setParameter("photoId", photoId)
                .executeUpdate();
    }

    public List<Photo> findByMemberId(Long memberId) {
        return em.createQuery("select p " +
                        "from Photo p " +
                        "where p.member.id =: memberId", Photo.class)
                .setParameter("memberId", memberId)
                .getResultList();

    }
}
