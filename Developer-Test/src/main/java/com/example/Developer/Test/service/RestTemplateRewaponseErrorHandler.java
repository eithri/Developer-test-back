package com.example.Developer.Test.service;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class RestTemplateRewaponseErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return response.getStatusCode().is5xxServerError() || 
			   response.getStatusCode().is4xxClientError();
	}
	
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		if (response.getStatusCode().is5xxServerError()) {
			// HANDLE SERVER ERROR
		} else if(response.getStatusCode().is4xxClientError()) {
			// HANDLE CLIENT_ERROR
		}
	}


}
