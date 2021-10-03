package com.codeTest.dogsImageAndFact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeTest.dogsImageAndFact.model.DogsFact;
import com.codeTest.dogsImageAndFact.service.DogsService;


/**
 * @author biruckfeysa
 *
 *DogsController class is created to handle all requests with request mapping of  /dogs
 */
@RestController
@RequestMapping("/dogs")
public class DogsController {

	@Autowired
	private DogsService dogsService;
	
	
	
	/**
	 * @param number
	 * @return DogsFact[]
	 * 
	 */
	@GetMapping("/ImagesAndFacts/{num}")
	public DogsFact[] getDogsImageAndFact(@PathVariable(value="num") int number) {
		
		return dogsService.getListOfDogsImagesAndFacts(number);
		
	}
}
