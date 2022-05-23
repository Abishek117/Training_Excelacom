package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CloudConfigClientOneApplication 
{
	@Value("${customer.firstName}")
	private String name;
	
	@GetMapping(path = "/names")
    public String getName() {
		
		return this.name;
	}

	

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClientOneApplication.class, args);
	}

}
