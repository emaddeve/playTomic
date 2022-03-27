package com.playtomic.tests.wallet.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playtomic.tests.wallet.dto.TransactionListDto;
import com.playtomic.tests.wallet.service.ITransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	ITransactionService transactionService;
	
    @GetMapping("{walletId}")
	public ResponseEntity<TransactionListDto> getAllTransactionByWalletId(@PathVariable (value = "walletId",required = true) Long walletId){
		
    	return new ResponseEntity<>(transactionService.getAllTransactionByWalletId(walletId),HttpStatus.OK);
	}
}
