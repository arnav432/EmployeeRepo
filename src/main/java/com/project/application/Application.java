package com.project.application;

import java.io.IOException;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import emailSender.emailSenderHelper;


@SpringBootApplication
public class Application {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws MessagingException, InterruptedException, IOException {
		
		emailSenderHelper sender = new emailSenderHelper();
		
		SpringApplication.run(Application.class, args);


	}

}

