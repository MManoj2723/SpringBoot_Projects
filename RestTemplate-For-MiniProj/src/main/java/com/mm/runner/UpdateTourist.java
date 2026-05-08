package com.mm.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
					new Tourist(401,"Willimson","NewZiland","10Days",20000d);
		
		
		template.put(sUrl, tourist);
		
		
		
		System.out.println("ActorUpdated");
		
		System.exit(0);

	}

}
