package com.maptist.mappride.mappride.config.jwt;

import com.maptist.mappride.mappride.config.jwt.DTO.SecurityUserDto;
import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.member.MemberService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Profile("local")
@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final MemberService memberService;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

//        return request.getRequestURI().contains("/");
        return request.getRequestURI().contains("/login");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, IOException {

        String requestURI = request.getRequestURI();

        log.info("current uri = {}",requestURI);

        // 해당 경로는 JWT 검증을 거치지 않음
        if (requestURI.startsWith("/v3/api-docs")
            || requestURI.startsWith("/swagger-ui")
            || requestURI.startsWith("/swagger-resources")
            || requestURI.startsWith("/webjars/")
            || requestURI.startsWith("/api/v1/auth/")
            || requestURI.startsWith("/api/v1/geocode")
            || requestURI.startsWith("/default-ui.css")
            || requestURI.equals("/favicon.ico")) {
            filterChain.doFilter(request, response);
        return;
}

        // request Header에서 AccessToken을 가져온다.
        String atc = request.getHeader("Authorization");

        if(atc == null){
            throw new JwtException("Authorization header is required");
        }

        atc = atc.split(" ")[1];

        // AccessToken을 검증하고, 만료되었을경우 예외를 발생시킨다.
        if (!jwtUtil.verifyToken(atc) || jwtUtil.isExpired(atc)) {
            throw new JwtException("Access Token 만료!");
        }

        // AccessToken의 값이 있고, 유효한 경우에 진행한다.
        if (jwtUtil.verifyToken(atc)) {

            // AccessToken 내부의 payload에 있는 email로 user를 조회한다. 없다면 예외를 발생시킨다 -> 정상 케이스가 아님
            Member findMember = memberService.findByEmail(jwtUtil.getUid(atc))
                    .orElseThrow(() -> new IllegalArgumentException("해당 이메일로 가입된 회원이 없습니다."));

            // SecurityContext에 등록할 User 객체를 만들어준다.
            SecurityUserDto userDto = SecurityUserDto.builder()
                    .email(findMember.getEmail())
                    .role("ROLE_".concat(findMember.getUserRole()))
                    .nickname(findMember.getNickname())
                    .build();

            // SecurityContext에 인증 객체를 등록해준다.
            Authentication auth = getAuthentication(userDto);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }


    public Authentication getAuthentication(SecurityUserDto member) {
        return new UsernamePasswordAuthenticationToken(member, "",
                List.of(new SimpleGrantedAuthority(member.getRole())));
    }
}
