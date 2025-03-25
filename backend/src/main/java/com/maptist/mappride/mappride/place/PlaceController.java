package com.maptist.mappride.mappride.place;

import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.category.CategoryService;
import com.maptist.mappride.mappride.category.dto.CategoryDto;
import com.maptist.mappride.mappride.place.dto.PlaceCopyRequestDto;
import com.maptist.mappride.mappride.place.dto.PlacePreviewResponseDto;
import com.maptist.mappride.mappride.place.dto.PlaceRegisterDto;
import com.maptist.mappride.mappride.place.dto.PlaceRequestDto;
import com.maptist.mappride.mappride.place.dto.PlaceResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/place")
public class PlaceController {

    private final PlaceService placeService;

    private final CategoryService categoryService;


    // 장소 생성 페이지 getMapping
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categories = categoryService.findCategoryDtoByMemberId();
        return ResponseEntity.ok().body(categories);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Long> createPlace(@RequestPart MultipartFile thumbnail,
                                            @RequestPart List<MultipartFile> multipartFiles,
                                            @ModelAttribute PlaceRegisterDto placeRegisterDto) {
        System.out.println("Received DTO: " + placeRegisterDto);
        // 서비스 호출해서 실제 저장 처리
        Long placeId = placeService.createPlace(thumbnail, multipartFiles, placeRegisterDto);
        return ResponseEntity.ok().body(placeId);
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

        if (placePreviewResponseDto == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok().body(placePreviewResponseDto);
    }

    // 조회된 유저의 모든 장소중 하나를 클릭하면 장소의 상세정보 제공
    @GetMapping("/details/{place-id}")
    public ResponseEntity<PlaceResponseDto> getPlaceDetailsByPlaceId(@PathVariable("place-id") long placeId) {
        PlaceResponseDto placeResponseDto = placeService.getPlaceById(placeId);
        return ResponseEntity.ok().body(placeResponseDto);
    }
}
