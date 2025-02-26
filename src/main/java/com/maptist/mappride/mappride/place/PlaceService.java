package com.maptist.mappride.mappride.place;

import com.amazonaws.services.s3.AmazonS3;
import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.category.CategoryRepository;
import com.maptist.mappride.mappride.config.s3.S3Service;
import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.member.MemberService;
import com.maptist.mappride.mappride.photo.Photo;
import com.maptist.mappride.mappride.photo.PhotoService;
import com.maptist.mappride.mappride.photo.dto.PhotoRequestDto;
import com.maptist.mappride.mappride.place.dto.PlaceRequestDto;
import com.maptist.mappride.mappride.place.dto.PlaceResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final CategoryRepository categoryRepository;
    private final NaverGeocodingService naverGeocodingService;
    private final S3Service s3Service;
    private final AmazonS3 amazonS3;
    private final MemberService memberService;
    private final PhotoService photoService;


    public List<PlaceResponseDto> findPlacesByCategory(Long categoryId) {
        return placeRepository.findPlacesByCategoryId(categoryId);
    }

    public Long createPlace(PlaceRequestDto placeRequestDto) {

        System.out.println(placeRequestDto);

        Optional<Category> findCategory = categoryRepository.findById(placeRequestDto.getCategoryId());

        if(findCategory.isEmpty()){
            throw new RuntimeException("카테고리를 찾을 수 없습니다.");
        }

        //System.out.println(findCategory.get().getName());

        String address = naverGeocodingService.getAddressFromCoordinates(placeRequestDto.getLatitude(), placeRequestDto.getLongitude());

        Place place = placeRequestDto.toPlace(findCategory.get(),address, LocalDateTime.now());
        Long placeId = placeRepository.save(place);

        Member member = memberService.getMember();

        MultipartFile thumbnail;
        MultipartFile multipartFile;
        String fileName;
        boolean isThumbnail;

        for(int i = -1; i< placeRequestDto.getMultipartFiles().size(); i++){
            if(i == -1) {
                thumbnail = placeRequestDto.getThumbnail();
                fileName = s3Service.uploadFile(thumbnail);
                isThumbnail = true;
            }
            else {
                multipartFile = placeRequestDto.getMultipartFiles().get(i);
                fileName = s3Service.uploadFile(multipartFile);
                isThumbnail = false;
            }
            PhotoRequestDto photoRequestDto = new PhotoRequestDto(amazonS3.getUrl("mappride-bucket",fileName).toString(),isThumbnail);
            Photo photo = photoRequestDto.toPhoto(member,place);
            photoService.save(photo);
        }

        return placeId;
    }
}
