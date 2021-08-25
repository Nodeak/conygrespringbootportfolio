package com.conygre.training.springboot.SpringBootPortfolioAPI.service;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Account;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Holdings;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.User;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.AccountRepository;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.HoldingsRepository;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private HoldingsRepository holdingsRepository;

    private static final Logger logger = LogManager.getLogger(PortfolioServiceImpl.class);

    @Override
    public Iterable<User> getCatalog() {
        return userRepository.findAll();
    }

    @Override
    public Collection<User> getAllUsers() {
        logger.info("getting all users");
        return userRepository.findAll();
    }
    @Override
    public Collection<Account> getAllAccounts() {
        logger.info("getting all accounts");
        return accountRepository.findAll();
    }
    @Override
    public Collection<Holdings> getAllHoldings(){
        logger.info("getting all holdings");
        return holdingsRepository.findAll();
    }

    @Override
    public Collection<Holdings> getHoldingsByAccountId(int accountId){
        return holdingsRepository.getHoldingsByAccountId(accountId);
    }

    @Override
    public Collection<Holdings> getHoldingsByAccountIdAndType(int accountId, String type){
        return holdingsRepository.getHoldingsByAccountIdAndType(accountId, type);
    }

    @Override
    public Account getAccountsByID(int id){
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            return accountOptional.get();
        }
        else return null;
//        return accountRepository.findById(id);
    }

    @Override
    public Collection<Account> getAccountsByUserId(int userId){
        return accountRepository.findAccountsByUserId(userId);
    }

    @Override
    public Collection<Account> getAccountsByUserIdAndType(int userId, String type){
        return accountRepository.findAccountByUserIdAndType(userId, type);
    }

    @Override
    public Collection<Account> getAccountsByUserIdAndName(int userId, String name){
        return accountRepository.findAccountsByUserIdAndAndName(userId, name);
    }

    @Override
    public Collection<User> getUsersByFirstName(String firstName){
        return userRepository.findUsersByFirstName(firstName);
    }

    @Override
    public Collection<User> getUsersByFirstNameAndLastName(String firstName, String lastName){
        return userRepository.findUsersByFirstNameAndAndLastName(firstName, lastName);
    }

//    @Override
//    Iterable<Account> findAccountsByUserId(){
//        return accountRepository.findAccountByUser_id(int user_id)
//    }

    @Override
    public User addNewUser(User user){
        user.setId(0);
        return userRepository.save(user);
    }

    @Override
    public Account addNewAccount(Account account){
        account.setId(0);
        return accountRepository.save(account);
    }

    @Override
    public Holdings addNewHoldings(Holdings holdings) {
        return null;
    }


    //updates current price and percent change over the last 24 hours
    @Override
    public void Update_Price() throws IOException {
        int id=1;
        Holdings existing_Holding;
        Stock stock;

        while(holdingsRepository.findById(id).isPresent())
        {
            existing_Holding=holdingsRepository.getById(id); //gets holdings entry from collection
            stock=YahooFinance.get(existing_Holding.getSymbol()); //looks up stock info

            existing_Holding.setCurPrice(stock.getQuote().getPrice().floatValue());
            existing_Holding.setPercentChange(stock.getQuote().getChangeInPercent().floatValue());
            holdingsRepository.save(existing_Holding); //saves updated entry

            id+=1;
        }
    }






//    @Override
//    public Holdings addNewHoldings(Holdings holdings){
//        holdings.setId(0);
//        return HoldingsRepository.save(holdings);
//    }
}
