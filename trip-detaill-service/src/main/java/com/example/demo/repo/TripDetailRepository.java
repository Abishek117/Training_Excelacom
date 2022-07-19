package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TripDetail;

public interface TripDetailRepository extends JpaRepository<TripDetail, Integer> 
{
	public Optional<TripDetail> findByDriverId(int id);

}
