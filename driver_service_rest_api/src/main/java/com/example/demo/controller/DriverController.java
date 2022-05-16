package com.example.demo.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Driver;
import com.example.demo.services.DriverService;


@RestController
@RequestMapping(value = "/api/v1")
public class DriverController
{
	
	private DriverService service;
	
	@Autowired
	public DriverController(DriverService service)
	{
		super();
		this.service = service;
	}
	
	@GetMapping(path = "/drivers")
	public List<Driver> getAllDrivers()
	{
		return this.service.findAll();
	}
	
	@GetMapping(path = "/drivers/{id}")
	public Driver getDriverById(@PathVariable("id") int id) {
		return this.service.findById(id)

;
	}
	
	@PostMapping(path = "/drivers")
	public ResponseEntity<Driver> addDriver(@RequestBody Driver entity){
		
		Driver driver = this.service.add(entity);
		
		URI location=
		           ServletUriComponentsBuilder
		          .fromCurrentRequest()				//http:locahhost:8080/drivers
		         .path("/{id}")							//http:locahhost:8080/drivers/{id}
		          .buildAndExpand(entity.getDriverId())	//http:locahhost:8080/drivers/103
		          .toUri();  
		
		return ResponseEntity.created(location).body(driver);  


	}
	
	@DeleteMapping(path="/drivers/remove/{id}")
	public ResponseEntity<String> removeDriver(@PathVariable("id") int id)
	{
		 Driver driver1=this.service.removeDriver(id);
		 
		 //return ResponseEntity.ok("element deleted");
		 
		 if(driver1 != null)
		 {
			 return ResponseEntity.status(204).build();
		 }
		 else
		 {
			 return ResponseEntity.ok("No record matching");
		 }
	}

	
	
	
	
	
	
}
