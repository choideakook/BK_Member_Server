package com.baeker.member.member.domain.entity;

import io.micrometer.core.instrument.util.AbstractPartition;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
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
}
