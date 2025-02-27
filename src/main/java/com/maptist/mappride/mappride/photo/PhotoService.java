package com.maptist.mappride.mappride.photo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class PhotoService {

    private final PhotoRepository photoRepository;

    public Long save(Photo photo) {
        return photoRepository.create(photo);
    }

    public void deletePhoto(Long id) {
        photoRepository.remove(photoRepository.findById(id));
    }
}
