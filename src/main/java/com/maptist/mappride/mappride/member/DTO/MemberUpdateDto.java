package com.maptist.mappride.mappride.member.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    private boolean publish;
}
