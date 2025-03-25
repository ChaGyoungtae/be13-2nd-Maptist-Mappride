package com.maptist.mappride.mappride.place.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class PlacesByCategoryResponseDto {

    private final Long placeId;
    private final Long categoryId;
    private final String name;
    private final Double latitude;
    private final Double longitude;
    private final String address;
    private final String color;
    private final String content;
    private final LocalDateTime reg_date;
}
