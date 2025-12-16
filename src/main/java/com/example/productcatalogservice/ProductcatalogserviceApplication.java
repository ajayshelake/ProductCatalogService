package com.example.productcatalogservice;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
//@EntityScan(basePackages = "com.example.productcatalogservice.models")
public class ProductcatalogserviceApplication {

	@Value("${app.config.check:NOT_LOADED}")
	private String check;

	public static void main(String[] args) {
		SpringApplication.run(ProductcatalogserviceApplication.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("CONFIG VALUE = " + check);
	}
}
