package com.conygre.training.springboot.SpringBootPortfolioAPI.rest;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.*;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.UserRepository;
import com.conygre.training.springboot.SpringBootPortfolioAPI.service.PortfolioService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/portfolio-manager")
@CrossOrigin //Allows requests from all domains
public class PortfolioController {

    private static Logger logger = LogManager.getLogger();
    @Autowired private PortfolioService portfolioService;


    @ApiOperation(value = "findAll", nickname = "findAll")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> findAll() {
        return portfolioService.getCatalog();
    }

    @GetMapping("/users")
    public Collection<User> getUsers(){
        return portfolioService.getAllUsers();
    }

    // --------------- Regarding Specific Accounts ---------------
    //Returns accounts with specific userId
    @RequestMapping(value = "/{userId}/accounts", method=RequestMethod.GET)
    public Collection<Account> getAccountsByUserId(@PathVariable int userId){
        return portfolioService.getAccountsByUserId(userId);
    }

    //Returns accounts with specific userId
    @RequestMapping(value = "/{userId}/accounts/type={accountType}", method=RequestMethod.GET)
    public Collection<Account> getAccountsByUserIdAndType(@PathVariable int userId, @PathVariable String accountType){
        return portfolioService.getAccountsByUserIdAndType(userId, accountType);
    }


    // --------------- Regarding Specific Accounts ---------------
    //Returns information regarding a specfic account
    @RequestMapping(value = "/accounts/{accountId}", method=RequestMethod.GET)
    public Account getAccountById(@PathVariable int accountId){
        return portfolioService.getAccountById(accountId);
    }

    //Returns accounts with specific userId
    @RequestMapping(value = "/accounts/{accountId}/holdings", method=RequestMethod.GET)
    public Collection<Holdings> getHoldingsByAccountId(@PathVariable int accountId){
        return portfolioService.getHoldingsByAccountId(accountId);
    }

    @RequestMapping(value = "/accounts/{accountId}/holdings/type={stockType}", method=RequestMethod.GET)
    public Collection<Holdings> getHoldingsByAccountIdAndType(int accountId, String stockType){
        return portfolioService.getHoldingsByAccountIdAndType(accountId, stockType);
    }

//    /* USER POST METHODS */
//
//    @PostMapping("/users")
//    public void addNewUser(@RequestBody User newUser) {
//        portfolioService.addNewUser(newUser);
//    }
}
