package com.playtomic.tests.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.playtomic.tests.wallet.entities.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long>{

}
