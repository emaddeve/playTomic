package com.playtomic.tests.wallet.service;

import java.math.BigDecimal;

import com.playtomic.tests.wallet.dto.TransactionDto;
import com.playtomic.tests.wallet.dto.TransactionListDto;
import com.playtomic.tests.wallet.entities.Wallet;
import com.playtomic.tests.wallet.enums.TransactionType;

public interface ITransactionService {


	TransactionDto executTransaction(BigDecimal amount, TransactionType type, Wallet wallet);

	TransactionListDto getAllTransactionByWalletId(Long walletId);
}
