//package com.conygre.training.springboot.SpringBootPortfolioAPI.repo;
//import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Holdings;
//import org.springframework.stereotype.Service;
//import yahoofinance.Stock;
//import yahoofinance.YahooFinance;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.Collection;
//import java.util.Map;
//import java.util.UUID;
//
//import yahoofinance.Stock;
//
//public interface YahooStockDAO {
//
//    public void Update_Price(int id,HoldingsRepository holdings_Repository) throws IOException;
//
//    public String get_StockName();
//
//    public void set_StockSymbol(String symbol) throws IOException;
//
//    public float getPrice() throws IOException;
//
//    public float get_PercentChange(String symbol) throws IOException;
//
//    public Map<String,Float> Market_Indexes() throws IOException;
//
//    public Map<String,Float> getAllHoldingPrices(Collection<Holdings> Current_Holdings) throws IOException;
//
//    //public Double get_InvestmentValue();
//}