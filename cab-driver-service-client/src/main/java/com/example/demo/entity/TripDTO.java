package com.example.demo.entity;


import java.util.List;
//import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.demo.entity.CabDriver;
import com.example.demo.entity.TripDetail;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Component
@FieldDefaults(level=AccessLevel.PRIVATE)
public class TripDTO {
	
	private CabDriver driver;
	private List<TripDetail> trips;


}