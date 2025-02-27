package com.maptist.mappride.mappride.place.dto;

import com.maptist.mappride.mappride.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class PlaceRequestDto {

    private final Long placeId;

    private final String name;

    private final Double latitude;

    private final Double longitude;

    private final String color;

    private final String content;

}
