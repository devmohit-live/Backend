package com.mohit.todoapp.todoApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.todoapp.todoApp.entity.Todo;

public interface TodoRepsitory extends JpaRepository<Todo, Integer>{

	public List<Todo> findByUsername(String username);
}