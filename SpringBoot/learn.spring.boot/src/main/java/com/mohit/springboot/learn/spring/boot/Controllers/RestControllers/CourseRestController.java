package com.mohit.springboot.learn.spring.boot.Controllers.RestControllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.springboot.learn.spring.boot.Entity.Course;

@RestController
public class CourseRestController {

	@GetMapping(path = "/courses")
	public List<Course> retrieveAllCourses(){
		return List.of(
				new Course(1,"Learn Java","Mohit"),
				new Course(1,"Learn Python","Mohit"),
				new Course(1,"Learn DevOps","Mohit")
				);
	}
}
