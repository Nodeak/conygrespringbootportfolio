package com.conygre.training.springboot.SpringBootPortfolioAPI.service;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;


@Service
public class YahooStockService {
    public YahooStockServiceImpl getStock(final String symbol) throws IOException {
        return new YahooStockServiceImpl(YahooFinance.get(symbol));
    }

    public BigDecimal getPrice(final YahooStockServiceImpl stock) throws IOException{
        return stock.get_Stock().getQuote().getPrice();
    }
}
