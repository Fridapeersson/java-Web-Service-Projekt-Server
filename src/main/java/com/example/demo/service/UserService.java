package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class UserService {
	
	//TODO Kommentera koden mer 
	
	//Lista som sparar användare
	private List<User> userList;
	
	//Metod för att hämta alla användare i listan
	public List<User> getAllUsers() {
		return userList;
	}
	
	
	//Konstruktorn för userService klassen, skapar en lista av användare och lägger till dem i listan
	public UserService() {
		userList = new ArrayList<>();
		
		//Skapar användare
		User user1 = new User(1, "Frida", 30, "Höganäs", "Hund");
		User user2 = new User(2, "Levis", 1, "Ludvigsborg", "Hamster");
		User user3 = new User(3, "Tomas", 40, "Haparanda", "Katt");
		User user4 = new User(4, "Leffe", 25, "Helsingborg", "Fågel");
		User user5 = new User(5, "Maja", 55, "Jonstorp", "Kanin");
		User user6 = new User(6, "Emilia", 70, "båstad", "Hund");
		
		
		userList.addAll(Arrays.asList(user1, user2, user3, user4, user5, user6));
	}
	
	
	public Optional<User> getUser(Integer id) {
		Optional optional = Optional.empty();
		
		for(User user : userList) {
			if(id == user.getId()) {
				optional = Optional.of(user);
				
				return optional;
			}
		}
		return optional;
	}
}

