package com.maptist.mappride.mappride.member;

import com.maptist.mappride.mappride.member.DTO.MemberDto;
import com.maptist.mappride.mappride.member.DTO.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    // 내 정보 수정
    @PutMapping("/update")
    public ResponseEntity<Void> updateMyInfo(@RequestBody MemberUpdateDto dto)
    {
        memberService.updateMyInfo(dto);
        return ResponseEntity.ok().build();
    }
}
