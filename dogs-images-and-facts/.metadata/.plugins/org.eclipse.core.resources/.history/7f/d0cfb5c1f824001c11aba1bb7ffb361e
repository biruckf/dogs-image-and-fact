package com.codeTest.dogsImageAndFact.advise;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;

/**
 * @author biruckfeysa
 * 
 * RestTemplate exceptions handler class
 *
 */
@Component
public class RestTemplateErrorHandler implements ResponseErrorHandler{

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		
		return (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR 
		          || response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		if (response.getStatusCode()
		          .series() == HttpStatus.Series.SERVER_ERROR) {
			         throw new HttpServerErrorException(response.getStatusCode(), response.getStatusText());
		        } else if (response.getStatusCode()
		          .series() == HttpStatus.Series.CLIENT_ERROR) {
		        	throw new HttpClientErrorException(response.getStatusCode(), response.getStatusText());
		        }if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
		                throw new RestClientException("The resource could not be found. Please check your query");
		            
		        }
	}

}
