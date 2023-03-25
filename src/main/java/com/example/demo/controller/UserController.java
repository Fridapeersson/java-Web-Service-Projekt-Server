package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public void userController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping("/user")
	public User getUser(@RequestParam Integer id) {
		Optional<User> user = userService.getUser(id);
		if(user.isPresent()) {
			return (User) user.get();
		}
		return null;
	}
	
	@GetMapping("/user/{id}")
	public User getUserByPathVariable(@PathVariable Integer id) {
		Optional<User> user = userService.getUser(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
}
