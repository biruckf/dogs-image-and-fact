package com.codeTest.dogsImageAndFact.model;

/**
 * @author biruckfeysa
 *
 *POJO class which will be used for create dogs facts and images objects 
 */
public class DogsFact {

	private String image;
	private String fact;
	
	

	public DogsFact() {
		
	}


	public DogsFact(String image, String fact) {
		this.image = image;
		this.fact = fact;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}

	@Override
	public String toString() {
		return "DogsFact [fact=" + fact + "]";
	}
	
	
	
	
}
