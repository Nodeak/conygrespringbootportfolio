package com.conygre.training.springboot.SpringBootPortfolioAPI.rest;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.*;
import com.conygre.training.springboot.SpringBootPortfolioAPI.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/portfolio-manager")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/users")
    public Collection<User> getUsers() {
        return portfolioService.getAllUsers();
    }

//    @GetMapping("/user/accounts")
//    public Collection<portfolioService> getAccounts() {
//        return portfolioService.getAllAccounts();
//    }
//
//    @GetMapping("/user/holdings")
//    public Collection<portfolioService> getHoldings() {
//        return portfolioService.getAllHoldings();
//    }

}
