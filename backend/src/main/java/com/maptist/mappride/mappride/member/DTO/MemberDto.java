package com.maptist.mappride.mappride.member.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberDto
{
    private Long id;

    private String gradeName;

    private String email;

    private String name;

    private String nickname;

    private LocalDate birthday;

    private String userRole;

    private boolean publish;

    private int scrapCnt;

}
