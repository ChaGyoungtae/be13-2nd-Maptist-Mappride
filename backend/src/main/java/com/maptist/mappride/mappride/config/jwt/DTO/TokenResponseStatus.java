package com.maptist.mappride.mappride.config.jwt.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TokenResponseStatus {
     private Integer status;
    private String accessToken;

    public static TokenResponseStatus addStatus(Integer status, String accessToken) {
        return new TokenResponseStatus(status, accessToken);
    }
}
