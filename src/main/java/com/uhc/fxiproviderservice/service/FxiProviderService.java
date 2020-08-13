package com.uhc.fxiproviderservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uhc.fxiproviderservice.dto.Provider;
import com.uhc.fxiproviderservice.dto.ProviderResponse;
import com.uhc.fxiproviderservice.exception.RemoteServiceException;

@Service
public class FxiProviderService implements IFxiProviderService {

	@Autowired
	RestTemplate restTemplate;
	final String URI = "http://dummy.restapiexample.com/api/v1/employee/1";

	@Override
	public List<ProviderResponse> getProviderDetails(Provider provider) {

		ResponseEntity<ProviderResponse> response = restTemplate.postForEntity(URI, provider, ProviderResponse.class);

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
