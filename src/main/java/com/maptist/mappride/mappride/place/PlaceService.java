package com.maptist.mappride.mappride.place;

import com.amazonaws.services.s3.AmazonS3;
import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.category.CategoryRepository;
import com.maptist.mappride.mappride.config.s3.S3Service;
import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.member.MemberService;
import com.maptist.mappride.mappride.photo.Photo;
import com.maptist.mappride.mappride.photo.PhotoRepository;
import com.maptist.mappride.mappride.photo.PhotoService;
import com.maptist.mappride.mappride.photo.dto.PhotoRequestDto;
import com.maptist.mappride.mappride.place.dto.PlaceRegisterDto;
import com.maptist.mappride.mappride.place.dto.PlaceRequestDto;
import com.maptist.mappride.mappride.place.dto.PlaceResponseDto;
import com.maptist.mappride.mappride.place.dto.PlacesByCategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
    private final PhotoRepository photoRepository;


    public List<PlacesByCategoryResponseDto> findPlacesByCategory(Long categoryId) {
        return placeRepository.findPlacesByCategoryId(categoryId);
    }

    @Transactional
    public Long createPlace(PlaceRegisterDto placeRegisterDto) {

        System.out.println(placeRegisterDto);

        Optional<Category> findCategory = categoryRepository.findById(placeRegisterDto.getCategoryId());

        if(findCategory.isEmpty()){
            throw new RuntimeException("카테고리를 찾을 수 없습니다.");
        }

        //System.out.println(findCategory.get().getName());

        String address = naverGeocodingService.getAddressFromCoordinates(placeRegisterDto.getLatitude(), placeRegisterDto.getLongitude());

        Place place = placeRegisterDto.toPlace(findCategory.get(),address, LocalDateTime.now());
        Long placeId = placeRepository.save(place);

        Member member = memberService.getMember();

        MultipartFile thumbnail;
        MultipartFile multipartFile;
        String fileName;
        boolean isThumbnail;

        for(int i = -1; i< placeRegisterDto.getMultipartFiles().size(); i++){
            if(i == -1) {
                thumbnail = placeRegisterDto.getThumbnail();
                fileName = s3Service.uploadFile(thumbnail);
                isThumbnail = true;
            }
            else {
                multipartFile = placeRegisterDto.getMultipartFiles().get(i);
                fileName = s3Service.uploadFile(multipartFile);
                isThumbnail = false;
            }
            PhotoRequestDto photoRequestDto = new PhotoRequestDto(amazonS3.getUrl("mappride-bucket",fileName).toString(),isThumbnail);
            Photo photo = photoRequestDto.toPhoto(member,place);
            photoService.save(photo);
        }

        return placeId;
    }

    public PlaceResponseDto findById(Long placeId) {

        return placeRepository.findPlaceResponseDtoById(placeId);
    }

    @Transactional
    public Long modifyPlace(PlaceRequestDto placeRequestDto) {
        String address = naverGeocodingService.getAddressFromCoordinates(placeRequestDto.getLatitude(), placeRequestDto.getLongitude());
        return placeRepository.updatePlace(placeRequestDto, address);
    }

    @Transactional
    public Long deletePlace(Long placeId) {
        // placeId를 이용해 사진 리스트 가져오기
        List<Photo> photoList = photoRepository.findByPlaceId(placeId);
        // 사진 지우고, photo 테이블 지우고
        for(Photo p : photoList){
            s3Service.deleteFile(p.getPhotoUrl());
            photoRepository.remove(p);
        }
        // place 지우기
        Place place = placeRepository.findOne(placeId);
        return placeRepository.delete(place);
    }
}
