package com.maptist.mappride.mappride.config.jwt.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maptist.mappride.mappride.config.jwt.DTO.StatusResponseDto;
import com.maptist.mappride.mappride.config.jwt.DTO.TokenResponseStatus;
import com.maptist.mappride.mappride.member.DTO.RegisterDto;
import com.maptist.mappride.mappride.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final RefreshTokenService tokenService;
    private final MemberService memberService;
    private final ObjectMapper objectMapper;

    @PostMapping("/logout")
    public ResponseEntity<StatusResponseDto> logout(@RequestHeader("Authorization") final String accessToken) {

        // 엑세스 토큰으로 현재 Redis 정보 삭제
        tokenService.removeRefreshToken(accessToken);
        return ResponseEntity.ok(StatusResponseDto.addStatus(200));
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponseStatus> refresh(@RequestHeader("Authorization") final String accessToken) {

        String newAccessToken = tokenService.republishAccessToken(accessToken);
        System.out.println(newAccessToken);
        if (StringUtils.hasText(newAccessToken)) {
            return ResponseEntity.ok(TokenResponseStatus.addStatus(200, newAccessToken));
        }

        return ResponseEntity.badRequest().body(TokenResponseStatus.addStatus(400, null));
    }

    @GetMapping("/login-success")
    public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 소셜로그인 후 그 유저에 대한 회원 정보가 있으면 토큰 발급 후 여기로 리디렉션됌.
        String decodedCookie = decodeCookie(request, response);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(Map.of("accessToken", decodedCookie));

        return ResponseEntity.ok().body(jsonResponse);
    }

    @GetMapping("/register")
    public ResponseEntity<Long> register(@RequestParam("loginUser") String registerDtoJson) throws Exception {
        // 소셜로그인 성공 시 그 유저에 대한 회원 정보가 DB에 존재하지 않을 때, 회원가입 진행
        RegisterDto registerDto = objectMapper.readValue(registerDtoJson, RegisterDto.class);
        return ResponseEntity.ok().body(memberService.register(registerDto));
    }

    @PostMapping("/send-error")
    public ResponseEntity<String> loginFailure(@RequestParam("message") String message){
        return ResponseEntity.badRequest().body(message);
    }

    private String decodeCookie(HttpServletRequest request, HttpServletResponse response) {
        String decodedToken = null;
        String encodedToken = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals("Authorization"))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);

        if (encodedToken != null) {
            decodedToken = new String(Base64.getUrlDecoder().decode(encodedToken));
            System.out.println(decodedToken); // "Bearer (token)" 형태 복원됨

            Cookie cookie = new Cookie("Authorization", null); // 또는 setValue("")
            cookie.setMaxAge(0); // 즉시 만료
            cookie.setPath("/"); // 같은 경로 설정 필수
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            response.addCookie(cookie);
        }
        return decodedToken;
    }

}
