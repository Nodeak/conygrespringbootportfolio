package com.conygre.training.springboot.SpringBootPortfolioAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class SpringBootPortfolioApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPortfolioApiApplication.class, args);
	}

}
