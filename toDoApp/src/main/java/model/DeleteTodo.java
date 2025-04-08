package model;

import dao.TodoDAO;

public class DeleteTodo {
	public void execute(int id) {
		TodoDAO dao = new TodoDAO();
		dao.daleteTodo(id);     
	}
}
