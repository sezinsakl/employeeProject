package com.example.turkcellProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TurkcellProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurkcellProjectApplication.class, args);
	}

}
