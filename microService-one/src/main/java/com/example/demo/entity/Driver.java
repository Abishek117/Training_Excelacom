package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "driver_17")
@AllArgsConstructor
@NoArgsConstructor
public class Driver 
{
	@Id
	@Column(name = "driver_id")
	private int driverId;
	
	@Column(name = "driver_name")
	private String name;
	
	@Column(name = "mobile_number")
	private long mobileNumber;
	
	@Column(name = "rating")
	private double rating;
	
	
}
