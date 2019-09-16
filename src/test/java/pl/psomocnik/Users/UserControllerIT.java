/*package pl.psomocnik.Users;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.psomocnik.controller.UserController;
import pl.psomocnik.model.User;

import java.util.Arrays;*/
/*
* test integracyjny do spring-boot
* */
/*
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerIT extends AbstractTestNGSpringContextTests {
/*
* Zapytaj o przechowywanie zdjec w bd!
*
* */

 /*   @Autowired
    UserController userController;

    User user;

    @BeforeTest
    void createUser(){
        user=new User((long)2,"Adam", "adam@email.com","password", "user");
    }

    @Test
    void shouldCreateUser(){
        Assert.assertEquals(user.getId(), userController.createUser(user).getId(), "User creation failed!");
    }

    @Test
    void shouldDeleteUser(){
        userController.createUser(user);
        String message=userController.deleteUser(user.getId());
        Assert.assertEquals(message,"User deleted!", "Deleting user failed!");
    }
}
*/
