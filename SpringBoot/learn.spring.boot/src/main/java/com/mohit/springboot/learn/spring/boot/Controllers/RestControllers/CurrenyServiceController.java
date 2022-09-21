package com.mohit.springboot.learn.spring.boot.Controllers.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.springboot.learn.spring.boot.configurations.CurrecyConfigurations;
@RestController
public class CurrenyServiceController {
	@Autowired
	private CurrecyConfigurations configurations;

	@GetMapping("/currency-configs")
	public CurrecyConfigurations getProfileConfigurations() {
		return configurations;
	}
}
