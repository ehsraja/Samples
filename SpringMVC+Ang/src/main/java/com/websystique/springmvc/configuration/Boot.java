package com.websystique.springmvc.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.websystique.springmvc")
public class Boot {
	
	public static void main(String[] args) {
		
		        SpringApplication.run(Boot.class, args);
		    }
	}

