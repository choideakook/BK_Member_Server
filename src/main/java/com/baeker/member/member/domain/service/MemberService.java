package com.baeker.member.member.domain.service;

import com.baeker.member.base.request.RsData;
import com.baeker.member.member.domain.dto.MemberJoinDto;
import com.baeker.member.member.domain.entity.Member;
import com.baeker.member.member.out.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;


    public Optional<Member> getMember(String username) {
        return null;
    }

    /**
     * create method **
     */

    //-- create member --//
    public RsData<Member> create(MemberJoinDto dto) {
        if (findByUsername(dto.getUsername()).isSuccess())
            return RsData.of("F-1", "이미 존재하는 username");

        Member member = Member.createMember(dto.getProvider(), dto.getUsername(), dto.getNickName(), "", dto.getPassword(), dto.getProfileImage(), dto.getEmail(), dto.getToken());
        Member saveMember = memberRepository.save(member);

        return RsData.successOf(saveMember);
    }


    /**
     * read method **
     */

    //-- find by username --//
    public RsData<Member> findByUsername(String username) {
        Optional<Member> byUsername = memberRepository.findByUsername(username);

        if (byUsername.isPresent())
            return RsData.successOf(byUsername.get());

        return RsData.of("F-1", "존재하지 않는 username");
    }
}
