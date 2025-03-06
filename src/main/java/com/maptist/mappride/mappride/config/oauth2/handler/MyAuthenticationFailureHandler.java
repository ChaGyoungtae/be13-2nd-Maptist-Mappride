package com.maptist.mappride.mappride.config.oauth2.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 인증 실패시 메인 페이지로 이동
        String targetUrl = UriComponentsBuilder.fromUriString("http://localhost:8080/api/v1/auth/send-error")
                .queryParam("message",exception.getMessage())
                .encode(StandardCharsets.UTF_8)
                .toUriString();
        response.sendRedirect(targetUrl);
    }
}
