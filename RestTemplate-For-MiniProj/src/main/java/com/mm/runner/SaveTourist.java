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

@Component
public class SaveTourist implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	
	
	@Override
	public void run(String... args) throws Exception {
			
		String sUrl = "http://localhost:8080/SpringRestProj09-MiniProject/register";
		
		
		Tourist tourist = new Tourist("iiii","India","0Days",757575d);
		
//		HttpHeaders headers = new HttpHeaders();
//		
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		
//		HttpEntity<Tourist> entity = new HttpEntity<Tourist>(tourist, headers);
//		
//		
//		
//		ResponseEntity<String> response =
//				template.postForEntity(sUrl, entity, String.class);
		
		String msg = template.postForObject(sUrl, tourist, String.class);
		
		System.out.println(msg);
		
		
		
//		System.out.println(msg.getBody());
//		System.out.println(response.getHeaders());
//		System.out.println(response.getStatusCode().value());
//		
		System.exit(0);
		
		
	}
	

}






















