package com.example.Lalan;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;


@SpringBootApplication
public class LalanApplication {

	public static void main(String[] args) {

		SpringApplication.run(LalanApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();

	}
}
