package com.maptist.mappride.mappride.member.DTO;

import com.maptist.mappride.mappride.grade.Grade;
import com.maptist.mappride.mappride.member.Member;
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

    private LocalDate birthDay;

    private String userRole;

    private boolean publish;

    private int scrapCnt;

}
