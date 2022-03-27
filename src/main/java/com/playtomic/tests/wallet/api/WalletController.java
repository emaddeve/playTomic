package com.playtomic.tests.wallet.api;


import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.playtomic.tests.wallet.dto.ChargeRequest;
import com.playtomic.tests.wallet.dto.TransactionDto;
import com.playtomic.tests.wallet.exception.FunctionalException;
import com.playtomic.tests.wallet.service.IWalletService;

@RestController
@RequestMapping("/wallet/")
public class WalletController {
    private Logger log = LoggerFactory.getLogger(WalletController.class);

   @Autowired
   IWalletService service;
    
   //maybe we need to add playerId to the control 
    @GetMapping("{walletId}")
    public ResponseEntity<BigDecimal> getWalletById(@PathVariable(value = "walletId" ,required = true) Long walletId) throws FunctionalException{
    	log.info("Calling walletService.getBalanceByWalletId for walletId {}",walletId);
    	return new ResponseEntity<>(service.getBalanceByWalletId(walletId),HttpStatus.OK);
    	
    }
    
    @PostMapping()
    public ResponseEntity<TransactionDto> TopUpWallet(@RequestBody(required = true) ChargeRequest chargeRequest,@RequestParam(required = true) Long walletId) throws FunctionalException{
    	log.info("Calling walletService.topUpWallet for walletId {} and amount {}",walletId,chargeRequest.getAmount());
     	return new ResponseEntity<>(service.topUpWallet(chargeRequest, walletId),HttpStatus.CREATED);
    	
    	
    }
}
