package com.url_shortenning.linkgenerationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LinkGenerationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkGenerationServiceApplication.class, args);
	}

}
