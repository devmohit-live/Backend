package com.mohit.springdata.revisit.springdata.revisit.spring_data_jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.mohit.springdata.revisit.springdata.revisit.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public interface CourseSpringDataJPARepository extends JpaRepository<Course, Long>{
	//custom method : patten actionByAttribute : find By Author
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
