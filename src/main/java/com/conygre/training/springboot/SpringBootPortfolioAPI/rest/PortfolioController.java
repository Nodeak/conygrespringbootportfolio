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

    //Returns all users
    @GetMapping("/users")
    public Collection<User> getUsers() {
        return portfolioService.getAllUsers();
    }

    //Returns all accounts
    @GetMapping("/user/accounts")
    public Collection<Account> getAccounts() {
        return portfolioService.getAllAccounts();
    }

    //Returns all holdings
    @GetMapping("/user/holdings")
    public Collection<Holdings> getHoldings() {
        return portfolioService.getAllHoldings();
    }

    /*   RETURNS ACCOUNTS  */

    //Returns accounts with specific id
    @RequestMapping(value = "/{id}/accounts", method=RequestMethod.GET)
    public Optional<Account> getAccounts(@PathVariable int id) {
        return portfolioService.getAccountsByID(id);
    }

    //Returns accounts with specific userId
    @RequestMapping(value = "/accounts/userId={userId}", method=RequestMethod.GET)
    public Collection<Account> getAccountsByUserId(@PathVariable int userId){
        return portfolioService.getAccountsByUserId(userId);
    }

    //@RequestMapping(value = "/{user_id}/accounts?type={type}", method=RequestMethod.GET)
    //public Collection<Account> getAccountsByUserID(@PathVariable int user_id, String type) {
    //    return portfolioService.findAccountByUser_idAndType(user_id, type);
    //}

    //Returns Accounts with specific userId and account type
    @RequestMapping(value = "/accounts/{userId}+type={type}", method=RequestMethod.GET)
    public Collection<Account> getAccountsByUserIdAndType(@PathVariable int userId, @PathVariable String type){
        return portfolioService.getAccountsByUserIdAndType(userId, type);
    }

    //Returns Accounts with specific userId and account name
    @RequestMapping(value = "/accounts/{userId}+name={name}", method=RequestMethod.GET)
    public Collection<Account> getAccountsByUserIdAndName(@PathVariable int userId, @PathVariable String name){
        return portfolioService.getAccountsByUserIdAndName(userId, name);
    }

    /*  RETURNS USERS */

    //Returns Users with specific firstName
    @RequestMapping(value = "/user/firstname/{firstName}", method=RequestMethod.GET)
    public Collection<User> getUsersByFirstName(@PathVariable String firstName){
        return portfolioService.getUsersByFirstName(firstName);
    }

    //Returns Users with specific names: firstName and lastName
    @RequestMapping(value = "/user/name/{firstName}+{lastName}", method=RequestMethod.GET)
    public Collection<User> getUsersByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        return portfolioService.getUsersByFirstNameAndLastName(firstName, lastName);
    }
}
