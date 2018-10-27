package com.rhl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan("com.rhl")
public class PinchMain {
	
	public static void main(String[] args) {
		
	
		SpringApplication.run(PinchMain.class, args);
	}


}
