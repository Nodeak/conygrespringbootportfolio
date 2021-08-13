package com.conygre.training.springboot.SpringBootPortfolioAPI.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio-manager")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/users")
    public Collection<portfolioService> getUsers() {
        return portfolioService.getAllUsers();
    }

    @GetMapping("/user/accounts")
    public Collection<portfolioService> getAccounts() {
        return portfolioService.getAllAccounts();
    }

    @GetMapping("/user/holdings")
    public Collection<portfolioService> getHoldings() {
        return portfolioService.getAllHoldings();
    }

}
