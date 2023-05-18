package com.baeker.member.member.in.resDto;

import com.baeker.member.member.domain.entity.Member;
import lombok.Data;

@Data
public class UpdateResDto {

    private String nickname;
    private String about;
    private String profileImg;

    public UpdateResDto(Member member) {
        this.nickname = member.getNickname();
        this.about = member.getAbout();
        this.profileImg = member.getProfileImg();
    }
}
