package com.maptist.mappride.mappride.place;

import com.amazonaws.services.s3.AmazonS3;
import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.category.CategoryRepository;
import com.maptist.mappride.mappride.comment.Comment;
import com.maptist.mappride.mappride.comment.CommentRepository;
import com.maptist.mappride.mappride.config.s3.S3Service;
import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.member.MemberService;
import com.maptist.mappride.mappride.notification.NotificationService;
import com.maptist.mappride.mappride.notification.dto.CategorySseResponse;
import com.maptist.mappride.mappride.notification.dto.PlaceSseResponse;
import com.maptist.mappride.mappride.photo.Photo;
import com.maptist.mappride.mappride.photo.PhotoRepository;
import com.maptist.mappride.mappride.photo.PhotoService;
import com.maptist.mappride.mappride.photo.dto.PhotoRequestDto;
import com.maptist.mappride.mappride.place.dto.PlaceCopyDto;
import com.maptist.mappride.mappride.place.dto.PlaceCopyRequestDto;
import com.maptist.mappride.mappride.place.dto.PlacePreviewResponseDto;
import com.maptist.mappride.mappride.place.dto.PlaceRegisterDto;
import com.maptist.mappride.mappride.place.dto.PlaceRequestDto;
import com.maptist.mappride.mappride.place.dto.PlaceResponseDto;
import com.maptist.mappride.mappride.place.dto.PlacesByCategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
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
    private final NotificationService notificationService;
    private final CommentRepository commentRepository;


    public List<PlacesByCategoryResponseDto> findPlacesByCategory(Long categoryId) {

        Member member = memberService.getMember();
        String nickname = member.getNickname();
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isEmpty()){
            throw new RuntimeException("카테고리 조회 실패");
        }
        // member 카테고리 작성자가 다른 경우, 타인이 조회하는 중이므로 알림을 보낸다.
        Category findCbm = categoryRepository.findByMemberIdAndCategoryId(member.getId(),category.get().getId());
        if(findCbm.getMember() != member){
            // 조회알림 dto 만들어서 알림 보내기
            String categoryName = category.get().getName();
            CategorySseResponse categorySseResponse = CategorySseResponse.builder()
                    .categoryName(categoryName)
                    .nickname(nickname)
                    .build();
            notificationService.customNotify(member.getId(),categorySseResponse, nickname + "님이 당신의 "+ categoryName +" 카테고리를 조회했습니다.", "show");
            // 알림받은 사용자의 scrapCnt + 1
            memberService.plusScrapCnt(category.get().getId());
        }
        return placeRepository.findPlacesByCategoryId(categoryId);
    }

    @Transactional
    public Long createPlace(PlaceRegisterDto placeRegisterDto) {

        System.out.println(placeRegisterDto);

        Optional<Category> findCategory = categoryRepository.findById(placeRegisterDto.getCategoryId());

        if(findCategory.isEmpty()){
            throw new RuntimeException("카테고리를 찾을 수 없습니다.");
        }

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

        Place place = placeRepository.findOne(placeId);


        // placeId를 이용해 사진 리스트 가져오기
        List<Photo> photoList = photoRepository.findByPlaceId(placeId);

        if( memberService.getMember() != photoList.get(0).getMember()){
            throw new RuntimeException("본인의 장소만 삭제할 수 있습니다.");
        }

        // 사진 지우고, photo 테이블 지우기
        for(Photo p : photoList){
            s3Service.deleteFile(p.getPhotoUrl());
            photoRepository.remove(p);
        }

        // placeId를 이용해 댓글 리스트 가져오기
        List<Comment> commentList = commentRepository.findByPlaceId(placeId);

        // 댓글 지우기
        for(Comment c: commentList){
            commentRepository.delete(c);
        }

        // place 지우기
        return placeRepository.delete(place);
    }

    @Transactional
    public Long copyPlace(PlaceCopyRequestDto placeCopyRequestDto) {

        // placeId를 이용해 아이디, 카테고리 id를 제외한 place 테이블의 데이터 가져오기,
        // category - findById 로 가져와서 매핑해서 db에 저장,
        // photo도 placeId로 조회해와서 넣기
        Member member = memberService.getMember();
        Optional<Category> category = categoryRepository.findById(placeCopyRequestDto.getCategoryId());
        if(category.isEmpty()) {
            throw new RuntimeException("category 조회 실패");
        }

        PlaceCopyDto placeCopyDto = placeRepository.findPlaceCopyDtoById(placeCopyRequestDto.getPlaceId());
        Place place = placeCopyDto.toPlace(category.get());
        Long placeId = placeRepository.save(place);

        photoService.copyPhoto(placeCopyDto.getPlaceId(), member, place);
        String nickname = member.getNickname();
        String placeName = place.getName();
        // 복사 알림 dto 만들어서 알림 전송
        PlaceSseResponse placeSseResponse = PlaceSseResponse.builder()
                .nickname(nickname)
                .placeName(placeName)
                .build();

        notificationService.customNotify(member.getId(), placeSseResponse, nickname + "님이 당신의 " + placeName + " 을(를) 복사 했습니다.","copy");

        // 알림받은 사용자의 scrapCnt + 1
        memberService.plusScrapCnt(category.get().getId());

        return placeId;
    }
    // preview를 return
    public PlacePreviewResponseDto getPlacePreview(Long placeId) {
        return placeRepository.findPlacePreviewById(placeId);
    }

//    // 특정 카테고리 장소들 리스트를 return -- cbm 에서 쓰던거라 쓸일없지만~ 사람일은 모르니께
//    public List<PlaceInfoDto> getPlacesByCategoryId(long categoryId) {
//
//        return placeRepository.findPlacesInfoByCategoryId(categoryId);
//    }

    // place Id로부터 place 정보 조회
    public PlaceResponseDto getPlaceById(long placeId) {
        return placeRepository.findPlaceResponseDtoById(placeId);
    }

}
