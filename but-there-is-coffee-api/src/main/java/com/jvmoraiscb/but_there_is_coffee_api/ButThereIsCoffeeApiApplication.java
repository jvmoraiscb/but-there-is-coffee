package com.jvmoraiscb.but_there_is_coffee_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ButThereIsCoffeeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ButThereIsCoffeeApiApplication.class, args);
	}
}
