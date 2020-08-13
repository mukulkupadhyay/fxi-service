package com.uhc.fxiproviderservice.service;

import java.util.List;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import com.uhc.fxiproviderservice.dto.Provider;
import com.uhc.fxiproviderservice.dto.ProviderResponse;
import com.uhc.fxiproviderservice.exception.RemoteServiceException;

public interface IFxiProviderService {
	
	@Retryable(value = { RemoteServiceException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	public List<ProviderResponse> getProviderDetails(Provider provider);

	@Recover
	public String getProviderDetailsFallback(RuntimeException e);

	@Retryable(value = { RemoteServiceException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	public String simpleRetry();

}
