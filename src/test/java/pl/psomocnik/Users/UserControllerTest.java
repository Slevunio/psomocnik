package pl.psomocnik.Users;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.psomocnik.controller.UserController;
import pl.psomocnik.model.Role;
import pl.psomocnik.model.User;
import pl.psomocnik.service.UserService;




public class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeMethod
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnUsers() {

        System.out.println("Running 'shouldReturnUsers' test...");
        Role role = new Role((long)1, "user");
        User user1 = new User((long) 1, "User1", "user1@email.com", "password", role);
        User user2 = new User((long) 2, "User2", "user2@email.com", "password", role);
        List<User> expected = new ArrayList<>();
        expected.add(user1);
        expected.add(user2);

        Mockito.when(userController.readUsers()).thenReturn(expected);

        List<User> returned;
        returned = userController.readUsers();
        Assert.assertEquals(expected, returned, "shouldReturnUsers test failed!");
    }

    @Test
    public void shouldReturnUserCreated() {
        System.out.println("Running 'shouldReturnUserCreated' test...");
        Role role = new Role((long)1, "user");
        User expected = new User((long) 1, "User1", "user1@email.com", "password", role);
        Mockito.when(userController.createUser(expected)).thenReturn(expected);

        User returned = userController.createUser(expected);

        Assert.assertEquals(expected.getId(), returned.getId(), "shouldReturnUserCreated test failed!");
    }


    @Test
    public void shouldReturnUser() {
        System.out.println("Running 'shouldReturnUser' test...");
        Role role = new Role((long)1, "user");
        User expected = new User((long) 1, "User1", "user1@email.com", "password", role);
        Mockito.when(userController.readUser((long) 1)).thenReturn(expected);

        User returned = userController.readUser((long) 1);
        Assert.assertEquals(expected.getId(), returned.getId(), "shouldReturnUser test failed!");
    }

    @Test
    public void shouldReturnUserUpdated() {
        System.out.println("Running 'shouldReturnUserUpdated' test...");
        Role role = new Role((long)1, "user");
        User expected = new User((long) 1, "User1", "user1@email.com", "password", role);
        Mockito.when(userController.updateUser(expected)).thenReturn(expected);

        User returned = userController.updateUser(expected);
        Assert.assertEquals(expected.getId(), returned.getId(), "shouldReturnUserUpdated test failed!");
    }

    @Test
    public void shouldReturnUsersDeleted() {

        System.out.println("Running 'shouldReturnUsersDeleted' test...");
        String ids = "[1,2,3]";
        String messageExpected = "Users deleted";
        Mockito.when(userController.deleteUsers(ids)).thenReturn(messageExpected);
        String messageReturned = userController.deleteUsers(ids);
        Assert.assertEquals(messageExpected, messageReturned, "shouldReturnUserDeleted test failed!");
    }

}


