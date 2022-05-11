package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.example.demo.entity.Doctor;
import com.example.demo.services.DoctorService;

@SpringBootApplication
public class SpringDataJpaSimpleMappingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=  SpringApplication.run(SpringDataJpaSimpleMappingApplication.class, args);
		
		Doctor siva = ctx.getBean(Doctor.class);
		Doctor raja = ctx.getBean(Doctor.class);
		
		DoctorService service = ctx.getBean(DoctorService.class);
		
		service.findByDepartment("ENT").forEach(System.out::println);
		
		//System.out.println(service.findByDoctorName("Raja"));
		
		//service.findByNameOrDept("Raja", "ENT");
		
		//Doctor added = service.add(siva);
		//Doctor added1 = service.add(raja);
		/*if(added1!=null) {
			System.out.println("One doctor Added");
		}*/
		
		//service.findAll().forEach(System.out::println);
		
		ctx.close();
	}
	
	@Bean
	public Doctor siva() 
	{
		return new Doctor(2020,"Siva","ENT",68686);
	}
	@Primary
	@Bean
	public Doctor raja()
	{
		return new Doctor(2021,"Raja","Cardio",45632);
	}

}