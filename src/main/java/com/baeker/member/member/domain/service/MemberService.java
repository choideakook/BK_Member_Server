package com.baeker.member.member.domain.service;

import com.baeker.member.base.exception.InvalidDuplicateException;
import com.baeker.member.base.exception.NotFoundException;
import com.baeker.member.member.domain.dto.MemberJoinDto;
import com.baeker.member.member.domain.entity.Member;
import com.baeker.member.member.out.MemberQueryRepository;
import com.baeker.member.member.out.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberQueryRepository memberQueryRepository;


    /**
     * create method **
     * member 객체 생성
     */

    //-- create member --//
    @Transactional
    public Member create(MemberJoinDto dto) {

        try {
            if (findByUsername(dto.getUsername()) != null)
                throw new InvalidDuplicateException("이미 존재하는 username 입니다.");
        } catch (NotFoundException e) {}

        Member member = Member.createMember(dto.getProvider(), dto.getUsername(), dto.getNickName(), "", dto.getPassword(), dto.getProfileImage(), dto.getEmail(), dto.getToken());
        return memberRepository.save(member);
    }


    /**
     * read method **
     * find by username
     * find all
     */

    //-- find by username --//
    public Member findByUsername(String username) {
        Optional<Member> byUsername = memberRepository.findByUsername(username);

        if (byUsername.isPresent())
            return byUsername.get();

        throw new NotFoundException("존재하지 않는 username");
    }

    //-- find all --//
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    //-- find all 백준 연동한 사람만 --//
    public List<Member> findAllConBJ() {
        return memberQueryRepository.findAllConBJ();
    }
}
