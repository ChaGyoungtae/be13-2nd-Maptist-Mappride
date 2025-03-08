package com.maptist.mappride.mappride.place;

import com.maptist.mappride.mappride.place.dto.PlaceCopyRequestDto;
import com.maptist.mappride.mappride.place.dto.PlacePreviewResponseDto;
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

    @PostMapping("/copy")
    public ResponseEntity<Long> copyPlace(@RequestBody PlaceCopyRequestDto placeCopyRequestDto){
        return ResponseEntity.ok().body(placeService.copyPlace(placeCopyRequestDto));
    }

    @GetMapping("/{place-id}/preview")
    public ResponseEntity<PlacePreviewResponseDto> getPlacePreview(@PathVariable("place-id") Long placeId) {

        PlacePreviewResponseDto placePreviewResponseDto = placeService.getPlacePreview(placeId);
        return ResponseEntity.ok().body(placePreviewResponseDto);
    }

    // 조회된 유저의 모든 장소중 하나를 클릭하면 장소의 상세정보 제공
    @GetMapping("/details/{place-id}")
    public ResponseEntity<PlaceResponseDto> getPlaceDetailsByPlaceId(@PathVariable("place-id") long placeId) {
        PlaceResponseDto placeResponseDto = placeService.getPlaceById(placeId);
        return ResponseEntity.ok().body(placeResponseDto);
    }
}
