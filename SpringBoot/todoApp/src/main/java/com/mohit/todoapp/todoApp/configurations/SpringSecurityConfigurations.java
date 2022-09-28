package com.mohit.todoapp.todoApp.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfigurations {
//generally LDAP or Db is used for user details
	//we are here using inMewmory User details
	
	@Bean
	public InMemoryUserDetailsManager createUserDetails() {
		UserDetails userDetails = User.withDefaultPasswordEncoder().username("mohit").password("123")
		.roles("USER","ADMIN").build();
		return new InMemoryUserDetailsManager(userDetails);
	}
}
