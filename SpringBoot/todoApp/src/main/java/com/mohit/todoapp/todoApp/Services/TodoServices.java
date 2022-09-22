package com.mohit.todoapp.todoApp.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mohit.todoapp.todoApp.entity.ToDo;

@Service
public class TodoServices {
	private static List<ToDo> todos = new ArrayList<>();
	private static int idx = 0;
	
	static {
		todos.add(new ToDo(++idx, "mohit", "Learn Java", LocalDate.now().plusMonths(2), false));
		todos.add(new ToDo(++idx, "mohit", "Learn Spring", LocalDate.now().plusDays(10), false));
		todos.add(new ToDo(++idx, "mohit", "Learn Python", LocalDate.now(), true));
		todos.add(new ToDo(++idx, "mohit", "Learn DevOps", LocalDate.now().plusMonths(5), false));
		todos.add(new ToDo(++idx, "mohit", "Learn BlockChain", LocalDate.now().plusYears(1), false));
				
	}
	
	
	public List<ToDo> getTodoByUserame(String username){
		return todos;
	}


	public void addTodo(String description,String username) {
		todos.add(new ToDo(++idx, username, description, LocalDate.now().plusYears(1), false))	;	
	}


	public void delete(int id) {
		todos.removeIf(el->el.getId()==id);
	}
}
