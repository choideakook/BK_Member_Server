package com.baeker.member.member.in.reqDto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConBjReqDto {

    @NotNull
    private Long id;
    @NotNull
    private String baekJoonName;

}
