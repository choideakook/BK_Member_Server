package com.baeker.member.member.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity @Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = PROTECTED)
public class MemberSnapshot extends BaseEntity{

    @ManyToOne(fetch = LAZY)
    private Member member;

}
