package com.maptist.mappride.mappride.categoryByMember;

import com.maptist.mappride.mappride.categoryByMember.DTO.CategoryByMemberResponseDto;
import com.maptist.mappride.mappride.member.MemberService;
import com.maptist.mappride.mappride.place.PlaceService;
import com.maptist.mappride.mappride.place.dto.PlaceInfoDto;
import com.maptist.mappride.mappride.place.dto.PlaceResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories-by-member")
public class CategoryByMemberController {

    private final MemberService memberService;
    private final PlaceService placeService;


    // 멤버의 카테고리를 조회해와서 카테고리 별 장소를 조회한다
    @GetMapping("/places")
    public ResponseEntity<List<List<PlaceInfoDto>>> findPlacesByCategories() {
        List<CategoryByMemberResponseDto> memberCategories = memberService.searchCategories();

        if (memberCategories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        else {
            List<List<PlaceInfoDto>> places = new ArrayList<>();
            for (CategoryByMemberResponseDto category : memberCategories) {
                List<PlaceInfoDto> placesInfo = placeService.getPlacesByCategoryId(category.getCategoryId());
                places.add(placesInfo);
            }
            return ResponseEntity.ok().body(places);
        }
    }
    // 조회된 유저의 모든 장소중 하나를 클릭하면 장소의 상세정보 제공
    @GetMapping("/places/{place-id}")
    public ResponseEntity<PlaceResponseDto> getPlaceDetailsByPlaceId(@PathVariable("place-id") long placeId) {
        PlaceResponseDto placeResponseDto = placeService.getPlaceById(placeId);
        return ResponseEntity.ok().body(placeResponseDto);
    }
}
