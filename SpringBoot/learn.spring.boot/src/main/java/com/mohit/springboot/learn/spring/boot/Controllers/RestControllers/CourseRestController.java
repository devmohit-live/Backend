package com.mohit.springboot.learn.spring.boot.Controllers.RestControllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.springboot.learn.spring.boot.Entity.Course;

@RestController
public class CourseRestController {

	//Jackson : automatically converts list of courses to json
	// whitelabel page is automatically setted-up by ErrorMvcAutoConfiuration
//	 Spring boot :  Dependency injection(spring) and AutoConfiguration (ErrorMvcAutoConfiuration is one of the autoconfiguration sone by boot)
	
	@GetMapping(path = "/courses")
	public List<Course> retrieveAllCourses(){
		return List.of(
				new Course(1,"Learn Java","Mohit"),
				new Course(2,"Learn Python","Mohit"),
				new Course(4,"Learn DevOps","Mohit")
				);
	}
}
