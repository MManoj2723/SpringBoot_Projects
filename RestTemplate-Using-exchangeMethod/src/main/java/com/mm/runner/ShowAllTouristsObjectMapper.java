package com.mm.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.entity.Tourist;



//@Component
public class ShowAllTouristsObjectMapper implements CommandLineRunner {

	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		
		String sUrl = "http://localhost:8080/SpringRestProj09-MiniProject/findAll";
		

		ResponseEntity<String> response =
											template.exchange(sUrl,
												HttpMethod.GET,
												null,
												String.class);
		
		String jsonResponse = response.getBody();
				
		System.out.println(jsonResponse);
		
		System.out.println(response.getStatusCode());
		
		
		System.out.println("------------------");
		
		
		ObjectMapper om = new ObjectMapper();
		
		List<Tourist> listOfTourists =
						om.readValue(jsonResponse, new TypeReference<List<Tourist>>() {});
		
		listOfTourists.forEach(System.out::println);
		
		
		System.exit(0);
		
		
		
	}


}
