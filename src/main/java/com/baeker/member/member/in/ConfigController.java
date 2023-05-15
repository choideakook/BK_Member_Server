package com.baeker.member.member.in;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Config Server 와 연결 상태를 확인하는 Controller 입니다.
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${custom.con}")
    private String con;

    @GetMapping("/test")
    public String conTest() {
        return con;
    }

}
