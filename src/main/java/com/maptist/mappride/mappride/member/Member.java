package com.maptist.mappride.mappride.member;

import com.maptist.mappride.mappride.grade.Grade;
import com.maptist.mappride.mappride.member.DTO.RegisterDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String nickname;

    private LocalDate birthDay;

    @Column(nullable = false)
    private String userRole;

    private Member(String email, String name, String userRole){
        this.email = email;
        this.name = name;
        this.userRole = userRole;
    }

    public static Member createMember(RegisterDto registerDto){
        Member member = new Member(
                registerDto.getEmail(),
                registerDto.getName(),
                registerDto.getUserRole());

        return member;
    }
}
