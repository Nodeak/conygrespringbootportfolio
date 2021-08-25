package functional.tests;

import com.conygre.training.springboot.SpringBootPortfolioAPI.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class UserRestTests {

    private RestTemplate template = new RestTemplate();

    @Test
    public void testFindAll(){
        List<User> userList = template.getForObject("http://localhost:8080/portfolio-manager/users", List.class);
        Assert.assertTrue(userList.size() > 1);
    }
}
