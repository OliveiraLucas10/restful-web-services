package com.oliveiralucaspro.restful.ws.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
	users.add(new User(1, "Pedro", new Date()));
	users.add(new User(2, "Sergio", new Date()));
	users.add(new User(3, "Nuno", new Date()));
    }

    public List<User> findAll() {
	return users;
    }

    public User save(User user) {
	if (user.getId() == null) {
	    user.setId(usersCount++);
	}

	users.add(user);
	return user;
    }

    public User finOne(int id) {
	return users.stream().filter(el -> el.getId() == id).findAny().orElse(null);
    }
}
