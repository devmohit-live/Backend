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
		
		UserDetails user1 = createNewUser(passwordEncoder, "123", "mohit");
		UserDetails user2 = createNewUser(passwordEncoder, "456", "shobhit");
		
		return new InMemoryUserDetailsManager(user1, user2);
	}

private UserDetails createNewUser(Function<String, String> passwordEncoder, String password, String username) {
	return User.builder()
			.passwordEncoder(passwordEncoder )
			.username(username).password(password)
			.roles("USER", "ADMIN").build();
}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
