package com.conygre.training.springboot.SpringBootPortfolioAPI.repo;

import com.conygre.training.springboot.SpringBootPortfolioAPI.rest.YahooStockServiceImpl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

public interface StockRepository {
    public BigDecimal getStockPrice(final String symbol);
    public Collection<BigDecimal> getMonthlyHistory(final String Symbol, Date date);
}
