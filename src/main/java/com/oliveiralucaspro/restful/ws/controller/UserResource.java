package com.oliveiralucaspro.restful.ws.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oliveiralucaspro.restful.ws.domain.User;
import com.oliveiralucaspro.restful.ws.domain.UserDaoService;
import com.oliveiralucaspro.restful.ws.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserResource {

    private final UserDaoService service;

    // retrieve all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
	return service.findAll();
    }

    // retrieve user by id
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
	User user = service.finOne(id);
	if (user == null) {
	    throw new UserNotFoundException("id-" + id);
	}

	return user;
    }

    // delete user by id
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) {
	User user = service.deleteByI(id);
	if (user == null) {
	    throw new UserNotFoundException("id-" + id);
	}
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
	User savedUser = service.save(user);

	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
		.toUri();

	return ResponseEntity.created(location).build();
    }

}
