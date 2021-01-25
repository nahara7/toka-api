package com.newjerseysoftware.hederaDemo.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class DemoApplication {

	/*@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

	public static void main(String[] args) {
		run(DemoApplication.class, args);
	}

}
