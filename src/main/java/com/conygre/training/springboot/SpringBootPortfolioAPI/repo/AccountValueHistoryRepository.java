package com.conygre.training.springboot.SpringBootPortfolioAPI.repo;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.AccountValueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AccountValueHistoryRepository extends JpaRepository<AccountValueHistory, Integer> {
    Collection<AccountValueHistory> findByAccountId(int accountId);
}
