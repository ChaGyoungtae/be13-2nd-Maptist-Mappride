package com.maptist.mappride.mappride.photo;

import com.maptist.mappride.mappride.config.s3.S3Service;
import com.maptist.mappride.mappride.photo.dto.PhotoAddRequestDto;
import com.maptist.mappride.mappride.photo.dto.PhotoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/photo")
public class PhotoController {

    private final S3Service s3Service;
    private final PhotoService photoService;

    @PostMapping("s3/upload-image")
    public ResponseEntity<String> uploadImage(@RequestBody MultipartFile multipartFile) {
        return ResponseEntity.ok((s3Service.uploadFile(multipartFile)));
    }

    @DeleteMapping("s3/delete-image/{file-name}")
    public ResponseEntity<String> deleteImage(@PathVariable("file-name") String fileName){
        s3Service.deleteFile(fileName);
        return ResponseEntity.ok().body("delete Success");
    }

    @DeleteMapping("/{photo-id}")
    public void deletePhoto(@PathVariable("photo-id") Long id){
        photoService.deletePhoto(id);
    }

    //장소별 모든 사진 가져오기
    @GetMapping("/{place-id}")
    public ResponseEntity<List<PhotoResponseDto>> getPhotosByPlaceId(@PathVariable("place-id") Long placeId){
        return ResponseEntity.ok().body(photoService.getPhotosByPlaceId(placeId));
    }

    // 사진 추가하기
    @PostMapping("/upload-photos")
    public ResponseEntity<List<Long>> addPhoto(@ModelAttribute PhotoAddRequestDto photoAddRequestDto){
        return ResponseEntity.ok().body(photoService.addPhotos(photoAddRequestDto));
    }

    // 대표사진 변경
    @GetMapping("/thumbnail/{photo-id}")
    public ResponseEntity<Long> changeThumbnail(@PathVariable("photo-id") Long photoId){
        return ResponseEntity.ok().body(photoService.changeThumbnail(photoId));
    }

}
