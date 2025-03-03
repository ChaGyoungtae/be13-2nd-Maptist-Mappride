package com.maptist.mappride.mappride.member.DTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberUpdateDto
{
    private Long id;

    private String nickname;

    private LocalDate birthDay;
}
