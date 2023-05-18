package com.baeker.member.member.in.reqDto;

import lombok.Data;

@Data
public class PageReqDto {

    private int page;
    private String standard;
    private int maxContent;
    private boolean asc;
}
