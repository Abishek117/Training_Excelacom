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
		
		Employee empObj = cxt.getBean(Employee.class);
		
		Employee added1 = service.add(empObj);
		
		if(added1!=null)
		{
			System.out.println("One Employee Added");
		}
		
//		service.findByDate(LocalDate.of(2001, 03, 17)).forEach(System.out::println);
//		
//		service.findByLocation("Sivakasi").forEach(System.out::println);
//		
//		System.out.println(service.findBySkillSet("Math"));
		
		//System.out.println(service.findByLocationAndSkillSet("Sivakasi", "Swimmer"));
		
		System.out.println("*******Now our table is*******");
		service.findAll().forEach(System.out::println);
		System.out.println("******************************");
		
		
		cxt.close();
		
	
	}
	@Bean
	public Employee abi()
	{
		return new Employee(3,"Hari",LocalDate.of(2004, 02, 02),"ALPT","Chess",8964533L);
	}
	
	
	

}
