package com.uhc.fxiproviderservice.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uhc.fxiproviderservice.dto.Provider;
import com.uhc.fxiproviderservice.service.IFxiProviderService;

@RestController
public class FxiProviderController {
	@Autowired
	IFxiProviderService fxiProviderService;

	@PostMapping("/providers")
	public ResponseEntity<?> getProviders(@Valid @RequestBody Provider provider,
			@RequestParam(value = "prpr_Id") Optional<String> prpr_Id) {

		List<Provider> providerList = fxiProviderService.getProviderDetails(provider, prpr_Id);

		if (providerList.isEmpty())
			return new ResponseEntity<Object>(new ArrayList<>(), HttpStatus.NO_CONTENT);

		return new ResponseEntity<Object>(providerList, HttpStatus.OK);
	
	}
	/*@PostMapping("/token")
	public ResponseEntity<?> fetchToken() {

		List<Provider> providerList = fxiProviderService.getToken();

		if (providerList.isEmpty())
			return new ResponseEntity<Object>(new ArrayList<>(), HttpStatus.NO_CONTENT);

		return new ResponseEntity<Object>(providerList, HttpStatus.OK);
	}*/

	
	@GetMapping("/providers")
	public String getProviders() {

		return fxiProviderService.simpleRetry();

	}
}
