package com.maptist.mappride.mappride.member;

import com.maptist.mappride.mappride.categoryByMember.DTO.CategoryByMemberResponseDto;
import com.maptist.mappride.mappride.member.DTO.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController
{
    private final MemberService memberService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {

        return ResponseEntity.ok().body("ok");
    }

    // 내 정보 조회
    @GetMapping
    public ResponseEntity<MemberDto>selectMyInfo()
    {
        MemberDto selectMyInfo = memberService.selectMyInfo();

        return ResponseEntity.ok(selectMyInfo);
    }

    // 내 정보 수정
    @PutMapping("/update")
    public ResponseEntity<Void> updateMyInfo(@RequestBody MemberUpdateDto dto)
    {
        memberService.updateMyInfo(dto);
        return ResponseEntity.ok().build();
    }

    // 내 카테고리 조회 (페이지 이동)
    @GetMapping("/manageCategories")
    public ResponseEntity<List<CategoryByMemberResponseDto>> manageCategories() {

        List<CategoryByMemberResponseDto> memberCategories = memberService.searchCategories();

        if (memberCategories.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Collections.emptyList());
        }

        return ResponseEntity.ok(memberCategories);
    }

    //멤버 검색 (이름)
    @GetMapping("/{name}")
    public ResponseEntity<List<MemberNameDto>>selectOtherName(@PathVariable("name") String name)
    {
        List<MemberNameDto> selectMyInfo = memberService.selectOtherName(name);

        return ResponseEntity.ok(selectMyInfo);
    }

    // 멤버 검색 (이메일)
    @GetMapping("/{email}")
    public ResponseEntity<MemberEmailDto>selectOtherEmail(@PathVariable("email") String email)
    {
        MemberEmailDto selectOtherEmail = memberService.selectOtherEmail(email);

        return ResponseEntity.ok(selectOtherEmail);
    }
    // 멤버 검색 (닉네임)
    @GetMapping("/{nick-name}")
    public ResponseEntity<MemberNickNameDto>selectOtherNickName(@PathVariable("nick-name") String nickName)
    {
        MemberNickNameDto selectOtherNickName = memberService.selectOtherNickName(nickName);

        return ResponseEntity.ok(selectOtherNickName);
    }
}
