package com.maptist.mappride.mappride.config.oauth2.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maptist.mappride.mappride.config.jwt.DTO.GeneratedToken;
import com.maptist.mappride.mappride.config.jwt.JwtUtil;
import com.maptist.mappride.mappride.member.DTO.RegisterDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@Component
@RequiredArgsConstructor
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // OAuth2User로 캐스팅하여 인증된 사용자 정보를 가져온다.
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        // 사용자 이메일을 가져온다.
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        // 서비스 제공 플랫폼(GOOGLE, KAKAO, NAVER)이 어디인지 가져온다.
        String provider = oAuth2User.getAttribute("provider");

        // CustomOAuth2UserService에서 셋팅한 로그인한 회원 존재 여부를 가져온다.
        boolean isExist = oAuth2User.getAttribute("exist");
        // OAuth2User로 부터 Role을 얻어온다.
        String role = oAuth2User.getAuthorities().stream().
                findFirst() // 첫번째 Role을 찾아온다.
                .orElseThrow(IllegalAccessError::new) // 존재하지 않을 시 예외를 던진다.
                .getAuthority(); // Role을 가져온다.

        // 회원이 존재할경우
        if (isExist) {
            // 회원이 존재하면 jwt token 발행을 시작한다.
            GeneratedToken token = jwtUtil.generateToken(email, role);

            // accessToken을 쿼리스트링에 담는 url을 만들어준다.
           String targetUrl = UriComponentsBuilder.fromUriString("http://localhost:5173/api/v1/auth/login-success")
                   .build()
                    .encode(StandardCharsets.UTF_8)
                    .toUriString();
           log.info("redirect 준비");

           addTokenToCookie(response, token.getAccessToken()); // JWT를 쿠키로 저장

           // 로그인 확인 페이지로 리다이렉트 시킨다.
           getRedirectStrategy().sendRedirect(request, response, targetUrl);


        } else {
            RegisterDto registerDto = new RegisterDto(email, name);

            ObjectMapper objectMapper = new ObjectMapper();
            String registerDtoJson = objectMapper.writeValueAsString(registerDto);

            System.out.println(registerDto.toString());
            // 회원이 존재하지 않을경우, 서비스 제공자와 email을 쿼리스트링으로 전달하는 url을 만들어준다.
            String targetUrl = UriComponentsBuilder.fromUriString("http://localhost:8080/api/v1/auth/register")
                    .queryParam("loginUser", registerDtoJson)
                    .queryParam("provider", provider)
                    .build()
                    .encode(StandardCharsets.UTF_8)
                    .toUriString();
            // 회원가입 페이지로 리다이렉트 시킨다.
            getRedirectStrategy().sendRedirect(request, response, targetUrl);
        }
    }

    private void addTokenToCookie(HttpServletResponse response, String accessToken) {

        String token = "Bearer " + accessToken; // "Bearer (token)" 형태 유지
        String encodedToken = Base64.getUrlEncoder().encodeToString(token.getBytes());

        Cookie cookie = new Cookie("Authorization", encodedToken);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(3600); // 1시간 유지
        response.addCookie(cookie);
    }

}
