package com.baeker.member.member.domain.service;

import com.baeker.member.base.request.RsData;
import com.baeker.member.member.in.dto.MemberJoinForm;
import com.baeker.member.member.domain.entity.Member;
import com.baeker.member.member.out.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

    /** 생성과 로그인 관련 Method **
     *
     */

    //-- Social Join, Login --//
    @Transactional
    public RsData<Member> join(MemberJoinForm form) {

        if (!form.getPassword().equals(form.getPassword2()))
            return RsData.of("F-1", "비밀번호가 일치하지 않습니다.");

        return join("Baeker", form.getUsername(), form.getNickName(), form.getAbout(), form.getPassword(), form.getProfileImg(), "", ""); // !!! 일반 로그인 이메일 항목 추가해야 함!!!
    }

    @Transactional
    public RsData<Member> whenSocialLogin(String provider, String username, String nickName, String email, String token, String profileImage) {
        Optional<Member> opMember = getMember(username);

        if (opMember.isPresent())
            return RsData.of("S-1", "로그인 성공.", opMember.get());

        return join(provider, username, nickName, "", "", profileImage, email, token);
    }

    //-- Join : Social + Security 실질적인 처리 --//
    private RsData<Member> join(String provider, String username, String name, String about, String password, String profileImg, String email, String token) {

        if (this.getMember(username).isPresent()) {
            return RsData.of("F-1", "이미 사용중인 username");
        }

        if (StringUtils.hasText(password)) {
            password = encoder.encode(password);
        }

        Member member = Member.createMember(provider, username, name, about, password, profileImg, email, token);
        memberRepository.save(member);
        return RsData.of("S-2", "회원가입 완료", member);
    }

    /** 조회 관련 method **
     *
     */

    //-- find all --//
}
