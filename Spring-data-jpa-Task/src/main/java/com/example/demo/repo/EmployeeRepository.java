package com.example.demo.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.entity.Employee;
import com.sun.xml.bind.v2.model.core.ID;

public interface EmployeeRepository extends JpaRepository<Employee, ID> {
	
//	public List<Employee> findByDate(LocalDate srch);
//	public List<Employee> findByLocationAndSkillSets(String location,String skillSet);
	/*@Query(nativeQuery = true,
			value = "select ,employee_name,department,"
					+ "phone_number from sp_doctor where doctor_name=:docName or department=:dept")
	public List<Employee> findByNameOrDept(@Param("docName") String docName, @Param("docDept") String docDept);
	*/
	
	
	

}
