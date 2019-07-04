package pl.psomocnik.api;


import pl.psomocnik.service.UserService;

import pl.psomocnik.model.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user")
    public List<User> readUsers() {

        return userService.readUsers();
    }

    @GetMapping(path="/user/{id}")
    public User readUser(@PathVariable Long id){
        return userService.readUser(id);
    }

    @PutMapping(path="/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @PostMapping(path="/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping(path="/user/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @PostMapping(value="/register")
    public User registerUser(@RequestBody User user){
        return userService.createUser(user);
    }


}
