package com.playtomic.tests.wallet.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


import com.playtomic.tests.wallet.entities.Wallet;
import com.playtomic.tests.wallet.enums.TransactionType;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {

	private Long transactionId;
	
	private BigDecimal transactionAmount;

	private LocalDate transactionDate;
	
	private TransactionType type;
	
	private Wallet wallet;
}
