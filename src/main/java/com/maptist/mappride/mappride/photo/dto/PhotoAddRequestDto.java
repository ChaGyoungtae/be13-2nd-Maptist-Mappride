package com.maptist.mappride.mappride.photo.dto;

import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.photo.Photo;
import com.maptist.mappride.mappride.place.Place;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PhotoAddRequestDto {

    private final Long placeId;

    //private final List<MultipartFile> multipartFiles;


    public Photo addPhoto(Member member, Place place, String photoUrl){
        return Photo.builder()
                .member(member)
                .place(place)
                .thumbnail(false)
                .photoUrl(photoUrl)
                .build();
    }

}
