package com.mohit.todoapp.todoApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mohit.todoapp.todoApp.Services.AuthenticationService;
import com.mohit.todoapp.todoApp.Services.TodoServices;

@Controller
@SessionAttributes("username")
public class TodoContoller {
	@Autowired
	TodoServices services;
	
	@GetMapping("/list-todos")
	public String getTodos(ModelMap map) {
		map.addAttribute("todos",services.getTodoByUserame("mohit") );
		return "listTodos";
	}

}
