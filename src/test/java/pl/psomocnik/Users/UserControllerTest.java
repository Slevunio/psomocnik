/*package pl.psomocnik.Users;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.psomocnik.api.UserController;
import pl.psomocnik.model.User;
import pl.psomocnik.service.UserService;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
*/
/*
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

        User user1 = new User((long) 1, "User1", "user1@email.com", "password", "user");
        User user2 = new User((long) 2, "User2", "user2@email.com", "password", "user");
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
        User expected = new User((long) 1, "Adam", "adam@email.com", "password", "user");
        Mockito.when(userController.createUser(expected)).thenReturn(expected);

        User returned = userController.createUser(expected);

        Assert.assertEquals(expected.getId(), returned.getId(), "shouldReturnUserCreated test failed!");
    }

    @Test
    public void shouldReturnUser() {
        User expected = new User((long) 1, "Adam", "adam@email.com", "password", "user");
        Mockito.when(userController.readUser((long) 1)).thenReturn(expected);

        User returned = userController.readUser((long) 1);
        Assert.assertEquals(expected.getId(), returned.getId(), "shouldReturnUser test failed!");
    }

    @Test
    public void shouldReturnUserUpdated() {
        User expected = new User((long) 1, "Adam", "adam@email.com", "password", "user");
        ;
        Mockito.when(userController.updateUser((long) 1, expected)).thenReturn(expected);

        User returned = userController.updateUser((long) 1, expected);
        Assert.assertEquals(expected.getId(), returned.getId(), "shouldReturnUserUpdated test failed!");
    }

    @Test
    public void shouldReturnUserDeleted() {

        String messageExpected = "User deleted";
        Mockito.when(userController.deleteUser((long) 1)).thenReturn("User deleted");
        String messageReturned = userController.deleteUser((long) 1);
        Assert.assertEquals(messageExpected, messageReturned, "shouldReturnUserDeleted test failed!");
    }

}
*/
