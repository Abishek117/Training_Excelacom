package com.example.demo.ifaces;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Driver;


public interface DriverRepository extends JpaRepository<Driver, Integer>
{

	List<Driver> findByName(String srchName);
	
	//In the entity class there is no property firstname, so an exception will be thrown
	//List<Driver> findByFirstName(String srchName);
	
	
	List<Driver> findByMobileNumber(long mobileNumber);
	
 	
	@Query(value = "from Driver where rating=:srchValue")
	List<Driver> searchByRating(@Param("srchValue")double rating);
	
	@Query(value = "update Driver set rating =:updatedRating where driverId=:srchId")
	@Modifying
	@Transactional
	int modifyRating(@Param("srchId") int driverId,@Param("updatedRating")double updatedRating);
	
	@Query(value = "update Driver set driverId =:updatedId where driverId=:srchId")
	@Modifying
	@Transactional
	int modifyId(@Param("srchId") int driverId,@Param("updatedId")int updatedId);

}
