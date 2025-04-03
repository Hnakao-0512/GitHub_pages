package model;

import java.util.List;

import dao.TodoDAO;

public class GetToDoList {
	public List<TodoApp> execute() {
		TodoDAO dao = new TodoDAO();
		List<TodoApp> todoList = dao.findAll(); //TodoDAOのfindAllを使って取得
		
		return todoList;
	}
}
