package com.maptist.mappride.mappride.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController("/api/v1/subscribe")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    // 알림 연결
    @GetMapping(value = "/{member-id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter getPlacesByCategory(@PathVariable("member-id") Long memberId) {
        return notificationService.subscribe(memberId);
    }
}
