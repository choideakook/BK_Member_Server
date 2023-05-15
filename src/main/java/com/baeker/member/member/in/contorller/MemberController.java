package com.baeker.member.member.in.contorller;

import com.baeker.member.base.request.RsData;
import com.baeker.member.member.domain.dto.MemberJoinDto;
import com.baeker.member.member.domain.entity.Member;
import com.baeker.member.member.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //-- find by username --//
    @GetMapping("get_member")
    public RsData<Member> findMember(
            @RequestParam String username
    ) {
        log.info("Member 를 찾는 요청 확인 username = {}", username);

        RsData<Member> memberRs = memberService.findByUsername(username);

        if (memberRs.isFail()) {
            log.info("존재하지 않는 username");
            return memberRs;
        }

        log.info("member 응답 완료");
        return memberRs;
    }

    //-- create --//
    @PostMapping("create")
    public RsData<Member> create(@RequestBody MemberJoinDto dto) {
        log.info("member 생성 요청 확인 username = {}", dto.getUsername());

        RsData<Member> memberRs = memberService.create(dto);

        if (memberRs.isFail()) {
            log.info("회원가입 실패 msg = {}", memberRs.getMsg());
            return memberRs;
        }

        log.info("member 생성 완료 member id = {}", memberRs.getData().getId());
        return memberRs;
    }
}
