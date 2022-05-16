package com.example.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Driver;
import com.example.demo.ifaces.DriverRepository;


@Service
public class DriverService 
{
	
	@Autowired
	private DriverRepository repo;
	
	@Autowired
	public DriverService(DriverRepository repo) 
	{
		super();
		this.repo = repo;
	}
	

	public List<Driver> findAll()
	{
		return this.repo.findAll();
	}

	public Driver add(Driver entity)
	{
		return this.repo.save(entity);
	}
	
	public Driver findById(int id)
	{
		return this.repo.findById(id).orElseThrow(()->new RuntimeException(id+"not found"));
	}
	

	public Driver removeDriver(int id)
	{
		try
		{
			this.repo.deleteById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	
	}
	
	
	
	

}
