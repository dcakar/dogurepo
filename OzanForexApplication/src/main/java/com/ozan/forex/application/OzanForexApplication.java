package com.ozan.forex.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = { "com.ozan.forex.application.dao" })
@EntityScan(basePackages = { "com.ozan.forex.application.dao" })
@ComponentScan(basePackages = { "com.ozan.forex.application" })
@SpringBootApplication(scanBasePackages = { "com.ozan.forex.application" })
public class OzanForexApplication {
	public static void main(String[] args) {
		SpringApplication.run(OzanForexApplication.class, args);
	}
}
