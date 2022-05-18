package com.example.demo.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(path = "/drivers/id/{id}")
	public Driver getDriverById(@PathVariable("id") int id) {
		return this.service.findById(id);
	}
	
	@GetMapping(path = "/drivers/srch/name/{name}")
	public List<Driver> getDriverByName(@PathVariable("name") String name)
	{
		return this.service.findByName(name);
	}
	
	@GetMapping(path = "/drivers/srch/number/{mobileNumber}")
	public List<Driver> getDriverByMobileNumber(@PathVariable("mobileNumber") long number)
	{
		return this.service.srchByMobileNumber(number);
	}
	
	@GetMapping(path = "/drivers/srch/rating/{rating}")
	public List<Driver> getDriverByRating(@PathVariable("rating") double rating)
	{
		return this.service.srchByRating(rating);
	}
	
	@PutMapping(path="/drivers/updated/{id}/{rating}")
	public ResponseEntity<String> updateRating(@PathVariable("id") int id,
			@PathVariable("rating") double updatedRating)
	{
		int rowsUpdated  = this.service.updateRating(id, updatedRating);
		return ResponseEntity.ok().body(rowsUpdated+"updated");
	}
	
	@PutMapping(path="/drivers/updated/id/{id}/{driverId}")
	public ResponseEntity<String> updateId(@PathVariable("id") int id,
			@PathVariable("driverId") int updatedId)
	{
		int rowsUpdated  = this.service.updateId(id, updatedId);
		return ResponseEntity.ok().body(rowsUpdated+"updated");
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
	
	@GetMapping(path="/drivers/sort/{name}")
    public List<Driver> getNameBySort(@PathVariable("name") String driverName)
    {
    	return this.service.sortedList(driverName);
    }	
	
}
