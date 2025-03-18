package com.maptist.mappride.mappride.place.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PlacesByCategoryResponseDto {

    private final Long placeId;
    private final String name;
}
