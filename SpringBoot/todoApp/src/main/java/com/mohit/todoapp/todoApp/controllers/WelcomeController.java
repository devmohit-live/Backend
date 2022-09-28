package com.mohit.todoapp.todoApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mohit.todoapp.todoApp.Services.UserServices;

@Controller
@SessionAttributes("username")
public class WelcomeController {

	@Autowired
	UserServices userServices;
	
//	private Logger logger  = LoggerFactory.getLogger(getClass()); // logger for this particular class
//Spring sec forces user to be on /login doesn't allows to go to any other route unless loggedin
	@GetMapping("/")
	public String gotoWelcomePage(ModelMap map) {
		
		map.put("username", userServices.getUserName());
		return "welcome";
	}

}
