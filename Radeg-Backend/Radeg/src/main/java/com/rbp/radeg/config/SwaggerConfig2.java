/*
package com.rbp.radeg.config;

import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;


@EnableSwagger2
public class SwaggerConfig2 {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Radeg")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/.*"))
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("${spring.application.name}")
                .description("${spring.application.description}")
                .termsOfServiceUrl("")
                .license("RbarraganP")
                .licenseUrl("https://github.com/rbarraganp/radeg.git")
                .version("${spring.application.version}")
                .build();
    }

}
*/
