package com.conygre.training.springboot.SpringBootPortfolioAPI.service;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Account;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Holdings;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.User;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.AccountRepository;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.HoldingsRepository;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private HoldingsRepository holdingsRepository;

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public Collection<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    @Override
    public Collection<Holdings> getAllHoldings(){
        return holdingsRepository.findAll();
    }
}
