package com.example.testToJSON;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.testToJSON")
public class TestToJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestToJsonApplication.class, args);
	}

}
