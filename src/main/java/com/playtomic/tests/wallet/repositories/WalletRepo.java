package com.playtomic.tests.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.playtomic.tests.wallet.entities.Wallet;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Long>{

}
