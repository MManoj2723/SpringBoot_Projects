package com.mm.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.entity.Tourist;



@Component
public class ShowAllTourists implements CommandLineRunner {

	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		
		String sUrl = "http://localhost:8080/SpringRestProj09-MiniProject/findAll";
		

		
	ResponseEntity<List<Tourist>> response = template.exchange(sUrl,
												HttpMethod.GET,
												null,
												new ParameterizedTypeReference<List<Tourist>>() {});
		
		
		response.getBody().forEach(System.out::println);
		
		System.out.println("------------------");
		
//		ObjectMapper om = new ObjectMapper();
		
//		List<Tourist> list = 
//					om.readValue(response.getBody(), new TypeReference<List<Tourist>>() {});
//		
//		list.forEach(System.out::println);
	
		
		System.out.println(response.getStatusCode());
		
		System.exit(0);
		
		
		
	}


}
