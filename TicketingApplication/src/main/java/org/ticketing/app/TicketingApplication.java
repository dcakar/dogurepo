package org.ticketing.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.ticketing.app"})
public class TicketingApplication {
	public static void main(String[] args) {
		SpringApplication.run(TicketingApplication.class, args);
	}

}
