package com.mm.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.entity.Tourist;



//@Component
public class ShowTouristByIdObjectMapper implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
			
		String sUrl = "http://localhost:8080/SpringRestProj09-MiniProject/findTouriest/{tid}";
		
		ResponseEntity<String> response = template.exchange(sUrl,
						 HttpMethod.GET,
						 null,
						 String.class,
						 496);

		
		System.out.println("\n"+response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode().value());
		System.out.println(response.getStatusCode());
		
		
		System.out.println("-----------------------");
		
		String jbody = response.getBody();
		
		ObjectMapper om = new ObjectMapper();
		
		Tourist tobj = om.readValue(jbody, Tourist.class);
		
		System.out.println(tobj);
		
		
		System.exit(0);
		
	}

}
