package com.maptist.mappride.mappride.member.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterDto {
    private String email;
    private String name;
    private String userRole;

    public RegisterDto(String email, String name){
        this.email = email;
        this.name = name;
        this.userRole = "USER";
    }

}
