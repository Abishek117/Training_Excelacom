package com.example.demo.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.entity.Employee;
import com.sun.xml.bind.v2.model.core.ID;

public interface EmployeeRepository extends JpaRepository<Employee, ID> {
	
	public List<Employee> findByDate(LocalDate findDate);
	public List<Employee> findByLocation(String findLocation);
	public List<Employee> findBySkillSet(String findSkillSet);

	
	@Query(nativeQuery = true,value = "select * from abi_emp17_2022 where location=:location and skillset=:skillSet")
	public List<Employee> findByLocationAndSkillSet(@Param("location") String empLoc
			,@Param("skillSet") String empSkill);
	
	
	

}
