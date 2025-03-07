package com.maptist.mappride.mappride.notification;

import com.maptist.mappride.mappride.categoryByMember.CategoryByMemberRepository;
import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final MemberRepository memberRepository;
    private final EmitterRepository emitterRepository;

    private static final Long DEFAULT_TIMEOUT = 600L * 1000 * 60;

    public SseEmitter subscribe(Long memberId) {

        SseEmitter emitter = createEmitter(memberId);
        sendToClient(memberId, "EventStream Created. [userId="+ memberId + "]", "sse 접속 성공");
        return emitter;

    }

    public <T> void customNotify(Long memberId, T data, String comment, String type) {
        sendToClient(memberId, data, comment, type);
    }
    public void notify(Long memberId, Object data, String comment) {
        sendToClient(memberId, data, comment);
    }

    private void sendToClient(Long memberId, Object data, String comment) {
        SseEmitter emitter = emitterRepository.get(memberId);
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event()
                        .id(String.valueOf(memberId))
                        .name("sse")
                        .data(data)
                        .comment(comment));
            } catch (IOException e) {
                emitterRepository.deleteById(memberId);
                emitter.completeWithError(e);
            }
        }
    }

    private <T> void sendToClient(Long memberId, T data, String comment, String type) {
        SseEmitter emitter = emitterRepository.get(memberId);
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event()
                        .id(String.valueOf(memberId))
                        .name(type)
                        .data(data)
                        .comment(comment));
            } catch (IOException e) {
                emitterRepository.deleteById(memberId);
                emitter.completeWithError(e);
            }
        }
    }

    private SseEmitter createEmitter(Long userId) {
        SseEmitter emitter = new SseEmitter(DEFAULT_TIMEOUT);
        emitterRepository.save(userId, emitter);

        emitter.onCompletion(() -> emitterRepository.deleteById(userId));
        emitter.onTimeout(() -> emitterRepository.deleteById(userId));

        return emitter;
    }

    private Member validMember(Long userId) {
        return memberRepository.findById(userId);
    }
}
