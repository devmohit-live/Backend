package com.mohit.springdata.revisit.springdata.revisit.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mohit.springdata.revisit.springdata.revisit.jdbc_example.CourseJDBCRepository;
import com.mohit.springdata.revisit.springdata.revisit.jpa_example.CourseJPARepository;
import com.mohit.springdata.revisit.springdata.revisit.spring_data_jpa.CourseSpringDataJPARepository;

//CommandLineRunner : It is used to execute the code after the Spring Boot application started.

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

// Sprinf JDBC
//	@Autowired
//	private CourseJDBCRepository repository;
	
	
// JPA
//	@Autowired
//	private CourseJPARepository repository;
	
	
// Spring Data JPA
	@Autowired
	private CourseSpringDataJPARepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
//		this.repository.insert(new Course(1,"Java","Mohit"));
//		this.repository.insert(new Course(2,"AWS","Mohit"));
//		this.repository.insert(new Course(3,"Spring Boot","Mohit"));
		
		//Jpa uses save method
		this.repository.save(new Course(1,"Java","Mohit"));
		this.repository.save(new Course(2,"AWS","Mohit"));
		this.repository.save(new Course(3,"Spring Boot","Mohit"));
		
		this.repository.deleteById(1l);
		
		System.out.println(this.repository.findById(2l));
		
		System.out.println(this.repository.findByAuthor("Mohit"));
		System.out.println(this.repository.findByName("AWS"));
		
	}

}
