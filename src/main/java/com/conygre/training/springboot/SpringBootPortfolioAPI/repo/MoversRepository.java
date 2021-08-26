package com.conygre.training.springboot.SpringBootPortfolioAPI.repo;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.MarketMovers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface MoversRepository extends JpaRepository<MarketMovers, Integer> {
}
