package com.mm.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.entity.Tourist;

//@Component
public class UpdateTourist implements CommandLineRunner {
	
	@Autowired
	private RestTemplate template;

//	Tourist(id=401, name=Willimsom, city=NewZiland, packageType=7Days, budget=17899.0)
	
	
	@Override
	public void run(String... args) throws Exception {
		
		String sUrl = "http://localhost:8080/SpringRestProj09-MiniProject/modify";
		
		Tourist tourist = 
					new Tourist(401,"Willimson","NewZiland","45Days",20000d);
//		
//		
//		template.put(sUrl, tourist);
//		
//		System.out.println("ActorUpdated");
		
		
		HttpHeaders headers = new HttpHeaders();
		
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		
		HttpEntity<Tourist> entity =
								new HttpEntity<Tourist>(tourist, headers);
		
		
		
		ResponseEntity<String> response = template.exchange(
										sUrl,
										HttpMethod.PUT,
										entity,
										String.class
										);
		
		
		String jbody = response.getBody();
		System.out.println(jbody);
		
		System.out.println("-----------------------");
		
		ObjectMapper om = new ObjectMapper();
		
		Tourist tobj = om.readValue(jbody, Tourist.class);
		
		System.out.println(tobj);
					
		System.exit(0);

	}

}
