package com.nagarro.training;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EcomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Staring project");

	}

}
