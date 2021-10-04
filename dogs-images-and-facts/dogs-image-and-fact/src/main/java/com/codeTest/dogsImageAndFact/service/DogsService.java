package com.codeTest.dogsImageAndFact.service;

import org.springframework.stereotype.Service;

import com.codeTest.dogsImageAndFact.model.DogsFactAndImage;


/**
 * @author biruckfeysa
 *
 */
@Service
public interface DogsService {

	/**
	 * This method will trigger request for rest apis to get dogs fact and image
	 * and pass those values to populate images in to dogs facts class
	 * 
	 * @param number number of dogs
	 * @return DogsFactAndImage[] an array of dogsFactAndImage objects
	 */
	public DogsFactAndImage[] getListOfDogsImagesAndFacts(int number);
}
