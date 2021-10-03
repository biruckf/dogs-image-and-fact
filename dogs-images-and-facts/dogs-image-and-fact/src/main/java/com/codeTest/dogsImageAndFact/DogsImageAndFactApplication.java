package com.codeTest.dogsImageAndFact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
	 * This method is created to create a bean of RestTemplate
	 * 
	 * @return RestTemplate
	 *
	 */
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
