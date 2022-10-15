package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication

public class SpDringBootDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpDringBootDbApplication.class, args);
	}
		
		@Bean
		public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2).select()
		.apis((Predicate<RequestHandler>)RequestHandlerSelectors.any())
		.paths((Predicate<String>)PathSelectors.any()).build();
	}
	
}

