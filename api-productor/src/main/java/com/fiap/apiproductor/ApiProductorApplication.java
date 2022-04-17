package com.fiap.apiproductor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApiProductorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiProductorApplication.class, args);
    }

}
