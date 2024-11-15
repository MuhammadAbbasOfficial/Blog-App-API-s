package com.codewithabbas.blog;

import org.modelmapper.ModelMapper; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);

		System.out.println("khannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");

	}
	
	
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}
