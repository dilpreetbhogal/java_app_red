package com.example.electronicstore.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electronicstore.login.entity.User;
import com.example.electronicstore.login.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
    public boolean userExists(String email) {
	        // Implement the logic to check if a user with the given email already exists in your data store
	        
	    User existingUser = userRepository.findByEmail(email);
	    return existingUser != null;
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

}
