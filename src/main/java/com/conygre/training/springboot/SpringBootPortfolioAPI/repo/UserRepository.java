package com.conygre.training.springboot.SpringBootPortfolioAPI.repo;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
