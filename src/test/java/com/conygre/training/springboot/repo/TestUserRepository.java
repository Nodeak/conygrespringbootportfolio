package com.conygre.training.springboot.repo;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.User;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.UserRepository;
import com.conygre.training.springboot.SpringBootPortfolioAPI.rest.PortfolioController;
import com.conygre.training.springboot.SpringBootPortfolioAPI.service.PortfolioService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest    // use in memory database
@SpringBootTest(classes={com.conygre.training.springboot.SpringBootPortfolioAPI.SpringBootPortfolioApiApplication.class})
@TestPropertySource(locations = "classpath:application-test.properties")    // needed bc Swagger breaks tests
public class TestUserRepository {

    @Autowired
    private TestEntityManager manager;

    @Autowired          // Mock Repo injected by @DataJpaTest
    private UserRepository repo;

    @Autowired
    PortfolioService portfolioService;

    @Autowired
    PortfolioController controller;

    private int userId;

    @Before
    public void setupDatabaseEntryForReadOnlyTest(){
        User user = new User("Kevin", "Grywczynski", (float) 420.42);
        User result = manager.persist(user);
        userId = result.getId();
    }

    @Test
    public void canRetrieveUserByFirstName() {
        Iterable<User> discs = repo.findUsersByFirstName("Kevin");
        Stream<User> stream = StreamSupport.stream(discs.spliterator(), false);
        assertThat(stream.count(), equalTo(1L));
    }
}
