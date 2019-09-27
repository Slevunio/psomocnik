package pl.psomocnik.controller;

import pl.psomocnik.model.Role;
import pl.psomocnik.service.UserService;
import pl.psomocnik.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping(path = "/user/{id}")
    public User readUser(@PathVariable Long id) {
        return userService.readUser(id);
    }

    @PutMapping(path = "/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @PostMapping(path = "/user")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @DeleteMapping(path = "/user")
    public String deleteUsers(@RequestParam String ids) {
        return userService.deleteUsers(convertToArray(ids));
    }

    @PostMapping(value = "/register")
    public  User registerUser(@RequestBody User user) throws Exception {
        return userService.registerUser(user);
    }

    @GetMapping(value = "/role")
    public List<Role> readRoles(){
        return userService.readRoles();
    }

    @GetMapping(value="/role/{name}")
    public Role readRoleByRoleName(@PathVariable String name){
        return userService.readRoleByRoleName(name);
    }

    private List<Long> convertToArray(String idsString){
        List<Long> ids = new ArrayList<>();
        String [] splitted = idsString.substring(1,idsString.length()-1).split(",");
        for (String id:splitted
        ) {
            ids.add(Long.valueOf(id));
        }
        return ids;
    }
}
