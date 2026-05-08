package com.mm.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mm.entity.Tourist;


//@Component
public class SaveTourist implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	
	
	@Override
	public void run(String... args) throws Exception {
			
		String sUrl = "http://localhost:8080/SpringRestProj09-MiniProject/register";
		
		
		
		
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Tourist tourist = new Tourist("Naruto","Konoha","12Days",12000d);
		
		HttpEntity<Tourist> entity = new HttpEntity<Tourist>(tourist,headers);
		
		ResponseEntity<String> response = template.exchange(sUrl,
										  HttpMethod.POST,
										  entity,
										  String.class
										  );
		
		
		
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode().value());
		
		System.exit(0);
		
		
	}
	

}
