package com.mohit.todoapp.todoApp.configurations;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfigurations {
//generally LDAP or Db is used for user details
	// we are here using inMewmory User details

	@Bean
	public InMemoryUserDetailsManager createUserDetails() {
		
		// function to use Bycrypt encoder and incode password
		Function<String, String> passwordEncoder = inp->passwordEncoder().encode(inp);
		
		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEncoder )
				.username("mohit").password("123")
				.roles("USER", "ADMIN").build();
		return new InMemoryUserDetailsManager(userDetails);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
