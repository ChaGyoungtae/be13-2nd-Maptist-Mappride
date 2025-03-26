package com.maptist.mappride.mappride.config;

import com.maptist.mappride.mappride.config.jwt.JwtAuthFilter;
import com.maptist.mappride.mappride.config.jwt.JwtExceptionFilter;
import com.maptist.mappride.mappride.config.oauth2.CustomOAuth2UserService;
import com.maptist.mappride.mappride.config.oauth2.handler.MyAuthenticationFailureHandler;
import com.maptist.mappride.mappride.config.oauth2.handler.MyAuthenticationSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final MyAuthenticationSuccessHandler oAuth2LoginSuccessHandler;
    private final CustomOAuth2UserService customOAuth2UserService;
    private final JwtAuthFilter jwtAuthFilter;
    private final MyAuthenticationFailureHandler oAuth2LoginFailureHandler;
    private final JwtExceptionFilter jwtExceptionFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(AbstractHttpConfigurer::disable) //HTTP 기본 인증 비활성화
                .cors((cors) -> cors
                        .configurationSource(myWebsiteConfigurationSource())) //CORS 활성화
                .csrf(AbstractHttpConfigurer::disable) //CSRF 보호 기능 비활성화
                .sessionManagement((policy) -> policy
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //세션관리 정책을 STATELESS 로 설정
                .authorizeHttpRequests(authorize -> authorize // 요청에 대한 인증 설정
                        //.requestMatchers("/**").permitAll() //모든 경로 인증 불필요
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        .requestMatchers("/api/v1/geocode").permitAll()//여기 적혀있는 경로는 모두 허용
                        .requestMatchers("/", "/css/**", "/images/**", "/js/**", "/static/favicon.ico").permitAll()
                        .requestMatchers(
                                            "/swagger-ui/**",
                                            "/v3/api-docs/**",
                                            "/swagger-resources/**",
                                            "/webjars/**"
                                        ).permitAll()
                        .requestMatchers("/mypage/**").hasAnyRole("USER", "MANAGER") // USER와 MANAGER는 허용
                        .anyRequest().authenticated() // 그 외 요청은 모두 인증이 필요하다.
                )
                // OAuth2 로그인 설정 시작
                .oauth2Login(oauth2 -> oauth2
                        .failureHandler(oAuth2LoginFailureHandler) // 로그인 실패시 처리할 핸들러 지정
                        .successHandler(oAuth2LoginSuccessHandler) // 로그인 성공시 처리할 핸들러 지정
                                .userInfoEndpoint(endPoint -> endPoint
                                        .userService(customOAuth2UserService)) // OAuth2 로그인시 사용자 정보를 가져오는 엔드포인트와 사용자 서비스를 설정
                );

        // JWT 인증 필터를 UsernamePasswordAuthenticationFilter 앞에 추가한다.
        return http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtExceptionFilter, JwtAuthFilter.class) // jwtExceptionFilter를 JwtAuthFilter앞에 추가한다.
                .build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource myWebsiteConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("http://localhost:5173", "https://*.yourdomain.com")); // 와일드카드 패턴 허용
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true); // Credentials 허용

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
