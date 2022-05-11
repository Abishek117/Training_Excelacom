package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;

@SpringBootApplication
public class SpringDataJpaTaskApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cxt =  SpringApplication.run(SpringDataJpaTaskApplication.class, args);
		
		EmployeeService service = cxt.getBean(EmployeeService.class);
		
		Employee abi = cxt.getBean(Employee.class);
		Employee added1 = service.add(abi);
		if(added1!=null)
		{
			System.out.println("One Employee Added");
		}
		//service.findAll().forEach(System.out::println);
		cxt.close();
		
	
	}
	@Bean
	public Employee abi()
	{
		return new Employee(2,"Abi",LocalDate.now(),"Sivakasi","Swimmer",74770351L);
	}
	

}
