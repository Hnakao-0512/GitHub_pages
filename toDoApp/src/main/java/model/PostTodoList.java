package model;

import dao.TodoDAO;

public class PostTodoList {

	public void execute(TodoApp todoApp) {
		TodoDAO dao = new TodoDAO();
		dao.insertTodo(todoApp);     //TodoDAOinsertTodoのを使って取得
	}
}
