package com.ozan.forex.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.ozan.forex.application" })
public class OzanForexApplication {
	public static void main(String[] args) {
		SpringApplication.run(OzanForexApplication.class, args);
	}
}
