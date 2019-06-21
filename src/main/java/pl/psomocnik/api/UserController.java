package pl.psomocnik.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.psomocnik.model.User;
import pl.psomocnik.service.UserService;


import java.util.List;

@RestController
public class UserController{
    @Autowired
   private UserService userService;

    @GetMapping(value="/users")
    public List<User> readUsers(){
        return userService.readUsers();
    }

    @GetMapping(value={"/users/{id}","/welcome/{id}"})
    public User readUser(@PathVariable Long id){
        return userService.readUser(id);
    }

    @PutMapping(value="/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @PostMapping(value="/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping(value="/register")
    public User registerUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping(value="/users/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
