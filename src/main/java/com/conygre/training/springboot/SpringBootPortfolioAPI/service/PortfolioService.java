package com.conygre.training.springboot.SpringBootPortfolioAPI.service;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.*;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.AccountValueHistoryRepository;

import java.io.IOException;
import java.util.Collection;

public interface PortfolioService {
    Iterable<User> getCatalog();
    Collection<User> getAllUsers();

    // --------------- Regarding Specific Users ---------------
    Account getAccountByUserIdAndAccountId(int userId, int accountId);
    Collection<Account> getAccountsByUserId(int userId);
    Collection<Account> getAccountsByUserIdAndType(int userId, String type);

    // --------------- Regarding Specific Accounts ---------------
    Account getAccountById(int accountId);
    Collection<Holdings> getHoldingsByAccountId(int accountId);
    Collection<Holdings> getHoldingsByAccountIdAndType(int accountId, String type);
    Collection<MarketMovers> getAllMovers();
    Collection<AccountValueHistory> getAccountHistory(int accountId);

    // --------------- Updating Data ----------------
    void updateStockPrices() throws IOException;

//    /* POST */
//    User addNewUser(User user);
//    Account addNewAccount(Account account);
//    Holdings addNewHoldings(Holdings holdings);

    void Update_Movers() throws IOException;
    //float get_PercentChange(String symbol) throws IOException;
}
