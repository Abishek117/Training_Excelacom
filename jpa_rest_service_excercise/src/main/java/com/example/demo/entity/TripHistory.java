package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "abi_trip_history")
@AllArgsConstructor
@NoArgsConstructor
public class TripHistory 
{
	@Id
	@Column(name = "trip_id")
	private int tripId;
	
	@Column(name = "trip_time")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime tripDateTime;
	
	@Column(name = "starting_point")
	private String source;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "amount")
	private double amount;
}