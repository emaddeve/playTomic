package com.playtomic.tests.wallet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.playtomic.tests.wallet.entities.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long>{

	@Query("SELECT trx from Transaction  trx where trx.wallet.walletId = :walletId")
	List<Transaction> findByWalletId(Long walletId);

}
