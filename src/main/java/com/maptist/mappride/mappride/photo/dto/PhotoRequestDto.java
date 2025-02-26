package com.maptist.mappride.mappride.photo.dto;

import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.photo.Photo;
import com.maptist.mappride.mappride.place.Place;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Getter
@ToString
@Data
public class PhotoRequestDto {

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
