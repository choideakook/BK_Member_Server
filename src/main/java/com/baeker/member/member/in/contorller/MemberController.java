package com.baeker.member.member.in.contorller;

import com.baeker.member.base.request.RsData;
import com.baeker.member.member.domain.dto.MemberJoinDto;
import com.baeker.member.member.domain.entity.Member;
import com.baeker.member.member.domain.service.MemberService;
import com.baeker.member.member.in.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //-- create --//
    @PostMapping("/create")
    public RsData create(@RequestBody MemberJoinDto dto) {
        log.info("member 생성 요청 확인 username = {}", dto.getUsername());

        Member member = memberService.create(dto);
        MemberDto createMemberDto = new MemberDto(member);

        log.info("member 생성 완료 member id = {}", member.getId());
        return RsData.successOf(createMemberDto);
    }


}
