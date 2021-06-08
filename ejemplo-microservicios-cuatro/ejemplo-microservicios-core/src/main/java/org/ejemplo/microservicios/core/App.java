package org.ejemplo.microservicios.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Microservice
 *
 */
@EntityScan("org.ejemplo.microservicios.data.entity")
@EnableJpaRepositories("org.ejemplo.microservicios.data.repository")
@ComponentScan("org.ejemplo.microservicios.core")
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
