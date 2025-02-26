package com.maptist.mappride.mappride.config.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.maptist.mappride.mappride.config.jwt.DTO.SecurityUserDto;
import com.maptist.mappride.mappride.member.MemberRepository;
import com.maptist.mappride.mappride.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;
    private final MemberRepository memberRepository;
    private final MemberService memberService;


    //여러사진 저장
    public List<String> uploadFiles(List<MultipartFile> multipartFiles) {

        List<String> fileNameList = new ArrayList<>();
        // forEach 를 통해 파일들을 순차적으로 fileNameList 에 추가
        multipartFiles.forEach(file -> {

            String fileName = createFileName(file.getOriginalFilename());
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setContentType(file.getContentType());

        try(InputStream inputStream = file.getInputStream()){
            amazonS3.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다.");
        }
        fileNameList.add(fileName);
        });

        return fileNameList;
    }

    //사진 1장 저장
    public String uploadFile(MultipartFile multipartFile){

        if (multipartFile == null || multipartFile.isEmpty()) {
            return null;
        }

        SecurityUserDto principal = (SecurityUserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = memberRepository.findByEmail(principal.getEmail()).get().getId();
        String fileName = createFileName(multipartFile.getOriginalFilename());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFile.getSize());
        objectMetadata.setContentType(multipartFile.getContentType());

        try(InputStream inputStream = multipartFile.getInputStream()){
            amazonS3.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다.");
        }

        return fileName;
    }


    //대표 사진 저장
    public String uploadThumbnail(MultipartFile multipartFile, Long placeId){

    if (multipartFile == null || multipartFile.isEmpty()) {
        return null;
    }
    SecurityUserDto principal = (SecurityUserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Long userId = memberRepository.findByEmail(principal.getEmail()).get().getId();
    String fileName ="thumbnail_" + createFileName(multipartFile.getOriginalFilename());
    ObjectMetadata objectMetadata = new ObjectMetadata();
    objectMetadata.setContentLength(multipartFile.getSize());
    objectMetadata.setContentType(multipartFile.getContentType());

    try(InputStream inputStream = multipartFile.getInputStream()){
        amazonS3.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    } catch (IOException e){
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다.");
    }

    return fileName;
}




    //파일명 난수화를 위한 UUID 생성
    public String createFileName(String fileName){
        return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }

    // "."의 존재 유무 판단
    private String getFileExtension(String fileName){
        try{
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 형식의 파일" + fileName + ") 입니다. ");
        }
    }

    public void deleteFile(String fileName){
        amazonS3.deleteObject(new DeleteObjectRequest(bucket, fileName));
        System.out.println(bucket);
    }
}
