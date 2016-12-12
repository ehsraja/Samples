package com.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@EnableAutoConfiguration
@ComponentScan("com.sam")
public class WebSecureBoot  {

	public static void main(String[] args) throws Exception{
        SpringApplication.run(WebSecureBoot.class, args);
    }
	
	 
}
