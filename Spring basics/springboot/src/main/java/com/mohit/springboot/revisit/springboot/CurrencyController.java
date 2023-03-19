package com.mohit.springboot.revisit.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {
	
	@Autowired
	CurrencyConfigurationProperties properties;
	

	@GetMapping("currency")
	public CurrencyConfigurationProperties getCurrency() {
		return properties;
	}
}
