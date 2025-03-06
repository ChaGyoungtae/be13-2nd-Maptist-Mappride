package com.maptist.mappride.mappride.place.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class PlacePreviewResponseDto {
    private final String name;
    private final String address;
    private final String color;
    private final String content;
    private final String thumbnail;
    private final List<String> photoUrls;

}
