package com.example.practicaapx.controller;

import com.example.practicaapx.model.User;
import com.example.practicaapx.services.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    UserService usService;

    public UserController(UserService usService) {
        this.usService = usService;
    }

    
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = usService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @GetMapping({"/{userId}"})
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        return new ResponseEntity<>(usService.getUserById(userId), HttpStatus.OK);
    }
    
    @GetMapping(value = "/users")
    public List<Object> getUsers() {
    	 String url = "https://reqres.in/api";

        RestTemplate restTemplate = new RestTemplate();
        Object [] users = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(users);
    }
    
    public ResponseEntity<User> saveUser(@RequestBody User us) {
User us1 = usService.insert(us);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("user", "/api/v1/user/" + us1.getId().toString());
        return new ResponseEntity<>(us1, httpHeaders, HttpStatus.CREATED);
    }
   
    @PutMapping({"/{userId}"})
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User us) {
        usService.updateUser(userId, us);
        return new ResponseEntity<>(usService.getUserById(userId), HttpStatus.OK);
    }
    
    
    @DeleteMapping({"/{userId}"})
    public ResponseEntity<User> deleteUser(@PathVariable("userId") Long userId) {
        usService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
}

