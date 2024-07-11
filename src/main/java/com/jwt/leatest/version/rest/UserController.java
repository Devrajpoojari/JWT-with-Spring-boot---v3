package com.jwt.leatest.version.rest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.leatest.version.model.User;
import com.jwt.leatest.version.service.UserService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user-add")
	public User addUser(@RequestBody User u) {
		return userService.addUser(u);
	}

	@GetMapping("/get-user/{id}")
	public User getUser(@PathVariable Integer id) {
		return userService.getUser(id);
	}
}
