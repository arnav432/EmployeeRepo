package com.project.application;

import java.io.IOException;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MainApplication {
	
	private static Logger logger = LoggerFactory.getLogger(MainApplication.class);
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws MessagingException, InterruptedException, IOException {
		
		SpringApplication.run(MainApplication.class, args);


	}

}

