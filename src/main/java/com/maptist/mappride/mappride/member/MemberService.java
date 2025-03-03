package com.maptist.mappride.mappride.member;

import com.maptist.mappride.mappride.config.jwt.DTO.SecurityUserDto;
import com.maptist.mappride.mappride.member.DTO.MemberDto;
import com.maptist.mappride.mappride.member.DTO.MemberUpdateDto;
import com.maptist.mappride.mappride.member.DTO.RegisterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public Optional<Member> findByEmail(String email){
        return memberRepository.findByEmail(email);
    }

    public ResponseEntity<Long> register(RegisterDto registerDto) {
        Member member = Member.createMember(registerDto);

        return ResponseEntity.ok().body(memberRepository.save(member));
    }

    public Member getMember() {
        SecurityUserDto securityUserDto = (SecurityUserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = securityUserDto.getEmail();
        Optional<Member> findMember = memberRepository.findByEmail(email);
        if (findMember.isPresent()) {
            return findMember.get();
        } else {
            return null;
        }
    }


    // 내 정보 조회
    public MemberDto selectMyInfo()
    {
        // 멤버 객체에서 아이디만 빼옴
        Long memberId = getMember().getId();

        //멤버아이디를 레포지토리로 이동
        return memberRepository.selectMyInfo(memberId);
    }

    // 내 정보 수정
    public void updateMyInfo(MemberUpdateDto dto)
    {
        memberRepository.updateMyInfo(dto);
    }
}
