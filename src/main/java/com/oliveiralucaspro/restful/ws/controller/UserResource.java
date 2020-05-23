package com.oliveiralucaspro.restful.ws.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.oliveiralucaspro.restful.ws.domain.User;
import com.oliveiralucaspro.restful.ws.domain.UserDaoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserResource {

    private final UserDaoService service;
    
    // retrieve all users
    @GetMapping("/user")
    public List<User> getAllUsers(){
	return service.findAll();
    }
    
    
    // retrieve user by id
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
	return service.finOne(id);
    }
    
}
