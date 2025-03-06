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

    private Grade grade;

    private String email;

    private String name;

    private String nickName;

    private LocalDate birthDay;

    private String userRole;

    public MemberDto(Member member)
    {
        this.id = member.getId();
        this.grade = member.getGrade();
        this.email = member.getEmail();
        this.name = member.getName();
        this.nickName = member.getNickname();
        this.birthDay = member.getBirthDay();
        this.userRole = member.getUserRole();
    }
}
