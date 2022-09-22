package com.mohit.todoapp.todoApp.controllers;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mohit.todoapp.todoApp.Services.TodoServices;
import com.mohit.todoapp.todoApp.entity.ToDo;

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
	
	@GetMapping("/add-todo")
	public String gotoTodo(@ModelAttribute("newTodo")ToDo todo) {
//		String username = (String)model.get("username");
////		ToDo todo = new ToDo(0, username, null, LocalDate.now(), false);
//		ToDo todo = new ToDo();
//		
//		//default todo for modelAttribute form 
		
//		model.put("todo", todo);
		return "addTodo";
	}
	
//	@PostMapping("/add-todo")
//	public String addTodo(@RequestParam String description,@SessionAttribute String username) {
//		services.addTodo(description, username);
//		return "redirect:list-todos";
//	}
	
	
	@PostMapping("/add-todo")
	public String addTodo(ModelMap map,  @ModelAttribute("newTodo")ToDo todo) {
		services.addTodo(todo.getDescription(), (String)map.get("username"));
		return "redirect:list-todos";
	}
	
	

}
