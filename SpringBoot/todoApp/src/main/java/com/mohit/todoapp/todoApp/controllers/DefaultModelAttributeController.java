package com.mohit.todoapp.todoApp.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mohit.todoapp.todoApp.entity.ToDo;

@ControllerAdvice // applies to all contrllers
public class DefaultModelAttributeController {
	// to return default ModelAttribute of respective classes for different controller
	
	
	@ModelAttribute("newTodo") //for function addtodo in TodoController
	public ToDo getDefaultTodoPlaceHolder() {
		return new ToDo();
	}
}
