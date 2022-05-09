package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Product;
import com.example.demo.ifaces.ProductRepository;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args)
	{
		ApplicationContext ctx = SpringApplication.run(SpringJdbcApplication.class, args);
		ProductRepository repo = ctx.getBean(ProductRepository.class);
		Product tv = ctx.getBean(Product.class);
		
		
		//System.out.println("         Adding...         ");
		//System.out.println("rowAdded : " + repo.add(tv));
		
		//System.out.println("        Find By ID         ");
		//System.out.println("Id to be found : " + repo.findById(5) );
		
		//System.out.println("         Removing....      ");
		//System.out.println("Row removed : " +repo.remove(4));
		
		System.out.println("         Updating...       ");
		System.out.println("Row Updated : " + repo.update(tv));
		
		
		System.out.println("         Find all entities       ");
		repo.findAll().forEach(System.out::println);
		
		
		
	}
	@Bean
	public Product tv()
	{
		return new Product(25,"tv",4000);
	}

}
