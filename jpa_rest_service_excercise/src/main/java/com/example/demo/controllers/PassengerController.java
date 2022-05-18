package com.example.demo.controllers;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Passenger;
import com.example.demo.services.PassengerService;

@RestController
@RequestMapping(value = "/api/v1")
public class PassengerController 
{
	
	private PassengerService service;

	@Autowired
	public PassengerController(PassengerService service)
	{
		super();
		this.service = service;
	}
	
	@PostMapping(path = "/passengers/add")
	public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger entity){
		
		Passenger passenger = this.service.add(entity);
		
		URI location=
		           ServletUriComponentsBuilder
		          .fromCurrentRequest()				//http:locahhost:8080/drivers
		         .path("/{id}")							//http:locahhost:8080/drivers/{id}
		          .buildAndExpand(entity.getPassengerId())	//http:locahhost:8080/drivers/103
		          .toUri();  
		
		return ResponseEntity.created(location).body(passenger); 
	}
	
	@GetMapping(path = "/passengers")
	public List<Passenger> getAllDrivers()
	{
		return this.service.findAll();
	}
	
	@GetMapping(path = "/passengers/id/{id}")
	public Passenger getDriverById(@PathVariable("id") int id) {
		return this.service.findById(id);
	}
	
	@GetMapping(path = "/passengers/srch/name/{name}")
	public List<Passenger> getDriverByName(@PathVariable("name") String name)
	{
		return this.service.findByName(name);
	}
	
	@GetMapping(path= "/passengers/srch/date/{tripDateTime}")
	public Passenger findByLocalDateTime(@PathVariable("tripDateTime")	@DateTimeFormat(iso= ISO.DATE_TIME)
          LocalDateTime date )
	{
	return  this.service.findByLocalDateTime(date);
	}
	
}
