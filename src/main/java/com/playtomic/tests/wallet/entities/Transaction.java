package com.playtomic.tests.wallet.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.playtomic.tests.wallet.enums.TransactionType;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TRANSACTION")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	private Long transactionId;
	
	@Column(name = "TRANSACTION_AMOUNT")
	private BigDecimal transactionAmount;
	
	@Column(name = "TRANSACTION_DATE")
	private LocalDate transactionDate;
	
	@Enumerated(EnumType.ORDINAL)
	private TransactionType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WALLET_ID")
	private Wallet wallet;
	
	
}
