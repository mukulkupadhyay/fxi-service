package com.uhc.fxiproviderservice.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.uhc.fxiproviderservice.dto.Provider;
import com.uhc.fxiproviderservice.dto.ProviderResponse;
import com.uhc.fxiproviderservice.service.IFxiProviderService;

@RestController
public class FxiProviderController {
	@Autowired
	IFxiProviderService fxiProviderService;
	
	Logger logger=LoggerFactory.getLogger(FxiProviderController.class);

	@PostMapping("/providers")
	public ResponseEntity<?> getProviders(@RequestBody Provider provider, @RequestHeader HttpHeaders headers) {

		logger.info("Inside getProviders"+provider.toString());
		
		List<ProviderResponse> providerList = fxiProviderService.getProviderDetails(provider);
		if (providerList.isEmpty())
			return new ResponseEntity<Object>(new ArrayList<>(), HttpStatus.NO_CONTENT);

		return new ResponseEntity<Object>(providerList, HttpStatus.OK);

	}

	@GetMapping("/providers")
	public String getProviders() {

		return fxiProviderService.simpleRetry();

	}
}
