package com.playtomic.tests.wallet.exception;

public class StripeServiceException extends RuntimeException {
	
	public StripeServiceException(String msg) {
		super(msg);
	}
}
