package com.conygre.training.springboot.SpringBootPortfolioAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.plugin.core.SimplePluginRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@Profile("!test") // here to fix a bug in swagger since swagger messes up the test class

public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Portfolio Manager REST API with Swagger")
                .description("This API allows you to interact with the portfolio manager. It is a CRUD API")
                //.termsOfServiceUrl("http://www.conygre.com")
                //.contact(new Contact("Brigitte C", "http://www.conygre.com", "nick.todd@conygre.com"))
                //.license("Apache License Version 2.0")
                //.licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                //.version("2.0")
                .build();
    }
}