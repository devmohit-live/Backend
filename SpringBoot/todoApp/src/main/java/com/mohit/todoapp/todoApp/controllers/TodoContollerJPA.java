package com.mohit.todoapp.todoApp.controllers;


import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mohit.todoapp.todoApp.Services.TodoServices;
import com.mohit.todoapp.todoApp.Services.UserServices;
import com.mohit.todoapp.todoApp.entity.Todo;
import com.mohit.todoapp.todoApp.repository.TodoRepsitory;

import jakarta.validation.Valid;

@Controller
public class TodoContollerJPA {
	@Autowired
	private UserServices userServices;
	@Autowired
	private TodoRepsitory todoRepsitory;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/list-todos")
	public String getTodos(ModelMap map) {
		map.addAttribute("todos",todoRepsitory.findByUsername(userServices.getUserName()) );
		map.put("username", userServices.getUserName());
		return "listTodos";
	}
	
	@GetMapping("/add-todo")
	public String gotoTodo(@ModelAttribute("todo")Todo todo, ModelMap map) {
		todo.setUsername(userServices.getUserName());
		map.put("todo", todo);
		return "addTodo";
	}
	
	@PostMapping("/add-todo")
	public String addTodo(ModelMap map, @Valid @ModelAttribute("todo")Todo todo, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			logger.info("This is the error {} ", bindingResult.getAllErrors());
			return "addTodo"; //remain at same page
		}
		
		todo.setUsername(userServices.getUserName());
		todoRepsitory.save(todo);
		
//		servivce.addtodo(todo.getDescription(), , todo.getTargetDate());
		return "redirect:list-todos";
	}
	
	@GetMapping("/delete-todo")
	public String deletTodo(@RequestParam int id) {
		todoRepsitory.deleteById(id);
		return "redirect:list-todos";
	}
	
	@GetMapping("/update-todo")
	public String showUpdateTodoPage(@RequestParam int id,ModelMap map) {
		Optional<Todo> foundTodo = todoRepsitory.findById(id);
		System.out.println(foundTodo.get());
		map.put("todo", foundTodo.get());
		return "addTodo";
	}
	
	@PostMapping("/update-todo")
	public String updateTodo( @Valid Todo todo, BindingResult bindingResult, ModelMap map) {
		if(bindingResult.hasErrors()) {
			logger.info("This is the error {} ", bindingResult.toString());
			return "addTodo"; //remain at same page
		}
		todo.setUsername(userServices.getUserName());
		todoRepsitory.save(todo); //updating the todo
		
		return "redirect:list-todos";
	}
	
	

}
