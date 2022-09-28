package com.mohit.todoapp.todoApp.controllers;


import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mohit.todoapp.todoApp.Services.TodoServices;
import com.mohit.todoapp.todoApp.entity.Todo;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class TodoContoller {
	@Autowired
	private TodoServices services;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/list-todos")
	public String getTodos(ModelMap map) {
		map.addAttribute("todos",services.getTodoByUserame("mohit") );
		return "listTodos";
	}
	
	@GetMapping("/add-todo")
	public String gotoTodo(@ModelAttribute("todo")Todo todo) {
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
	
	//We are using JSR-380 Validation rules
	
	//BindingResult stores the add invalid validation results
	// it have to be placed just immediate adjacent to @modelAttribute
	
	@PostMapping("/add-todo")
	public String addTodo(ModelMap map, @Valid @ModelAttribute("todo")Todo todo, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			logger.info("This is the error {} ", bindingResult.getAllErrors());
			return "addTodo"; //remain at same page
		}
		
		
		services.addTodo(todo.getDescription(), (String)map.get("username"), todo.getTargetDate());
		return "redirect:list-todos";
	}
	
	@GetMapping("/delete-todo")
	public String deletTodo(@RequestParam int id) {
		services.deleteById(id);
		return "redirect:list-todos";
	}
	
	@GetMapping("/update-todo")
	public String showUpdateTodoPage(@RequestParam int id,ModelMap map) {
		Todo foundTodo = services.findById(id);
		System.out.println(foundTodo);
		map.put("todo", foundTodo);
		return "addTodo";
	}
	
	@PostMapping("/update-todo")
	public String updateTodo( @Valid Todo todo, BindingResult bindingResult, ModelMap map) {
		if(bindingResult.hasErrors()) {
			logger.info("This is the error {} ", bindingResult.toString());
			return "addTodo"; //remain at same page
		}
		todo.setUsername((String)map.get("username"));
		services.updateTodo(todo); //updating the todo
//		map.addAttribute("todo", todo); //adding an attributes 
		
		return "redirect:list-todos";
	}
	
	

}
