package com.uniktech.persistor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PersistorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistorServiceApplication.class, args);
	}

}
