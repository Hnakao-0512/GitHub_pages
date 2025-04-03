package model;



import dao.TodoDAO;

public class GetUpdateTodo {

	public TodoApp execute(int id) {
		TodoDAO dao = new TodoDAO();
		TodoApp todoApp = dao.getTodoId(id);
		return todoApp;
		
	}
}
