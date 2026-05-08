package com.mm.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mm.entity.Tourist;

//@Component
public class ShowTouristByID implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		
		String sUrl = "http://localhost:8080/SpringRestProj09-MiniProject/findTouriest/{id}";
		
		
		ResponseEntity<Tourist> response =
									 template.getForEntity(sUrl, Tourist.class, 401);
		
		
		
	
		
//		ResponseEntity<String> response =
//				 template.getForEntity(sUrl, String.class, 401);
		
		System.out.println(response.getBody());
		
		System.exit(0);
		
	}

}
