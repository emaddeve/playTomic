package com.playtomic.tests.wallet.exception;

public class StripeAmountTooSmallException extends StripeServiceException {
	
	
	public StripeAmountTooSmallException(String msg) {
		super(msg);
	}
}
