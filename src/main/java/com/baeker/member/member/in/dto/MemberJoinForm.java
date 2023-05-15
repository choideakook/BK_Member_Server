package com.baeker.member.member.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberJoinForm {

    private String username;
    private String nickName;
    private String about;
    private String password;
    private String password2;
    private String profileImg;
}