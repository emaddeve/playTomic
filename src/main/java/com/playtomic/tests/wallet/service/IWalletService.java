package com.playtomic.tests.wallet.service;


import java.math.BigDecimal;

import com.playtomic.tests.wallet.dto.ChargeRequest;
import com.playtomic.tests.wallet.dto.TransactionDto;
import com.playtomic.tests.wallet.exception.FunctionalException;


public interface IWalletService {

	/**
	 * get avalaible balance for a specifec wallet by it's ID
	 * @param walletId
	 * @return
	 * @throws FunctionalException 
	 */
	public BigDecimal getBalanceByWalletId(Long walletId) throws FunctionalException;
	
	public TransactionDto topUpWallet(ChargeRequest body, Long walletId) throws FunctionalException;
}
