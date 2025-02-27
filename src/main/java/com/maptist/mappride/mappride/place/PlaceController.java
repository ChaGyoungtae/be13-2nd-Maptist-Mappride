package com.maptist.mappride.mappride.place;

import com.maptist.mappride.mappride.place.dto.PlaceRegisterDto;
import com.maptist.mappride.mappride.place.dto.PlaceRequestDto;
import com.maptist.mappride.mappride.place.dto.PlaceResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/place")
public class PlaceController {

    private final PlaceService placeService;

    @PostMapping
    public ResponseEntity<Long> createPlace(@ModelAttribute PlaceRegisterDto placeRegisterDto){
        System.out.println(placeRegisterDto);
        return ResponseEntity.ok().body(placeService.createPlace(placeRegisterDto));
    }

    @PutMapping
    public ResponseEntity<Long> modifyPlace(@RequestBody PlaceRequestDto placeRequestDto){
        return ResponseEntity.ok().body(placeService.modifyPlace(placeRequestDto));
    }

    @GetMapping("/{place-id}")
    public ResponseEntity<PlaceResponseDto> getPlace(@PathVariable("place-id") Long placeId){
        return ResponseEntity.ok().body(placeService.findById(placeId));
    }

    @DeleteMapping("/{place-id}")
    public ResponseEntity<String> deletePlace(@PathVariable("place-id") Long placeId){
        Long deletePlaceId = placeService.deletePlace(placeId);
        String deleteSuccess = "delete place( " + deletePlaceId + " ) is success";
        return ResponseEntity.ok().body(deleteSuccess);
    }
}
