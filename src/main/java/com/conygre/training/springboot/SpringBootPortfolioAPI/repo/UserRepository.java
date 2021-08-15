package com.conygre.training.springboot.SpringBootPortfolioAPI.repo;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, Integer> {
//    Collection<User> findByFirstName(String first_name);

    Collection<User> findUsersByFirstName(String firstName);
    Collection<User> findUsersByFirstNameAndAndLastName(String firstName, String lastName);

}
