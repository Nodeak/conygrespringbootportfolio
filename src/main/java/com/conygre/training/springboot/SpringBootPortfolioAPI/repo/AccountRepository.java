package com.conygre.training.springboot.SpringBootPortfolioAPI.repo;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Account;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.Holdings;
import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    //Collection<Account> findAccountsByUser_idAndType(int user_id, String type);
    Collection<Account> findAccountsByUserId(int userId);

    Account findAccountById(int accountId);
    Account findAccountByUserIdAndId(int userId, int accountId);
    Collection<Account> findAccountByUserIdAndType(int userId, String type);

}
