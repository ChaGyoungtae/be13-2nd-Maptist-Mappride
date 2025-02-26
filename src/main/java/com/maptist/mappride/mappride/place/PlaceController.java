package com.maptist.mappride.mappride.place;

import com.maptist.mappride.mappride.place.dto.PlaceRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/place")
public class PlaceController {

    private final PlaceService placeService;

    @PostMapping
    public ResponseEntity<Long> createPlace(@RequestBody PlaceRequestDto placeRequestDto){

        return ResponseEntity.ok().body(placeService.createPlace(placeRequestDto));
    }
}
