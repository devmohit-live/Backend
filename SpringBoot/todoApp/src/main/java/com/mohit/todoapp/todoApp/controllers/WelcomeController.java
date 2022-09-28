package com.mohit.todoapp.todoApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class WelcomeController {

//	private Logger logger  = LoggerFactory.getLogger(getClass()); // logger for this particular class
//Spring sec forces user to be on /login doesn't allows to go to any other route unless loggedin
	@GetMapping("/")
	public String gotoWelcomePage(ModelMap map) {
		map.put("username", "Mohit");
		return "welcome";
	}

}
