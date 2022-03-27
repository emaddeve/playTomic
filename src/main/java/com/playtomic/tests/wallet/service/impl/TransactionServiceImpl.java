package com.playtomic.tests.wallet.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playtomic.tests.wallet.dto.TransactionDto;
import com.playtomic.tests.wallet.dto.TransactionListDto;
import com.playtomic.tests.wallet.entities.Transaction;
import com.playtomic.tests.wallet.entities.Wallet;
import com.playtomic.tests.wallet.enums.TransactionType;
import com.playtomic.tests.wallet.repositories.TransactionRepo;
import com.playtomic.tests.wallet.repositories.WalletRepo;
import com.playtomic.tests.wallet.service.ITransactionService;
import com.playtomic.tests.wallet.transformers.TransactionTransformer;

@Service
public class TransactionServiceImpl implements ITransactionService {

	
	@Autowired
	TransactionRepo transactionRepo;
	
	@Autowired
	WalletRepo walletRepo;
	
	@Override
	public TransactionDto executTransaction(BigDecimal amount, TransactionType type, Wallet wallet) {

		 
		Transaction trx = new Transaction();
		trx.setTransactionAmount(amount);
		trx.setTransactionDate(LocalDate.now());
		trx.setType(type);
		trx.setWallet(wallet);
		return TransactionTransformer.transformToDto(transactionRepo.save(trx));
	}

	@Override
	public TransactionListDto getAllTransactionByWalletId(Long walletId) {
		List<Transaction> transactionList = transactionRepo.findByWalletId(walletId);
		List<TransactionDto> transactionDto = transactionList.stream().map(e -> TransactionTransformer.transformToDto(e)).collect(Collectors.toList());
		TransactionListDto transactions = new TransactionListDto();
		transactions.setTransactions(transactionDto);

		
		return transactions;
	}

}
