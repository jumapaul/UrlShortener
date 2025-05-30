package com.url_shortenning.linkredirectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LinkRedirectionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkRedirectionServiceApplication.class, args);
	}

}
