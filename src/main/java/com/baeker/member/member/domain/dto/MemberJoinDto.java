package com.baeker.member.member.domain.dto;

import lombok.Data;

@Data
public class MemberJoinDto {

    private String username;
    private String nickName;
    private String password;
    private String provider;
    private String email;
    private String token;
    private String profileImage;
}
