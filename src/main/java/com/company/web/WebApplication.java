package com.company.web;

import com.company.web.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {

		SpringApplication.run(new Class<?>[] {WebApplication.class, JpaConfig.class}, args);
	}
}
