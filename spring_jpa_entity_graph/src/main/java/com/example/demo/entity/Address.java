package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "abi_address_2022")
@AllArgsConstructor
@NoArgsConstructor

public class Address 
{
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
}
