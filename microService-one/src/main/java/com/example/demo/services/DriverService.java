package com.example.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	public List<Driver> findByName(String srchName)
	{
		return this.repo.findByName(srchName);
	}
	
	public List<Driver> srchByMobileNumber(long number)
	{
		return this.repo.findByMobileNumber(number);
	}
	
	public List<Driver> srchByRating(double rating)
	{
		return this.repo.searchByRating(rating);
	}
	
	public int updateRating(int id,double updatedRating)
	{
		return this.repo.modifyRating(id,updatedRating);
	}
	
	public int updateId(int id,int updatedId)
	{
		return this.repo.modifyId(id, updatedId);
	}
	
	public List<Driver> sortedList(String sortName)
	{
		return this.repo.findAll(Sort.by(sortName));
	}
	
	
}

