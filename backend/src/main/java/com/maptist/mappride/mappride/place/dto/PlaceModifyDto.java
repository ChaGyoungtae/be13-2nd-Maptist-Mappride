package com.maptist.mappride.mappride.place.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class PlaceModifyDto {

    private final Long placeId;

    private final String name;

    private final String color;

    private final String content;
}
