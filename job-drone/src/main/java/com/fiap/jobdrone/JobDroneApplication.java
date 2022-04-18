package com.fiap.jobdrone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JobDroneApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobDroneApplication.class, args);
	}

}
