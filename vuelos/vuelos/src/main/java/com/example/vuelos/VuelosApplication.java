package com.example.vuelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VuelosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VuelosApplication.class, args);
	}

}
