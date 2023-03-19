package com.mohit.springdata.revisit.springdata.revisit.jdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {
	
	@Autowired
	private JdbcTemplate repository;
	
	static String INSERT = 
			"""
			Insert into course (id, name, author) values (?,?,?);
			""";

	public void insert(Course course) {
		this.repository.update(INSERT, course.getId(), course.getName(), course.getAuthor());
	}
}
