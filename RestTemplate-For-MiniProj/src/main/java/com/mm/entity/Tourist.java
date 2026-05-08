package com.mm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Tourist {
	
	private Integer id;
	
	@NonNull
	private String name;
	
	
	@NonNull
	private String city;
	
	
	@NonNull
	private String packageType;
	
	
	@NonNull
	private Double budget;
	

}












