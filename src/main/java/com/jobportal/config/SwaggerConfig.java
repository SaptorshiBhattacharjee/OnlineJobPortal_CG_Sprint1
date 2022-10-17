/*
package com.jobportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {​​​​​
    
 
    
    @Bean
    public Docket postsApi() {​​​​​
        return new Docket(DocumentationType.SWAGGER_2).groupName("com.jobportal.controller").ApiInfo(apiInfo()).select()
                .paths(regex("/.*")).build();
    }​​​​​
 
    private ApiInfo apiInfo() {​​​​​
        return new ApiInfoBuilder().title("Online Job Portal")
                .description("Sample Documentation Generateed Using SWAGGER2 for our Book Rest API")
                .termsOfServiceUrl("https://www.google.co.in")
                .license("PVT_ltd")
                .licenseUrl("https://www.google.co.in").version("1.0").build();
    }
}*/