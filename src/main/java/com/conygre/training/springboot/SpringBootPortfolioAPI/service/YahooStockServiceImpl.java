package com.conygre.training.springboot.SpringBootPortfolioAPI.service;

import yahoofinance.Stock;


public class YahooStockServiceImpl {
    public final Stock stock;

    public YahooStockServiceImpl(final Stock stock) {
        this.stock = stock;
    }
}
