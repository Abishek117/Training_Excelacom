package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DriverDTO 
{
	
	private int driverId;
	private String driverName;
	private long mobileNumber;
	private double rating;

}
