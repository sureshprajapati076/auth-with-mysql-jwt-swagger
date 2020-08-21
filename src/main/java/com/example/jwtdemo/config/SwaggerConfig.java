package com.example.jwtdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket swaggerApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.example.jwtdemo.controller"))
                .build()
                .apiInfo(apiInfo());


    }


    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Swagger Api Example By Suresh",
                "Api Reference Example",
                "1.0.0",
                "Public Api",
                new Contact("Suresh Prajapati","https://linkedin.com/in/prajapatisuresh", "prajapatisuresh6334@gmail.com"),
                "Software",
                "https://github.com/sureshprajapati076",
                Collections.emptyList());
    }
}
