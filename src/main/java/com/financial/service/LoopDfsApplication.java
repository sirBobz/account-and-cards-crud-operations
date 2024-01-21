package com.financial.service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Banking APIs", version = "1.0.0", description = "A micro-service that manages both credit card and account creation, retrieval, update and delete operation (CRUD)."))

public class LoopDfsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoopDfsApplication.class, args);
	}

}
