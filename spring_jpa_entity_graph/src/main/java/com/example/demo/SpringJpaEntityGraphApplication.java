package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Address;
import com.example.demo.entity.City;
import com.example.demo.entity.User;
import com.example.demo.ifaces.AddressRepository;
import com.example.demo.services.AddressService;

@SpringBootApplication
public class SpringJpaEntityGraphApplication {

	public static void main(String[] args)
	{
		ConfigurableApplicationContext ctx =  SpringApplication.run(SpringJpaEntityGraphApplication.class, args);
		AddressService service = ctx.getBean(AddressService.class);
		service.task3();
		ctx.close();
	}

	
	
	@Bean
	public CommandLineRunner runner()   //CommandLineRunner is a functional interface.press f3 to know more
	{
		return new CommandLineRunner() 
		{
			
			@Autowired
			AddressRepository repo;
			@Override
			public void run(String... args) throws Exception 
			{
				City sivakasi = new City(980,"Sivakasi");
				City thiruthangal = new City(780,"Thiruthangal");
				
				User abi = new User(700,"Abi",6789788L);
				User hari = new User(701,"Hari",9889765L);
				
				Address address1 = new Address(101,"Mr.",sivakasi, abi);
				Address address2 = new Address(102,"Dr.",thiruthangal, hari);
				
				this.repo.save(address1);
				this.repo.save(address2);

			
			}
		};
	}
}
