package com.codeTest.dogsImageAndFact.service;

import org.springframework.stereotype.Service;

import com.codeTest.dogsImageAndFact.model.DogsFact;


/**
 * @author biruckfeysa
 *
 */
@Service
public interface DogsService {

	public DogsFact[] getListOfDogsImagesAndFacts(int number);
}
