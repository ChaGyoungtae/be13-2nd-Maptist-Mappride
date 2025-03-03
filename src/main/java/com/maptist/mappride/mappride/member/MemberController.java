package com.maptist.mappride.mappride.member;

import com.maptist.mappride.mappride.categoryByMember.DTO.CategoryByMemberResponseDto;
import com.maptist.mappride.mappride.member.DTO.MemberDto;
import com.maptist.mappride.mappride.member.DTO.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
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

    // 내 카테고리 조회 (페이지 이동)
    @GetMapping("/manageCategories")
    public ResponseEntity<List<CategoryByMemberResponseDto>> manageCategories() {

        List<CategoryByMemberResponseDto> memberCategories = memberService.searchCategories();

        if (memberCategories.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Collections.emptyList());
        }

        return ResponseEntity.ok(memberCategories);
    }

    // 내 정보 수정
    @PutMapping("/update")
    public ResponseEntity<Void> updateMyInfo(@RequestBody MemberUpdateDto dto)
    {
        memberService.updateMyInfo(dto);
        return ResponseEntity.ok().build();
    }

}
