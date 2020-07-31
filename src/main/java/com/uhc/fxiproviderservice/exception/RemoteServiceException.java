package com.uhc.fxiproviderservice.exception;

public class RemoteServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RemoteServiceException(String msg) {
		super(msg);
	}

	public RemoteServiceException(String msg, Exception ex) {
		super(msg, ex);
	}
}
