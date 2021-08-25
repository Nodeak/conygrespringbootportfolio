package com.conygre.training.springboot.SpringBootPortfolioAPI.repo;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Holdings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface HoldingsRepository extends JpaRepository<Holdings, Integer> {
    Collection<Holdings> findHoldingsByAccountId(int accountId);
    Collection<Holdings> findHoldingsByAccountIdAndType(int accountId, String type);
}
