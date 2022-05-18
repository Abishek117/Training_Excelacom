package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "abi_passenger")
@AllArgsConstructor
@NoArgsConstructor
public class Passenger 
{
	@Id
	@Column(name = "passenger_id")
	private int passengerId;
	
	@Column(name = "passenger_name")
	private String passengerName;
	
	@Column(name = "passenger_email")
	private String email;
	
	@Column(name = "location")
	private String location;
	
	@OneToMany(targetEntity = TripHistory.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="passenger_ref",referencedColumnName = "passenger_id")
	
	List<TripHistory> tripList;
}