package com.lerhyd.dngame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DngameApplication {
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DngameApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DngameApplication.class, args);
  }
}

