package com.onepage.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.onepage.activemq.*"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
