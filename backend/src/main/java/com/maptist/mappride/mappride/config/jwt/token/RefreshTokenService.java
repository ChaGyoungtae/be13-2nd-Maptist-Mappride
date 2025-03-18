package com.maptist.mappride.mappride.config.jwt.token;

import com.maptist.mappride.mappride.config.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RefreshTokenService {

    private final RefreshTokenRepository repository;
    private final JwtUtil jwtUtil;

    @Transactional
    public void removeRefreshToken(String accessToken) {
        accessToken = accessToken.split(" ")[1];
        RefreshToken token = repository.findByAccessToken(accessToken)
                .orElseThrow(IllegalArgumentException::new);

        repository.delete(token);

        Optional<RefreshToken> token1 = repository.findByAccessToken(accessToken);
        if(token1.isPresent()) log.info("token: {}",token1);
        else log.info("delete success!");
    }

     @Transactional
    public String republishAccessToken(String accessToken) {
        // 액세스 토큰으로 Refresh 토큰 객체를 조회
         accessToken = accessToken.split(" ")[1];

        Optional<RefreshToken> refreshToken = repository.findByAccessToken(accessToken);
        // RefreshToken이 존재하고 유효하다면 실행
        if (refreshToken.isPresent() && jwtUtil.verifyToken(refreshToken.get().getRefreshToken())) {

            // RefreshToken 객체를 꺼내온다.
            RefreshToken resultToken = refreshToken.get();
            // 권한과 아이디를 추출해 새로운 액세스토큰을 만든다.
            String newAccessToken = jwtUtil.generateAccessToken(resultToken.getId(), jwtUtil.getRole(resultToken.getRefreshToken()));
            // 액세스 토큰의 값을 수정해준다.
            resultToken.updateAccessToken(newAccessToken);
            repository.save(resultToken);
            // 새로운 액세스 토큰을 반환해준다.
            return "Bearer "+ newAccessToken;
        }

        return null;
    }
}
