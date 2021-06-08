package com.example.noPreguntamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.service")
@ComponentScan("com.example")
@SpringBootApplication
public class NoPreguntamosApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoPreguntamosApplication.class, args);
	}
}
