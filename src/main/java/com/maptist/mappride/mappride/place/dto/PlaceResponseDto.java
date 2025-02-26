package com.maptist.mappride.mappride.place.dto;


import com.maptist.mappride.mappride.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceResponseDto {
    private Long id;

    private Category category;

    private String name;

    private Double latitude;

    private Double longitude;

    private String address;

    private String color;

    private String content;

    private LocalDateTime reg_date;


    public PlaceResponseDto(Long id, Category category, String name, Double latitude, Double longitude, String address, String color, String content) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.color = color;
        this.content = content;
    }

}
