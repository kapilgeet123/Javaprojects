package com.luv2code.springboot.demo.mycoolApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MycoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolAppApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(String [] args)
	{
		return runner -> {
			System.out.println("Hello World!");
		};
	}

}
