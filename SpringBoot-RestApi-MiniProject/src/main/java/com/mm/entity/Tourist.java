package com.mm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="REST_TOURIST")
public class Tourist {
	
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "tourist_sq",initialValue = 100,allocationSize = 5)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(length = 20)
	@NonNull
	private String name;
	
	
	@Column(length = 20)
	@NonNull
	private String city;
	
	@Column(length = 20)
	@NonNull
	private String packageType;
	
	
	@NonNull
	private Double budget;
	

}












