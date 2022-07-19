package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.CabDriver;
import com.example.demo.entity.TripDTO;
import com.example.demo.entity.TripDetail;

@RestController
@RequestMapping(path = "/client")
public class ClientController 
{
	
	private RestTemplate template;
	
	@Autowired
	public ClientController(RestTemplate template)
	{
			super();
			this.template = template;
		
	}

	@Autowired
		private TripDTO dto;	
	
	
	
	
	@GetMapping(path="/drivers")
	public String getDrivers()
	{
		//json is nothing but string
		return this.template.
				getForObject("http://cab-driver-service/api/v1/drivers",String.class);
	}
	
	
	@GetMapping(path="/drivers/json")
	public CabDriver[] getDriversAsJson()
	{
		//json is nothing but string
		return this.template.
				getForObject("http://cab-driver-service/api/v1/drivers",CabDriver[].class);
	}
	
	
	@GetMapping(path="/driver/trips/{id}")
	public String getDriverTrips(@PathVariable("id") int id)
	{
		String driver=this.template.getForObject("http://cab-driver-service/api/v1/drivers/"+id, String.class);
	   
		String trips=this.template.getForObject("http://trip-detail-service/api/v1/trips/srch/"+id, String.class);	

		return driver+trips;
	}

	
	@GetMapping(path="/srch/driver/{id}")
	public TripDTO getDriverTripsJson(@PathVariable("id")int id)
	{
		
		CabDriver driver= this.template.getForObject("http://cab-driver-service/api/v1/drivers/"+id, CabDriver.class);
		TripDetail[] trips = this.template.getForObject("http://trip-detail-service/api/v1/trips/srch/"+id, TripDetail[].class);
		dto.setDriver(driver);
		List<TripDetail>detailSet= Arrays.asList(trips);
		dto.setTrips(detailSet);
		return dto;
	}	
}