package com.oliveiralucaspro.restful.ws.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oliveiralucaspro.restful.ws.domain.User;
import com.oliveiralucaspro.restful.ws.domain.UserDaoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserResource {

    private final UserDaoService service;
    
    // retrieve all users
    @GetMapping("/users")
    public List<User> getAllUsers(){
	return service.findAll();
    }
    
    
    // retrieve user by id
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
	return service.finOne(id);
    }
    
    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
	User savedUser = service.save(user);
    }
    
}
