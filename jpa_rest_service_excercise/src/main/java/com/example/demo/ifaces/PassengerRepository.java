package com.example.demo.ifaces;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

	List<Passenger> findByPassengerName(String srchName);
	
	Passenger findByTripListTripDateTime(LocalDateTime tripDateTime);
}