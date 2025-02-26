package com.maptist.mappride.mappride.place.dto;

import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.place.Place;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceRequestDto {
    private Long categoryId;

    private String name;

    private Double latitude;

    private Double longitude;

    private String color;

    private String content;

    private MultipartFile thumbnail;

    private List<MultipartFile> multipartFiles;

    public Place toPlace(Category category, String address, LocalDateTime regDate){

        return Place.builder()
                .category(category)
                .name(name)
                .latitude(latitude)
                .longitude(longitude)
                .address(address)
                .color(color)
                .content(content)
                .reg_date(regDate)
                .build();
    }

}
