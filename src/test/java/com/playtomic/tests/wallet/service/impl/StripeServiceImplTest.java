package com.playtomic.tests.wallet.service.impl;


import com.playtomic.tests.wallet.WalletConfiguration;
import com.playtomic.tests.wallet.dto.ChargeRequest;
import com.playtomic.tests.wallet.dto.api.Payment;
import com.playtomic.tests.wallet.exception.StripeAmountTooSmallException;
import com.playtomic.tests.wallet.exception.StripeServiceException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;

/**
 * This test is failing with the current implementation.
 *
 * How would you test this?
 */
@SpringBootTest(classes = {WalletConfiguration.class})
@ActiveProfiles(profiles = "test")
public class StripeServiceImplTest {


	@Autowired
	RestTemplate resteTemplate;
	
	@Autowired
	private StripeServiceImpl s;
	
	
   // URI testUri = URI.create("http://how-would-you-test-me.localhost");
  //  StripeServiceImpl s = new StripeServiceImpl(testUri, testUri, new RestTemplateBuilder());
    
    


    @Test
    public void test_exception() {
    	
    	//GIVEN
    	ChargeRequest chargeRequest = new ChargeRequest("4242 4242 4242 4242", new BigDecimal(5));
    	Payment payment = new Payment("1", new BigDecimal(100));
    	
    	//When
    	Mockito.doThrow(StripeAmountTooSmallException.class).when(resteTemplate).postForObject(Mockito.any(),Mockito.any(), Mockito.any());
    	
    	//Then
        Assertions.assertThrows(StripeAmountTooSmallException.class, () -> {
            s.charge(chargeRequest);
        });
    }

    @Test
    public void test_ok() throws StripeServiceException {
    	//GIVEN
    	ChargeRequest chargeRequest = new ChargeRequest("4242 4242 4242 4242", new BigDecimal(5));
    	Payment payment = new Payment("1", new BigDecimal(100));
    	
    	//When
    	Mockito.doReturn(payment).when(resteTemplate).postForObject(Mockito.any(),Mockito.any(), Mockito.any());
      	
    	//Then
        s.charge(chargeRequest);
    }
}
