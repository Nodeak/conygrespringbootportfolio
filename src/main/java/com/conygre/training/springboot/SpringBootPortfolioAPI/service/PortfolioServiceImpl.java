package com.conygre.training.springboot.SpringBootPortfolioAPI.service;

import java.util.Collection;

public class PortfolioServiceImpl implements PortfolioService {

    @Override
    public Collection<User> getAllUsers();
    @Override
    public Collection<Account> getAllAccounts();
    @Override
    public Collection<Holdings> getAllHoldings();
}
