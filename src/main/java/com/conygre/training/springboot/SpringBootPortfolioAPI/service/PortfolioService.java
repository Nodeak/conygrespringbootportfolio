package com.conygre.training.springboot.SpringBootPortfolioAPI.service;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Account;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Holdings;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.User;

import java.util.Collection;
import java.util.Optional;

public interface PortfolioService {
    Collection<User> getAllUsers();
    Collection<Account> getAllAccounts();

    Collection<Holdings> getAllHoldings();
    Optional<Account> getAccountsByID(int id);
    //Collection<Account> findAccountByUser_idAndType(int user_id, String type);

    Collection<Account> getAccountsByUserId(int userId);
    Collection<Account> getAccountsByUserIdAndType(int userId, String type);
    Collection<Account> getAccountsByUserIdAndName(int userId, String name);

    Collection<User> getUsersByFirstName(String firstName);
    Collection<User> getUsersByFirstNameAndLastName(String firstName, String lastName);
}
