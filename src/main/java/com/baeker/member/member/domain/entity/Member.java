package com.baeker.member.member.domain.entity;

import com.baeker.member.member.domain.entity.dto.BaekJoonDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = PROTECTED)
public class Member extends BaseEntity {

    @Column(unique = true)
    private String username;
    private String nickname;
    private String baekJoonName;
    private String about;
    private String profileImg;
    private String kakaoProfileImage;
    private String password;
    private String provider;
    private String email;
    private String accessToken;
    private boolean newMember;

    @Builder.Default
    @OneToMany(mappedBy = "member")
    private List<MemberSnapshot> snapshotList = new ArrayList<>();

    //-- crate method --//
    public static Member createMember(String provider, String username, String name, String about, String password, String profileImg, String email, String token) {
        return builder()
                .provider(provider)
                .username(username)
                .nickname(name)
                .about(about)
                .password(password)
                .profileImg(profileImg)
                .kakaoProfileImage(profileImg)
                .email(email)
                .accessToken(token)
                .newMember(true)
                .build();
    }


    //-- business logic --//

    // name, about, profileImg 수정 //
    public Member modifyMember(String name, String about, String img) {
        return this.toBuilder()
                .nickname(name)
                .about(about)
                .profileImg(img)
                .modifyDate(LocalDateTime.now())
                .newMember(false)
                .build();
    }

    // 첫방문 회원 체크 //
    public void joinComplete() {
        this.newMember = false;
    }

    // 백준 아이디 등록 //
    public Member connectBaekJoon(String baekJoonName) {
        return this.toBuilder()
                .baekJoonName(baekJoonName)
                .build();
    }

    // 백준 점수 최신화 //
    public Member updateBaeJoon(BaekJoonDto dto) {
        return this.toBuilder()
                .bronze(this.getBronze() + dto.getBronze())
                .sliver(this.getSliver() + dto.getSliver())
                .gold(this.getGold() + dto.getGold())
                .diamond(this.getDiamond() + dto.getDiamond())
                .ruby(this.getRuby() + dto.getRuby())
                .platinum(this.getPlatinum() + dto.getPlatinum())
                .build();
    }


    //-- create authorize --//
    public List<? extends GrantedAuthority> getGrantedAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        // 모든 회원에게 member 권한 부여 //
        grantedAuthorities.add(new SimpleGrantedAuthority("member"));

        // admin 권한 부여 //
        if ("admin".equals(username))
            grantedAuthorities.add(new SimpleGrantedAuthority("admin"));

        return grantedAuthorities;
    }

}