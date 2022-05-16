package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
	
	
	public List<Employee> findByDate(LocalDate findDate)
	{
		return this.repo.findByDate(findDate);
	}
	
	public List<Employee> findByLocation(String findLocation)
	{
		return this.repo.findByLocation(findLocation);
	}
	
	public List<Employee> findBySkillSet(String findSkillSet)
	{
		return this.repo.findBySkillSet(findSkillSet);
	}
	
	
	public List<Employee> findByLocationAndSkillSet(String empLoc, String empSkill)
	{
		return this.repo.findByLocationAndSkillSet(empLoc, empSkill);
	}



}
