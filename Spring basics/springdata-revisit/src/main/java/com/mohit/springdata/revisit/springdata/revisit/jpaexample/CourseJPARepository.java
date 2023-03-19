package com.mohit.springdata.revisit.springdata.revisit.jpaexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.mohit.springdata.revisit.springdata.revisit.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional //Jpa requires this annotation
public class CourseJPARepository {
	
//	@Autowired
	//more specific annotation for jpa persistence
	@PersistenceContext   
	private EntityManager entityManager;
	
	
	public void insert(Course course) {
		this.entityManager.merge(course);
	}
	
	public void deleteById(long id) {
		Course course = this.findById(id);
		this.entityManager.remove(course);
	}
		
	
	public Course findById(long id) {
		return this.entityManager.find(Course.class, id);
	}
	

}
