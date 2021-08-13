package com.conygre.training.springboot.SpringBootPortfolioAPI.rest;

import yahoofinance.Stock;


public class YahooStockServiceImpl {
    public final Stock stock;

    public YahooStockServiceImpl(final Stock stock) {
        this.stock = stock;
    }
    public Stock get_Stock(){return this.stock;}

}
