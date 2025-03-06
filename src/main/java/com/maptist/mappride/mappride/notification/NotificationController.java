package com.maptist.mappride.mappride.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    // 카테고리 별 장소 조회
    @GetMapping(value = "/{category-id}/places", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter getPlacesByCategory(@PathVariable Long categoryId) {
        return notificationService.getPlacesByCategory(categoryId);
    }
}
