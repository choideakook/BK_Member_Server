package com.baeker.member.base.springDoc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@OpenAPIDefinition
public class BoardController {

    @Bean
    public OpenAPI api() {
        Info info = new Info().title("").version("v3").description("BAEKER-MSA : Member Server Endpoint");

        return new OpenAPI().components(new Components()).info(info);
    }
}