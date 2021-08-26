package com.conygre.training.springboot.SpringBootPortfolioAPI.service;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.*;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.*;
import com.sun.xml.bind.annotation.OverrideAnnotationOf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.Collection;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired private UserRepository userRepository;
    @Autowired private AccountRepository accountRepository;
    @Autowired private HoldingsRepository holdingsRepository;
    @Autowired private MoversRepository moversRepository;
    @Autowired private AccountValueHistoryRepository accountValueHistoryRepository;
    private static final Logger logger = LogManager.getLogger(PortfolioServiceImpl.class);


    // --------------- Market Movers ---------------

    public Collection<MarketMovers> getAllMovers() {
        return moversRepository.findAll();
    }

    public void Update_Movers() throws IOException{

        int id=1;
        MarketMovers existing_Movers;
        Stock stock;

        while(moversRepository.findById(id).isPresent())
        {
            existing_Movers = moversRepository.getById(id);                       //gets holdings entry from collection
            stock = YahooFinance.get(existing_Movers.getSymbol());                  //looks up stock info

            existing_Movers.setCurrentPrice(stock.getQuote().getPrice().floatValue());
            existing_Movers.setPercentChange(stock.getQuote().getChangeInPercent().floatValue());

            moversRepository.save(existing_Movers);                               //saves updated entry
            id+=1;
        }


    }
    // -------------------- END --------------------

    @Override
    public Iterable<User> getCatalog() {
        return userRepository.findAll();
    }


    @Override
    public Collection<User> getAllUsers(){ return userRepository.findAll(); }


    // --------------- Regarding Specific Users ---------------
    @Override
    public Collection<Account> getAccountsByUserId(int userId){
        return accountRepository.findAccountsByUserId(userId);
    }

    @Override
    public Account getAccountByUserIdAndAccountId(int userId, int accountId){
        return accountRepository.findAccountByUserIdAndId(userId, accountId);
    }

    @Override
    public Collection<Account> getAccountsByUserIdAndType(int userId, String type){
        return accountRepository.findAccountByUserIdAndType(userId, type);
    }

    // --------------- Regarding Specific Accounts ---------------
    @Override
    public Account getAccountById(int accountId){
        return accountRepository.findAccountById(accountId);
    }

    @Override
    public Collection<Holdings> getHoldingsByAccountId(int accountId){
        return holdingsRepository.findHoldingsByAccountId(accountId);
    }

    @Override
    public Collection<Holdings> getHoldingsByAccountIdAndType(int accountId, String stockType){
        return holdingsRepository.findHoldingsByAccountIdAndType(accountId, stockType);
    }

    @Override
    public Collection<AccountValueHistory> getAccountHistory(int accountId){
        return accountValueHistoryRepository.findByAccountId(accountId);
    }


    // ------------ Updating Data ------------

    //updates current price and percent change over the last 24 hours
    @Override
    public void updateStockPrices() throws IOException {
        Holdings existing_Holding;
        Stock stock;

        for(Holdings holding : holdingsRepository.findAll())
        {
            existing_Holding = holding;                                                 //gets holdings entry from collection
            stock = YahooFinance.get(existing_Holding.getSymbol());                     //looks up stock info

            existing_Holding.setCurPrice(stock.getQuote().getPrice().floatValue());
            existing_Holding.setPercentChange(stock.getQuote().getChangeInPercent().floatValue());

            holdingsRepository.save(existing_Holding);                                  //saves updated entry
        }
    }
}
