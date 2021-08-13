package com.conygre.training.springboot.SpringBootPortfolioAPI.service;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

import java.io.IOException;



@Service
public class YahooStockService {
    public YahooStockServiceImpl getStock(final String symbol) throws IOException {
        return new YahooStockServiceImpl(YahooFinance.get(symbol));
    }
}
