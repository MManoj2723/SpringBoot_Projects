package com.mm.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class DeletTouristById implements CommandLineRunner {
	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		
		
		String sUrl =
				"http://localhost:8080/SpringRestProj09-MiniProject/delete/{id}";
		
		template.delete(sUrl,497);
		
		System.out.println("Tourist Deleted\n");
		
		System.exit(0);
	}

}
