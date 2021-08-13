package com.conygre.training.springboot.SpringBootPortfolioAPI.service;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Account;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Holdings;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.User;

import java.util.Collection;

public interface PortfolioService {
    Collection<User> getAllUsers();
    Collection<Account> getAllAccounts();

    Collection<Holdings> getAllHoldings();
}
