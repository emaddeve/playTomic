package com.playtomic.tests.wallet.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.playtomic.tests.wallet.WalletConfiguration;
import com.playtomic.tests.wallet.exception.FunctionalException;
import com.playtomic.tests.wallet.service.IWalletService;

@SpringBootTest(classes = {WalletConfiguration.class})
@ActiveProfiles(profiles = "test")
public class WalletServiceTest {

	@Autowired
	IWalletService service;
	
	@Test
	public void shouldReturnBalance_getBalanceByWalletIdTest() throws FunctionalException {
		
		BigDecimal bd = service.getBalanceByWalletId(1l);
		assertEquals(bd,new BigDecimal("100.00"));
	}
	
	@Test
	public void shouldThrowFunctionalException_getBalanceByWalletIdTest() throws FunctionalException {
		

		assertThrows(FunctionalException.class, () -> service.getBalanceByWalletId(2l));
	}
}
