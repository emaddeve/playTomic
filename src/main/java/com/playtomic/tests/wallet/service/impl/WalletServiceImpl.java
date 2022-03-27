package com.playtomic.tests.wallet.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playtomic.tests.wallet.dto.ChargeRequest;
import com.playtomic.tests.wallet.dto.TransactionDto;
import com.playtomic.tests.wallet.dto.api.Payment;
import com.playtomic.tests.wallet.entities.Wallet;
import com.playtomic.tests.wallet.enums.TransactionType;
import com.playtomic.tests.wallet.exception.FunctionalException;
import com.playtomic.tests.wallet.repositories.WalletRepo;
import com.playtomic.tests.wallet.service.IStripeService;
import com.playtomic.tests.wallet.service.ITransactionService;
import com.playtomic.tests.wallet.service.IWalletService;

@Service
public class WalletServiceImpl implements IWalletService {

	@Autowired
	WalletRepo walletRepo;
	
	@Autowired
	IStripeService stripService;
	
	@Autowired
	ITransactionService transactionService;
	
	@Override
	public BigDecimal getBalanceByWalletId(Long walletId) throws FunctionalException {

		return getWalletByWalletId(walletId).getBalance();
	}
	
	@Override
	public TransactionDto topUpWallet(ChargeRequest body, Long walletId) throws FunctionalException {
		
		Wallet wallet = getWalletByWalletId(walletId);
		Payment payment = stripService.charge(body); 
		wallet.setBalance(wallet.getBalance().add(payment.getAmount()));
		walletRepo.save(wallet);
		return transactionService.executTransaction(payment.getAmount(), TransactionType.DEPOSIT, wallet);
		
	}
	
	protected TransactionDto executTransaction(float amount,TransactionType type,Long walletId) {
		return null;
		
		
	}
	
	protected Wallet getWalletByWalletId(Long walletId) throws FunctionalException {
		Optional<Wallet> wallet = walletRepo.findById(walletId);
		if(!wallet.isPresent()) {
			throw new FunctionalException("wallet doesn't exist for walletId : "+ walletId);
		}
		return wallet.get();
	}

}
