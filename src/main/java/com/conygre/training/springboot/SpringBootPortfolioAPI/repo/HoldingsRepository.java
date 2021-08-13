package com.conygre.training.springboot.SpringBootPortfolioAPI.repo;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Holdings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoldingsRepository extends JpaRepository<Holdings, Integer> {
}
