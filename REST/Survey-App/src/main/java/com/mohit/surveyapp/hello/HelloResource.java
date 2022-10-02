package com.mohit.surveyapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
	

	@GetMapping("/hello")
	public HelloBean sayHelloBean() {
		return new HelloBean("Mohit");
	}
	
	@GetMapping("/hello/{name}")
	public HelloBean sayHelloBeanPath(@PathVariable String name) {
		return new HelloBean("Hello "+name);
	}
	
	@GetMapping("/hello/{name}/{msg}")
	public HelloBean sayHelloBeanMultipleVars(@PathVariable String name, @PathVariable String msg) {
		return new HelloBean("Hello "+name+","+msg);
	}
}
