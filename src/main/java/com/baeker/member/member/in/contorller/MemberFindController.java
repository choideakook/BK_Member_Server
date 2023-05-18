package com.baeker.member.member.in.contorller;

import com.baeker.member.base.request.RsData;
import com.baeker.member.member.domain.entity.Member;
import com.baeker.member.member.domain.service.MemberService;
import com.baeker.member.member.in.resDto.MemberDto;
import com.baeker.member.member.in.resDto.SchedulerResDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/member/get")
@RequiredArgsConstructor
public class MemberFindController {

    private final MemberService memberService;

    //-- find by username --//
    @GetMapping("/member")
    public RsData findMember(
            @RequestParam @Valid String username
    ) {
        log.info("Member 를 찾는 요청 확인 username = {}", username);
        Member member = memberService.findByUsername(username);

        MemberDto dto = new MemberDto(member);

        log.info("member 응답 완료");
        return RsData.successOf(dto);
    }


    //-- find all --//
    @GetMapping("/all")
    public RsData findAll() {
        log.info("모든 Member 조회 요청 확인");
        List<Member> members = memberService.findAllConBJ();

        if (members.size() == 0) {
            log.info("응답 완료 count = 0");
            return RsData.of("S-1", "저장된 member 없음");
        }

        List<SchedulerResDto> dtoList = members.stream()
                .map(m -> new SchedulerResDto(m)).toList();

        log.info("응답 완료 count = {}", dtoList.size());
        return RsData.of("S-1", "count = " + dtoList.size(), dtoList);
    }
}
