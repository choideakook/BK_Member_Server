package com.baeker.member.member.in.reqDto;

import lombok.Data;

@Data
public class JoinReqDto {

    private String username;
    private String nickName;
    private String password;
    private String provider;
    private String email;
    private String token;
    private String profileImage;
}
