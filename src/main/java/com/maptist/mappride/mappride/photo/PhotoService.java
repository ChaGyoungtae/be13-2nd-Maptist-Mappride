package com.maptist.mappride.mappride.photo;

import com.amazonaws.services.s3.AmazonS3;
import com.maptist.mappride.mappride.config.s3.S3Service;
import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.member.MemberService;
import com.maptist.mappride.mappride.photo.dto.PhotoAddRequestDto;
import com.maptist.mappride.mappride.photo.dto.PhotoResponseDto;
import com.maptist.mappride.mappride.place.Place;
import com.maptist.mappride.mappride.place.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final MemberService memberService;
    private final PlaceRepository placeRepository;
    private final S3Service s3Service;
    private final AmazonS3 amazonS3;

    public Long save(Photo photo) {
        return photoRepository.create(photo);
    }

    public void deletePhoto(Long id) {

        Photo findPhoto = photoRepository.findById(id);
        if(findPhoto.getMember() != memberService.getMember()){
            throw new RuntimeException("본인의 사진만 삭제할 수 있습니다.");
        }

        s3Service.deleteFile(findPhoto.getPhotoUrl());

        photoRepository.remove(photoRepository.findById(id));
    }

    public List<PhotoResponseDto> getPhotosByPlaceId(Long placeId) {
        return photoRepository.findPhotosByPlaceId(placeId);
    }

    public List<Long> addPhotos(PhotoAddRequestDto photoAddRequestDto) {

        Member member = memberService.getMember();
        Place place = placeRepository.findOne(photoAddRequestDto.getPlaceId());

        List<Long> photoIds = new ArrayList<>();

        for(MultipartFile multipartFile: photoAddRequestDto.getMultipartFiles()){
            Photo photo = photoAddRequestDto.addPhoto(member, place, amazonS3.getUrl("mappride-bucket",s3Service.uploadFile(multipartFile)).toString());
            photoIds.add(photoRepository.create(photo));
        }

        return photoIds;
    }

    public Long changeThumbnail(Long photoId) {

        // 해당 Place 가져오기
        Place place = placeRepository.findByPhotoId(photoId);
        // 기존 썸네일 가져와서 일반사진으로 변경
        Photo prevThumbnail = photoRepository.findByThumbnail(place.getId());
        photoRepository.thumbnailToGeneral(prevThumbnail.getId());

        // 정한 사진 썸네일로 변경
        photoRepository.generalToThumbnail(photoId);

        return photoId;
    }

    public void copyPhoto(Long prevPlaceId, Member member, Place place){
        List<PhotoResponseDto> photoResponseDtos = photoRepository.findPhotosByPlaceId(prevPlaceId);
        MultipartFile multipartFile = null;
        for(PhotoResponseDto photoResponseDto: photoResponseDtos){

            try{
                String fileName = s3Service.getFileNameFromUrl(photoResponseDto.getPhotoUrl());
                multipartFile = s3Service.getFileAsMultipartFile(s3Service.getBucket(), fileName);
            } catch (IOException ex){
                ex.printStackTrace();
                log.error("이미지 불러오기 실패");
            } finally {
                s3Service.uploadFile(multipartFile);
                Photo photo = photoResponseDto.toPhoto(member,place);
                photoRepository.create(photo);
            }
        }
    }

}
