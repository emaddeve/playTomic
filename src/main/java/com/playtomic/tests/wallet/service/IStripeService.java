package com.playtomic.tests.wallet.service;

import java.math.BigDecimal;

import com.playtomic.tests.wallet.dto.ChargeRequest;
import com.playtomic.tests.wallet.dto.api.Payment;
import com.playtomic.tests.wallet.exception.StripeServiceException;

import lombok.NonNull;

public interface IStripeService {

	
    /**
     * Charges money in the credit card.
     *
     * Ignore the fact that no CVC or expiration date are provided.
     *
     * @param creditCardNumber The number of the credit card
     * @param amount The amount that will be charged.
     *
     * @throws StripeServiceException
     */
    public Payment charge(@NonNull ChargeRequest body) throws StripeServiceException ;

    /**
     * Refunds the specified payment.
     */
    public void refund(@NonNull String paymentId) throws StripeServiceException;
    
}
