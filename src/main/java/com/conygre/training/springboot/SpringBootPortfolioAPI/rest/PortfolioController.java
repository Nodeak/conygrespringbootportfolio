package com.conygre.training.springboot.SpringBootPortfolioAPI.rest;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.*;
import com.conygre.training.springboot.SpringBootPortfolioAPI.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/portfolio-manager")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/users")
    public Collection<User> getUsers() {
        return portfolioService.getAllUsers();
    }

    @GetMapping("/user/accounts")
    public Collection<Account> getAccounts() {
        return portfolioService.getAllAccounts();
    }

    @GetMapping("/user/holdings")
    public Collection<Holdings> getHoldings() {
        return portfolioService.getAllHoldings();
    }

    @RequestMapping(value = "/{id}/accounts", method=RequestMethod.GET)
    public Optional<Account> getAccounts(@PathVariable int id) {
        return portfolioService.getAccountsByID(id);
    }

    //@RequestMapping(value = "/{user_id}/accounts?type={type}", method=RequestMethod.GET)
    //public Collection<Account> getAccountsByUserID(@PathVariable int user_id, String type) {
    //    return portfolioService.findAccountByUser_idAndType(user_id, type);
    //}
}
