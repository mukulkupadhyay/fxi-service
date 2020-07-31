package com.uhc.fxiproviderservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uhc.fxiproviderservice.dto.Provider;
import com.uhc.fxiproviderservice.exception.RemoteServiceException;
import com.uhc.fxiproviderservice.service.IFxiProviderService;

@Service
public class FxiProviderService implements IFxiProviderService {

	@Autowired
	RestTemplate restTemplate;
	final String URI = "https://localhost:8080/springData/person";
	
	@Override
	public  List<Provider> getProviderDetails(Provider provider, Optional<String> prpr_Id) {

		ResponseEntity<Provider[]> response = restTemplate.getForEntity(URI, Provider[].class);
		return Arrays.asList(response.getBody());
	}
	
	 public String simpleRetry() throws RemoteServiceException {
	       
	        System.out.println("Billing Service Failed ");
	        throw new RemoteServiceException("Remote");
	    }

	@Override
	public String getProviderDetailsFallback(RuntimeException e) {
		System.out.println("All retries Completed, so Fallback method called!!!");
		return "All retries completed, so Fallback method called!!!";
	}

}
