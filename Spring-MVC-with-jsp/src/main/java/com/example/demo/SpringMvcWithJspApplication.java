package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class SpringMvcWithJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcWithJspApplication.class, args);
	}
	
	@Bean
	public ModelAndView mdlView()
	{
		return new ModelAndView();
	}
}
