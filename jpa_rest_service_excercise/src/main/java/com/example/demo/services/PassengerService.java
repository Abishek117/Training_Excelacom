package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Passenger;
import com.example.demo.entity.TripHistory;
import com.example.demo.ifaces.PassengerRepository;
import com.sun.xml.bind.v2.model.core.ID;

@Service
public class PassengerService 
{
	
	@Autowired
	PassengerRepository repo;
	
	@Autowired
	public PassengerService(PassengerRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Passenger add(Passenger entity)
	{
		return this.repo.save(entity);
	}
	
	public List<Passenger> findAll()
	{
		return this.repo.findAll();
	}
	
	public Passenger findById(int id)
	{
		return this.repo.findById(id).orElseThrow(()->new
				RuntimeException(id+"not found"));
	}
	
	public List<Passenger> findByName(String srchName)
	{
		return this.repo.findByPassengerName(srchName);
	}
	
	public Passenger findByLocalDateTime(LocalDateTime tripDateTime)
	{
 		return this.repo.findByTripListTripDateTime(tripDateTime);
 	}
	
	
	
	

}
