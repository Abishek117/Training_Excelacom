package com.example.demo;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Passenger;
import com.example.demo.entity.TripHistory;
import com.example.demo.ifaces.PassengerRepository;

@SpringBootApplication
public class JpaRestServiceExcerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaRestServiceExcerciseApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner()   //CommandLineRunner is a functional interface.press f3 to know more
	{
		return new CommandLineRunner() 
		{
			
			@Autowired
			PassengerRepository repo;
			@Override
			public void run(String... args) throws Exception 
			{
				TripHistory trip1 = new TripHistory(202,LocalDateTime.of(2022,Month.AUGUST,17,03,25),"Kochin","chennai",5000.00);
				List<TripHistory> tripList = new ArrayList<TripHistory>();
				tripList.add(trip1);
				
				 repo.save(new Passenger(102,"abi","abi@gmail.com","Kochin",tripList));
			}
		};
	}
}
