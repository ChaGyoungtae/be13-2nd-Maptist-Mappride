package com.maptist.mappride.mappride.place.dto;


import com.maptist.mappride.mappride.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

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

    private String thumbnail;

    private List<String> photoUrls;

    private LocalDateTime reg_date;

}
