package com.example.xsis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class XsisRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(XsisRestApiApplication.class, args);
	}

}
