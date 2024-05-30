package com.example.manufacturingwebservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.manufacturingwebservice")
@EnableJpaRepositories(basePackages = "com.example.manufacturingwebservice.repositories")
public class ManufacturingwebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufacturingwebserviceApplication.class, args);
	}

	@Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}
