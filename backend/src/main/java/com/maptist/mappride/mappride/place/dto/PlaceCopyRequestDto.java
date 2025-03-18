package com.maptist.mappride.mappride.place.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class PlaceCopyRequestDto {
    private final Long placeId;
    private final Long categoryId;
}
