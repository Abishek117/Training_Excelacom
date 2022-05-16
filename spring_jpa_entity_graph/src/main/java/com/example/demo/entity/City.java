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
@Table(name = "abi_city_2022")
@AllArgsConstructor
@NoArgsConstructor
public class City 
{
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;

}
