package com.maptist.mappride.mappride.place.dto;

import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.place.Place;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@ToString
@Setter
public class PlaceCopyDto {

    private final Long placeId;

    private final String name;

    private final Double latitude;

    private final Double longitude;

    private final String address;

    private final String color;

    private final String content;

    public Place toPlace(Category category) {
        return Place.builder()
                .name(name)
                .latitude(latitude)
                .longitude(longitude)
                .address(address)
                .color(color)
                .content(content)
                .category(category)
                .reg_date(LocalDateTime.now())
                .build();

    }
}
