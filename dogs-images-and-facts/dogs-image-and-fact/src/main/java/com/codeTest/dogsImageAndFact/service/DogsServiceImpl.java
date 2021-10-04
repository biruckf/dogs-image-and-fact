package com.codeTest.dogsImageAndFact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codeTest.dogsImageAndFact.advise.RestTemplateErrorHandler;
import com.codeTest.dogsImageAndFact.model.DogsFactAndImage;
import com.codeTest.dogsImageAndFact.model.DogsImage;

/**
 * @author biruckfeysa
 *
 */
@Service
public class DogsServiceImpl implements DogsService {

	@Autowired
	private RestTemplate restTemplate;

	public DogsServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		restTemplate = restTemplateBuilder.errorHandler(new RestTemplateErrorHandler()).build();
	}

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
		return restTemplate.getForObject("https://dog-facts-api.herokuapp.com/api/v1/resources/dogs?number=" + num,
				DogsFactAndImage[].class);
	}

	private DogsImage getDogsImage(int num) {
		return restTemplate.getForObject("https://dog.ceo/api/breeds/image/random/" + num, DogsImage.class);
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
