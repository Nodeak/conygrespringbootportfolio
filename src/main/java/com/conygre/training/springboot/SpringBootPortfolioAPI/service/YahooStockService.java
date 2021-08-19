package com.conygre.training.springboot.SpringBootPortfolioAPI.service;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Holdings;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.YahooStockDAO;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import com.conygre.training.springboot.SpringBootPortfolioAPI.service.PortfolioServiceImpl;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class YahooStockService implements YahooStockDAO {
    private String name="";

    //class constructor which requires a default stock symbol
    YahooStockService(String S) throws IOException {
        Stock temp_Stock= YahooFinance.get(S);
        if(temp_Stock.isValid()){
            this.name=S;
        }
    }

    //gets current stock
    public String get_StockName(){
        return this.name;
    }

    //sets stock name
    public void set_StockSymbol(String symbol) throws IOException{
        Stock temp_Stock= YahooFinance.get(symbol);
        if(temp_Stock.isValid()){
            this.name=symbol;
        }
    }

    //gets stock price for current stock name
    public BigDecimal getPrice() throws IOException{
        Stock stock=YahooFinance.get(this.name);
        return stock.getQuote().getPrice();
    }

    //returns percent change from last 24hours
    public BigDecimal get_PercentChange(String symbol) throws IOException{
        Stock stock=YahooFinance.get(symbol);
        return stock.getQuote().getChangeInPercent();
    }

    //returns map of market indexes and their prices (eg. Nasdaq:14500, Dow:34920)
    public Map<String,BigDecimal> Market_Indexes() throws IOException{
        Map<String,BigDecimal> Market_Movers= new HashMap<>();
        Stock Marketindex=YahooFinance.get("COMP");
        Market_Movers.put("COMP",Marketindex.getQuote().getPrice());
        Marketindex=YahooFinance.get("DJIA");
        Market_Movers.put("DJIA",Marketindex.getQuote().getPrice());
        //TODO add other indexes such as S&P500
        return Market_Movers;
    }

    //Returns accounts current holdings and maps them to their current price
    public Map<String,BigDecimal> getAllHoldingPrices(Collection<Holdings> Current_Holdings) throws IOException{
        Map<String,BigDecimal> Prices= new HashMap<>();
        Stock stock;
        for(Holdings h : Current_Holdings){
            stock=YahooFinance.get(h.getSymbol());
            Prices.put(h.getSymbol(),stock.getQuote().getPrice());
        }
        return Prices;
    }
}
