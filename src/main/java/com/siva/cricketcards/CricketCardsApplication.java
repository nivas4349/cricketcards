package com.siva.cricketcards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableCaching
@EnableFeignClients
public class CricketCardsApplication {
	// TODO : use Taken based authentication or oAuth for APIs
	// TODO : mock controller test cases
	// TODO : mock and write Service test cases
	public static void main(String[] args) {
		SpringApplication.run(CricketCardsApplication.class, args);
	}

}
