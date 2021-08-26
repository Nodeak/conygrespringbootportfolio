package com.conygre.training.springboot.SpringBootPortfolioAPI.rest;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.*;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.UserRepository;
import com.conygre.training.springboot.SpringBootPortfolioAPI.service.PortfolioService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.SysexMessage;
import java.io.IOException;
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

    @GetMapping("/marketmovers")
    public Collection<MarketMovers> getMovers(){
        return portfolioService.get_AllMovers();
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
    public Collection<Holdings> getHoldingsByAccountId(@PathVariable int accountId) throws IOException {
        portfolioService.updateStockPrices();
        return portfolioService.getHoldingsByAccountId(accountId);
    }

    @RequestMapping(value = "/accounts/{accountId}/holdings/type={stockType}", method=RequestMethod.GET)
    public Collection<Holdings> getHoldingsByAccountIdAndType(int accountId, String stockType) throws IOException {
        portfolioService.updateStockPrices();
        return portfolioService.getHoldingsByAccountIdAndType(accountId, stockType);
    }

    @RequestMapping(value = "/current-prices", method=RequestMethod.GET)
    public void updateStockPrices() throws IOException {
        portfolioService.updateStockPrices();
    }

//    /* USER POST METHODS */
//
//    @PostMapping("/users")
//    public void addNewUser(@RequestBody User newUser) {
//        portfolioService.addNewUser(newUser);
//    }
}
