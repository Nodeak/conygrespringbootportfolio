package com.conygre.training.springboot.SpringBootPortfolioAPI.rest;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.StockRepository;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;


@Service
public class StockService implements StockRepository {
    public YahooStockServiceImpl getStock(final String symbol) throws IOException {
        return new YahooStockServiceImpl(YahooFinance.get(symbol));
    }

    public BigDecimal getPrice(final YahooStockServiceImpl stock) throws IOException{
        return stock.get_Stock().getQuote().getPrice();
    }

    //TODO
    public BigDecimal getTopMovers(final YahooStockServiceImpl stock) throws IOException{
        return stock.get_Stock().getQuote().getChangeInPercent();
    }

    //TODO
    public BigDecimal getHitory(final YahooStockServiceImpl stock) throws IOException, ParseException {
    //Look up how to change Date to type Calendar

        //        String dt = "2021-08-13";
//        Date today = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar c = Calendar.getInstance();
//        c.setTime(sdf.parse(dt));
//        c.add(Calendar.DATE, 1);  // number of days to add
//        dt = sdf.format(c.getTime());

        //return stock.get_Stock().getHistory();
    }
}
