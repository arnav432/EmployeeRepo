package com.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.project.controllers.DashboardController;


@SpringBootApplication
@ComponentScan(basePackages = { "com.project.controllers",
        "com.project.entities", "com.project.repositories",
        "com.project.services" })
public class Application {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);


	}

}

