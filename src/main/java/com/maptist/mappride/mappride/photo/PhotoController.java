package com.maptist.mappride.mappride.photo;

import com.maptist.mappride.mappride.config.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/photo")
public class PhotoController {

    private final S3Service s3Service;

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestBody MultipartFile multipartFile) {
        return ResponseEntity.ok((s3Service.uploadFile(multipartFile)));
    }

    @DeleteMapping("/delete-image")
    public ResponseEntity<String> deleteImage(@RequestParam("fileName") String fileName){
        s3Service.deleteFile(fileName);
        return ResponseEntity.ok().body("delete Suceess");
    }

}
