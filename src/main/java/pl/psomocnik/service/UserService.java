package pl.psomocnik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.psomocnik.dao.UserRepository;
import pl.psomocnik.model.User;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    UserService() {

    }

    public List<User> readUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User readUser(Long id) {
        return userRepository.findById(id).get();
    }

    public User updateUser(Long id, User user) {
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setRole(user.getRole());
        userToUpdate.setLastChanged(new Date());
        userRepository.save(userToUpdate);
        return userToUpdate;
    }

    public User createUser(User user) {
        User createdUser = new User(user.getUsername(), user.getEmail(), user.getRole());
        return userRepository.save(createdUser);
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted!";
    }
}
