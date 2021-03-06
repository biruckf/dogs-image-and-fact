package com.codeTest.dogsImageAndFact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.codeTest.dogsImageAndFact.advise.ServiceException;
import com.codeTest.dogsImageAndFact.dto.DogsFactAndImage;
import com.codeTest.dogsImageAndFact.dto.DogsImage;

import reactor.core.publisher.Mono;

/**
 * @author biruckfeysa
 *
 */
@Service
public class DogsServiceImpl implements DogsService {
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	/**
	 * This method will trigger request for rest apis to get dogs fact and image
	 * and pass those values to populate images in to dogs facts class
	 * 
	 * @param number of dogs
	 * @return DogsFactAndImage[] Array of DogsFactAndImage object
	 * 
	 * 
	 */
	@Override
	public DogsFactAndImage[] getListOfDogsImagesAndFacts(int number) {

		return this.populateImages(this.getDogsFact(number), this.getDogsImage(number));
	}

	private DogsFactAndImage[] getDogsFact(int num) {
		
		return webClientBuilder.build()
				.get()
				.uri("https://dog-facts-api.herokuapp.com/api/v1/resources/dogs?number=" + num)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new ServiceException("Method not allowed. Please check the URL.", response.statusCode().value())))
				.onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new ServiceException("Internale server error occured", response.statusCode().value())))
				.bodyToMono(DogsFactAndImage[].class)
				.block();
		
	}

	/**
	 * @param num
	 * @return
	 */
	private DogsImage getDogsImage(int num) {
	
		return webClientBuilder.build()
				.get()
				.uri("https://dog.ceo/api/breeds/image/random/" + num)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new ServiceException("Method not allowed. Please check the URL.", response.statusCode().value())))
				.onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new ServiceException("Internale server error occured", response.statusCode().value())))
				.bodyToMono(DogsImage.class)
				.block();
	}

	
	/**
	 * This method will populate dogsImage  to the objects of DogsFactAndImage
	 * 
	 * 
	 * @param dogsFactAndImage[] an array of dogsFactAndImage
	 * @param dogsImage an object of dogsImage
	 * @return DogsFactAndImage[] an array of dogsFactAndImage
	 */
	private DogsFactAndImage[] populateImages(DogsFactAndImage[] dogsFactAndImage, DogsImage dogsImage) {
		int size = dogsFactAndImage.length <= dogsImage.getMessage().length ? dogsFactAndImage.length : dogsImage.getMessage().length;

		for (int i = 0; i < size; i++) {
			dogsFactAndImage[i].setImage(dogsImage.getMessage()[i]);
		}

		return dogsFactAndImage;
	}

}
