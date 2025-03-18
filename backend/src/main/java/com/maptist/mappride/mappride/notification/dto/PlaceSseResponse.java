package com.maptist.mappride.mappride.notification.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Builder
public class PlaceSseResponse {
    private final String nickname;
    private final String placeName;
}
