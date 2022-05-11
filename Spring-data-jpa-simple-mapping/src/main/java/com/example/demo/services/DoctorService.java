package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.repo.DoctorRepository;

@Service
public class DoctorService {

	private DoctorRepository repo;
	
	@Autowired
	public DoctorService(DoctorRepository repo) {
		super();
		this.repo=repo;
	}
	
	
	public Doctor add(Doctor entity)
	{
		return this.repo.save(entity);
	}
	
	
	public List<Doctor> findAll()
	{
		return this.repo.findAll();
	}
	
	public List<Doctor> findByDept(String srchString)
	{
		return this.repo.findByDepartment(srchString);
	}
	
	public List<Doctor> findByDepartment(String srch)
	{
		return this.repo.findByDepartment(srch);
	}
	
	public Doctor findByDoctorName(String srch)
	{
		return this.repo.findByDoctorName(srch);
	}
	
	public List<Doctor> findByDoctorNameAndDepartment(String docName,String docDept)
	{
		return this.repo.findByDoctorNameAndDepartment(docName, docDept);
	}
	
	public List<Doctor> findByNameOrDept(@Param("docName") String docName, @Param("docDept") String docDept)
	{
		return this.repo.findByNameOrDept(docName, docDept);
	}



}
