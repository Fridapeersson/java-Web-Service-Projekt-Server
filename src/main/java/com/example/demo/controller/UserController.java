package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public void userController(UserService userService) {
		this.userService = userService;
	}
	
	//Hämtar alla användare i listan
	@GetMapping("/users")
	public ResponseEntity<String> getAllUsers() throws JsonProcessingException {
        List<User> userList = userService.getAllUsers();
        if (userList.size() > 0) {
        	// Om det finns användare, konvertera till en JSON-sträng
            ObjectMapper mapper = new ObjectMapper();
            String jsonUsers = mapper.writeValueAsString(userList);
            return ResponseEntity.ok().body(jsonUsers);
        }
        return ResponseEntity.notFound().build();
    }

    //Hämtar specifik användare efter id som valts
    @GetMapping("/user")
    public ResponseEntity<String> getUser(@RequestParam Integer id) throws JsonProcessingException {
    	// Hämta användaren med det angivna id:et från UserService
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()) {
            ObjectMapper mapper = new ObjectMapper();
            String jsonUser = mapper.writeValueAsString(user.get());

            return ResponseEntity.ok().body(jsonUser);
        }
        return null;
    }
}
