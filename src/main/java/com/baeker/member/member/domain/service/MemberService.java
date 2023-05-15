package com.baeker.member.member.domain.service;

import com.baeker.member.member.domain.entity.Member;
import com.baeker.member.member.out.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public Member getMember(String username) {
        return null;
    }
}
