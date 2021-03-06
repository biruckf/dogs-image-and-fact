package com.codeTest.dogsImageAndFact.advise;

import javax.management.ServiceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author biruckfeysa
 * 
 * This class will handle controller level exceptions
 *
 */
@ControllerAdvice
public class CustomControllerAdvice {

	@ExceptionHandler(ServiceNotFoundException.class)
	public ResponseEntity<String> handleResourseNotFoundException(ServiceNotFoundException serviceNotFoundException){
		
		return new ResponseEntity<String>("Requested resourse not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public ResponseEntity<String> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException outOfBoundException){
		
		return new ResponseEntity<String>("Bad request query, please check your query", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<String> handleNumberFormatException(NumberFormatException numberFormatException){
		return new ResponseEntity<String>("Bad request query, please check your query", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
	
		return new ResponseEntity<String>(e.getCause() + "server exception "  , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
