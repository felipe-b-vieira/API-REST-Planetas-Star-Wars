package com.restapi;

import com.restapi.controllers.PlanetaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = PlanetaController.class)
public class PlanetasapirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanetasapirestApplication.class, args);
	}

}
