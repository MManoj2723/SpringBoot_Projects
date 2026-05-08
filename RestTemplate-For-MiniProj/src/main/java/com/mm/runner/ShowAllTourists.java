package com.mm.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mm.entity.Tourist;

//@Component
public class ShowAllTourists implements CommandLineRunner {
	
	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		
		String sUrl = "http://localhost:8080/SpringRestProj09-MiniProject/findAll";
		

		
		ResponseEntity<List<Tourist>> response = template.exchange(
			   
				sUrl,
			    HttpMethod.GET,
			    null,
			    new ParameterizedTypeReference<List<Tourist>>() {}
			);
		
		response.getBody().forEach(System.out::println);
//		
		
//		ResponseEntity<String> response = template.getForEntity(sUrl, String.class);
//		
//		System.out.println(response.getBody()+"\n------------------------");
//		
//		
//		ObjectMapper om = new ObjectMapper();
//		
//				List<Tourist> value = 
//						om.readValue(response.getBody(), new TypeReference<List<Tourist>>() {});
//				
//				value.forEach(System.out::println);
				
		
		
		
//		if(response.getStatusCode()==HttpStatus.OK) {
//			
//			System.out.println("\n\n");
//			
//			System.out.println(response.getBody());
//			
//		}
//		else {
//			
//			System.out.println("SomeThing Went Wrong");
//		}
//		
		
		
		
		
		// template.getForObject
		
//		Tourist[] tarr = template.getForObject(sUrl, Tourist[].class);
		
		
//		
//		
//		Arrays.stream(tarr).forEach(System.out::println);
//
		
			//List Of Tourist Coming in the form of String		
//		String str = template.getForObject(sUrl, String.class);
//		
//		System.out.println(str);
//		
		
		System.exit(0);
		
		
		
	}

}



