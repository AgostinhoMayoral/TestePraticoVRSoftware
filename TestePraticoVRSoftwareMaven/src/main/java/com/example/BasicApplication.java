package com.example;

import frames.MainPage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
            new MainPage().setVisible(true);
		SpringApplication.run(BasicApplication.class, args);
	}
}
