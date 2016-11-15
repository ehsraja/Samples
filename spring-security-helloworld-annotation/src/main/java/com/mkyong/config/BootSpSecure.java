package com.mkyong.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.mkyong")
public class BootSpSecure {
	
	public static void main(String[] args) {
		
		 System.out.println("hello");
		       SpringApplication.run(BootSpSecure.class, args);
		    }
	}

