package com.sam.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sam.db.domain.Country;
import com.sam.db.repo.CountryRepository;




@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.sam.db","com.sam.repo"})
public class main {
	
	public static void main(String[] args) throws Exception{
        SpringApplication.run(main.class, args);
    }
	
	@Bean
	public CommandLineRunner demo(CountryRepository repository) {
		return (args) -> {
		 	repository.save(new Country(23,"Ind",43434));
			for (Country country : repository.findAll()) {
				System.out.println(country.toString());
			}
			
		};
		
}
	
}
