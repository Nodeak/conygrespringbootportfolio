package com.conygre.training.springboot.SpringBootPortfolioAPI.service;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Account;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Holdings;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.User;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.AccountRepository;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.HoldingsRepository;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public Optional<Account> getAccountsByID(int id){
        return accountRepository.findById(id);
    }
}
