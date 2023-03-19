package com.mohit.springdata.revisit.springdata.revisit.jdbcexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mohit.springdata.revisit.springdata.revisit.course.Course;

@Repository
public class CourseJDBCRepository {
	
	@Autowired
	private JdbcTemplate repository;
	
	static String INSERT = 
			"""
			Insert into course (id, name, author) values (?,?,?);
			""";
	
	static String DELETE = 
			"""
			Delete from course where id = ?;
			""";
	
	static String FIND = 
			"""
			Select * from course where id = ?;
			""";

	public void insert(Course course) {
		this.repository.update(INSERT, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(long id) {
		this.repository.update(DELETE, id);
	}
	
	public Course findById(long id) {
		// to fetch a single object
		// result set => bean => Row mapper 
		return this.repository.queryForObject(FIND, new BeanPropertyRowMapper<>(Course.class), id);
	}

}
