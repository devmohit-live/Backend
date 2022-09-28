package com.mohit.todoapp.todoApp.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mohit.todoapp.todoApp.entity.Todo;

import jakarta.validation.Valid;

@Service
public class TodoServices {
	private static List<Todo> todos = new ArrayList<>();
	private static int idx = 0;

	static {
		todos.add(new Todo(++idx, "mohit", "Learn Java", LocalDate.now().plusMonths(2), false));
		todos.add(new Todo(++idx, "mohit", "Learn Spring", LocalDate.now().plusDays(10), false));
		todos.add(new Todo(++idx, "mohit", "Learn Python", LocalDate.now(), true));
		todos.add(new Todo(++idx, "mohit", "Learn DevOps", LocalDate.now().plusMonths(5), false));
		todos.add(new Todo(++idx, "mohit", "Learn BlockChain", LocalDate.now().plusYears(1), false));

	}

	public List<Todo> getTodoByUserame(String username) {
//		return todos.stream().filter(el -> el.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());
		return todos.stream().filter(el -> el.getUsername().equalsIgnoreCase(username)).toList();
	}

	public void addTodo(String description, String username, LocalDate date) {
		todos.add(new Todo(++idx, username, description, date, false));
	}

	public void deleteById(int id) {
		todos.removeIf(el -> el.getId() == id);
	}

	public Todo findById(int id) {
		// TODO Auto-generated method stub
		return todos.stream().filter(el -> el.getId() == id).findFirst().get();
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todo.setTargetDate(todo.getTargetDate());
		todos.add(todo);
		System.out.println("Added " + todo);
	}

}
