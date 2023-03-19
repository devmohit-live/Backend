package com.mohit.springdata.revisit.springdata.revisit.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mohit.springdata.revisit.springdata.revisit.jdbcexample.CourseJDBCRepository;
import com.mohit.springdata.revisit.springdata.revisit.jpaexample.CourseJPARepository;


@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJDBCRepository repository;
	
	@Autowired
	private CourseJPARepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
		this.repository.insert(new Course(1,"Java","Mohit"));
		this.repository.insert(new Course(2,"AWS","Mohit"));
		this.repository.insert(new Course(3,"Spring Boot","Mohit"));
		
		this.repository.deleteById(1);
		
		System.out.println(this.repository.findById(2));
	}

}
