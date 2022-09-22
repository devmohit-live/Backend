package com.mohit.todoapp.todoApp.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mohit.todoapp.todoApp.entity.ToDo;

@Service
public class TodoServices {
	private static List<ToDo> todos;

	static {
		todos = List.of(
				new ToDo(1, "mohit", "Learn Java", LocalDate.now().plusMonths(2), false),
				new ToDo(2, "mohit", "Learn Spring", LocalDate.now().plusDays(10), false),
				new ToDo(3, "mohit", "Learn Python", LocalDate.now(), true),
				new ToDo(4, "mohit", "Learn DevOps", LocalDate.now().plusMonths(5), false),
				new ToDo(5, "mohit", "Learn BlockChain", LocalDate.now().plusYears(1), false)
				);
	}
	
	
	public List<ToDo> getTodoByUserame(String username){
		return todos;
	}
}
