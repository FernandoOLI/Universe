package com.project.universe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UniverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniverseApplication.class, args);
	}

}
