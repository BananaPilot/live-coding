package com.pasqualehorse.livecoding.exceptions;

public class NoContentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1869768358039800247L;

	public NoContentException() {
		super();
		
	}

	public NoContentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public NoContentException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public NoContentException(String message) {
		super(message);
	
	}

	public NoContentException(Throwable cause) {
		super(cause);
		
	}

	
}
