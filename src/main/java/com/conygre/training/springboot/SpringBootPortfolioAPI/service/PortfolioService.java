package com.conygre.training.springboot.SpringBootPortfolioAPI.service;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Account;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Holdings;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.User;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.HoldingsRepository;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public interface PortfolioService {
    Iterable<User> getCatalog();
    Collection<User> getAllUsers();
    Collection<Account> getAllAccounts();
    Collection<Holdings> getAllHoldings();

    //Collection<Account> findAccountByUser_idAndType(int user_id, String type);

    Collection<Holdings> getHoldingsByAccountId(int accountId);
    Collection<Holdings> getHoldingsByAccountIdAndType(int accountId, String type);

    Collection<Account> getAccountsByUserId(int userId);
    Collection<Account> getAccountsByUserIdAndType(int userId, String type);
    Collection<Account> getAccountsByUserIdAndName(int userId, String name);
    Account getAccountsByID(int id);

    Collection<User> getUsersByFirstName(String firstName);
    Collection<User> getUsersByFirstNameAndLastName(String firstName, String lastName);

    /* POST */
    User addNewUser(User user);
    Account addNewAccount(Account account);
    Holdings addNewHoldings(Holdings holdings);

    void Update_Price() throws IOException;
    //float get_PercentChange(String symbol) throws IOException;
    Map<String,Float> Market_Indexes() throws IOException;
}
