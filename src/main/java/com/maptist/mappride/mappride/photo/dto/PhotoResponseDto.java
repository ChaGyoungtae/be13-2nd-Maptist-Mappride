package com.maptist.mappride.mappride.photo.dto;

import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.photo.Photo;
import com.maptist.mappride.mappride.place.Place;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Data
public class PhotoResponseDto {

    private final Long photoId;

    private final String photoUrl;

    private final boolean thumbnail;

    public Photo toPhoto(Member member, Place place){
        return Photo.builder()
                .member(member)
                .place(place)
                .photoUrl(photoUrl)
                .thumbnail(thumbnail)
                .build();
    }
}
