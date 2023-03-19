package com.mohit.springdata.revisit.springdata.revisit.jdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CourseJDBCCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJDBCRepository jdbcRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		this.jdbcRepository.insert(new Course(1,"Java","Mohit"));
	}

}
