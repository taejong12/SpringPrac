package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class P30SpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(P30SpringBatchApplication.class, args);
	}

}
