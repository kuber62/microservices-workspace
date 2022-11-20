package com.uniktech.jmsbroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class JmsBrokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsBrokerApplication.class, args);
	}

}
