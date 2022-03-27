package com.playtomic.tests.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * error managment
 * @author ear
 *
 */

@ControllerAdvice
public class ControllerErrorHandler {

	@ExceptionHandler(FunctionalException.class)
	public final ResponseEntity<ErrorMessage> handleFunctionalException(FunctionalException ex){
		
		ErrorMessage errorMsg = new ErrorMessage();
		errorMsg.setDescription(ex.getMessage());
		errorMsg.setType("FunctionalException");
		return new ResponseEntity<>(errorMsg,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StripeServiceException.class)
	public final ResponseEntity<ErrorMessage> handleFunctionalException(StripeServiceException ex){
		
		ErrorMessage errorMsg = new ErrorMessage();
		errorMsg.setDescription(ex.getMessage());
		errorMsg.setType("StripeServiceException");
		return new ResponseEntity<>(errorMsg,HttpStatus.BAD_REQUEST);
	}
	

}
