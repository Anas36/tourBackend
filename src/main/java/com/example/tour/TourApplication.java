package com.example.tour;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@OpenAPIDefinition
public class TourApplication {

	public static void main(String[] args) {

		SpringApplication.run(TourApplication.class, args);
	}

}
