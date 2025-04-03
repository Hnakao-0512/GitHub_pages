package model;

import dao.TodoDAO;

public class PostUpdateTodo {
	public void execute(TodoApp todoApp) {
		TodoDAO dao = new TodoDAO();
		dao.updateTodo(todoApp);
	}
}
