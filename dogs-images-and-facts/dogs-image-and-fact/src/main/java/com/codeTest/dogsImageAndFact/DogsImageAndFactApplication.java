package com.codeTest.dogsImageAndFact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author biruckfeysa
 * 
 */
@SpringBootApplication
public class DogsImageAndFactApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogsImageAndFactApplication.class, args);
	}
	
	
	/**
	 * This method is created to create a bean of WebClient.Builder
	 * 
	 * @return WebClient.Builder
	 *
	 */
	
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

}
