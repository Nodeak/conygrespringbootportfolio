package com.conygre.training.springboot.controller;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.User;
import com.conygre.training.springboot.SpringBootPortfolioAPI.repo.UserRepository;
import com.conygre.training.springboot.SpringBootPortfolioAPI.rest.PortfolioController;
import com.conygre.training.springboot.SpringBootPortfolioAPI.service.PortfolioService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=TestUserControllerUnitTest.class)
public class TestUserControllerUnitTest {

    // A configuration class used for tests
    // Only one instance of it
    @TestConfiguration
    protected static class Config {


        // Mock User Repository Layer
        public UserRepository repo(){
            return mock(UserRepository.class);
        }

        // Mock Service Layer that returns a single User when requested for all
        public PortfolioService service() {
            User user = new User();
            user.setFirst_name("Kaedon");
            user.setLast_name("Hamm");
            List<User> userList = new ArrayList<>();
            userList.add(user);

            PortfolioService service = mock(PortfolioService.class);
            when(service.getAllUsers()).thenReturn(userList);
            return service;
        }

        @Autowired
        private PortfolioController controller;

        @Test
        public void testFindAll(){
            Iterable<User> userList = controller.findAll();
            Stream<User> stream = StreamSupport.stream(userList.spliterator(), false);
            assertThat(stream.count(), equalTo(1L));
        }

    }
}
