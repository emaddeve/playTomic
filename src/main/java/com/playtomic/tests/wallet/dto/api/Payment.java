package com.playtomic.tests.wallet.dto.api;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Payment {

    @NonNull
    private String id;
    
    private BigDecimal amount;

    @JsonCreator
    public Payment(@JsonProperty(value = "id", required = true) String id,@JsonProperty(value = "amount", required = true) BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }
}
