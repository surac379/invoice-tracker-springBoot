package com.skillstorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.skillstorm")
public class InvoiceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceTrackerApplication.class, args);
	}

}
