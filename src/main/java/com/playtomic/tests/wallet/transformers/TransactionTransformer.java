package com.playtomic.tests.wallet.transformers;

import java.util.Objects;

import com.playtomic.tests.wallet.dto.TransactionDto;
import com.playtomic.tests.wallet.entities.Transaction;

public class TransactionTransformer {

	private TransactionTransformer() {
		throw new IllegalStateException("Utility class");
	}
	
	public static TransactionDto transformToDto(Transaction entity) {
		TransactionDto dto = null;
		if(Objects.isNull(entity))
			return dto;
		 dto = new TransactionDto();
		dto.setTransactionAmount(entity.getTransactionAmount());
		dto.setTransactionDate(entity.getTransactionDate());
		dto.setTransactionId(entity.getTransactionId());
		dto.setType(entity.getType());
		return dto;
	}

}
