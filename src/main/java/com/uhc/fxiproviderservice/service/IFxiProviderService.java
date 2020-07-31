package com.uhc.fxiproviderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import com.uhc.fxiproviderservice.dto.Provider;
import com.uhc.fxiproviderservice.exception.RemoteServiceException;



public interface IFxiProviderService {
	@Retryable(value = { RemoteServiceException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	public List<Provider> getProviderDetails(Provider provider, Optional<String> prpr_Id);

	@Recover
	public String getProviderDetailsFallback(RuntimeException e);
	
	@Retryable(value = { RemoteServiceException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	 public String simpleRetry() ; 


}
