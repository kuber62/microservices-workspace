package com.uniktech.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "unik.service")
public class UnikServiceProperties {

	public String message;

}