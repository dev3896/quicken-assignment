package com.assignment.quicken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class QuickenApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickenApplication.class, args);
	}

}
