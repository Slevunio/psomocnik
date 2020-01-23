package pl.psomocnik.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.psomocnik.dao.RoleRepository;
import pl.psomocnik.dao.UserRepository;
import pl.psomocnik.model.Role;
import pl.psomocnik.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

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

    public User updateUser(User user) {
        User userToUpdate = userRepository.findById(user.getId()).get();
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setRole(user.getRole());
        userToUpdate.setLastChanged(new Date());
        userRepository.save(userToUpdate);
        return userToUpdate;
    }

    public User createUser(User user) {
        User createdUser = new User(user.getUsername(), user.getEmail(), bCryptPasswordEncoder.encode(user.getPassword()), user.getRole());
        return userRepository.save(createdUser);
    }

    public User registerUser(User user) {
        User registeredUser = new User(user.getUsername(), user.getEmail(), bCryptPasswordEncoder.encode(user.getPassword()), user.getRole());
        return userRepository.save(registeredUser);
    }

    public String deleteUsers(List<Long> ids) {
        for (Long id:ids
             ) {
            userRepository.deleteById(id);
        }
        return "Users deleted!";
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<Role> readRoles() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    public Role readRoleByRoleName(String name) {
        return roleRepository.findByName(name);
    }
}