package com.mm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
	//DataProperties
	
	private Integer pid;
	
	private String pname;
	
	private Double pprice;
	
	private String pcountry="US";
	

}
