package com.mohit.todoapp.todoApp.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mohit.todoapp.todoApp.entity.Todo;

@ControllerAdvice // applies to all contrllers
public class DefaultModelAttributeController {
	// to return default ModelAttribute of respective classes for different controller
	
	
	@ModelAttribute("todo") //for function addtodo in TodoController
	public Todo getDefaultTodoPlaceHolder() {
		return new Todo();
	}
}
