package com.mm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BootMvcProj07MiniProjectCurdOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj07MiniProjectCurdOperationsApplication.class, args);
	}

}
