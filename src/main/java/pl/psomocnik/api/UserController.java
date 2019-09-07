package pl.psomocnik.api;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import pl.psomocnik.model.JwtRequest;
import pl.psomocnik.model.JwtResponse;
import pl.psomocnik.model.Role;
import pl.psomocnik.security.JwtTokenUtil;
import pl.psomocnik.service.UserDetailsServiceImpl;
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
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

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

    @DeleteMapping(path = "/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token, userDetails.getAuthorities().toString()));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);//
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
    @PostMapping(value = "/register")
    public  ResponseEntity<?> registerUser(@RequestBody User user) throws Exception {

        userService.registerUser(user);
        return createAuthenticationToken(new JwtRequest(user.getUsername(), user.getPassword()));
        //return user;
    }

    @GetMapping(value = "/role")
    public List<Role> readRoles(){
        return userService.readRoles();
    }

    @GetMapping(value="/role/{name}")
    public Role readRoleByRoleName(@PathVariable String name){
        return userService.readRoleByRoleName(name);
    }
}
