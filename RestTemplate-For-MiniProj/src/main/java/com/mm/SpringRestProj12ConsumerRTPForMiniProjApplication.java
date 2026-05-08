package com.mm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRestProj12ConsumerRTPForMiniProjApplication {
	
	
	
	@Bean(name="template")
	public RestTemplate createTemplate() {
		return new RestTemplate();
	}

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRestProj12ConsumerRTPForMiniProjApplication.class, args);
	}

}
