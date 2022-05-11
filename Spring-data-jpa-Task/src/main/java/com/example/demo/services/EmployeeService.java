package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository repo;
	
	@Autowired
	public EmployeeService(EmployeeRepository repo) {
		super();
		this.repo=repo;
	}
	
	public Employee add(Employee entity)
	{
		return this.repo.save(entity);
	}
	
	public List<Employee> findAll()
	{
		return this.repo.findAll();
	}

}
