package com.mohit.todoapp.todoApp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mohit.todoapp.todoApp.Services.AuthenticationService;

@Controller
@SessionAttributes("username")
public class LoginController {

//	private Logger logger  = LoggerFactory.getLogger(getClass()); // logger for this particular class
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@GetMapping("/login")
	public String gotoLogin() {
		return "login";
	}
	
	
	@PostMapping("/login")
	public String gotoWelcome(@RequestParam String username,
			@RequestParam String password, ModelMap map) {
		if(! authenticationService.authenticate(username, password)) {
			map.put("error", "Wrong Username or Password");
			return "login";
		}
		map.put("username", username);
		map.put("password", password);
		return "welcome";
	}

}
