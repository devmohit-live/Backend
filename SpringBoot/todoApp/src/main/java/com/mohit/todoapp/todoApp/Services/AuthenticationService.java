package com.mohit.todoapp.todoApp.Services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	private final String validUserName = "mohit";
	private final String validPassword = "123";
	public boolean authenticate(String username, String pass) {
		if(username.equals(validUserName)) {
			if(pass.equals(validPassword)) return true;
			return false;
		}
		return false;
	}
	
}
