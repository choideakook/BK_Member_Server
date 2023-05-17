package com.baeker.member.member.in.dto;

import com.baeker.member.member.domain.entity.Member;
import lombok.Data;

@Data
public class SchedulerDto {

    private Long id;
    private String baekJoonName;
    private int bronze;
    private int sliver;
    private int gold;
    private int diamond;
    private int ruby;
    private int platinum;
    private int solvedBaekJoon;

    public SchedulerDto(Member member) {
        this.id = member.getId();
        this.baekJoonName = member.getBaekJoonName();
        this.bronze = member.getBronze();
        this.sliver = member.getSliver();
        this.gold = member.getGold();
        this.diamond = member.getDiamond();
        this.ruby = member.getRuby();
        this.platinum = member.getPlatinum();
        this.solvedBaekJoon = member.solvedBaekJoon();
    }
}