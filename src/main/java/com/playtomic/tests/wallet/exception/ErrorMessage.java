package com.playtomic.tests.wallet.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {

	private String type;
	
	private String description;
	
	
}
