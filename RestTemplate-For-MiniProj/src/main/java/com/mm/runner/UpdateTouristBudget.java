package com.mm.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class UpdateTouristBudget implements CommandLineRunner {
	
	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
			
		String sUrl =
				"http://localhost:8080/SpringRestProj09-MiniProject/budget/{per}/{id}";
		
		template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		
		
		String str = 
				template.patchForObject(sUrl, null, String.class,0.1,401);
		
		
		
		
		System.out.println(str);
		
		System.exit(0);

	}

}





















