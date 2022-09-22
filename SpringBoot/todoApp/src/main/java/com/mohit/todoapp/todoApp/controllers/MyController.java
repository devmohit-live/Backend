package com.mohit.todoapp.todoApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@GetMapping("/say-hello")
//	@RequestMapping("/hello") // requestMapping has more priority
	@ResponseBody
	public String sayHello() {
		return "Hello, What's on your mind today?";
	}
	
	
	@GetMapping("/hello")
	public String sayHelloView() {
		return "hello";
	}

}
	