package com.playtomic.tests.wallet.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionListDto {

	private List<TransactionDto> transactions;
}
