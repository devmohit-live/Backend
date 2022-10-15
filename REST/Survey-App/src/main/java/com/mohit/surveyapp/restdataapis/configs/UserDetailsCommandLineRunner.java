package com.mohit.surveyapp.restdataapis.configs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mohit.surveyapp.repository.UserDetailsRepository;
import com.mohit.surveyapp.restdataapis.entity.UserDetails;

@Component //we want spring to manage this
public class UserDetailsCommandLineRunner implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserDetailsRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
//		logger.info(Arrays.toString(args));
		repository.save(new UserDetails("Mohit", "Admin"));
		repository.save(new UserDetails("Shobhit", "Admin"));
		repository.save(new UserDetails("Ravi", "User"));
		
		List<UserDetails> users = repository.findByRole("Admin");
		users.forEach(user->logger.info(user.toString()));
	}

}
