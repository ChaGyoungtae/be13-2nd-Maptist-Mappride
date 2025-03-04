package com.maptist.mappride.mappride.photo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@Data
public class PhotoResponseDto {

    private final Long photoId;

    private final String photoUrl;

    private final boolean thumbnail;
}
