package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DeleteTodo;
import model.GetToDoList;
import model.Parameters;
import model.TodoApp;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		int id = Integer.parseInt(request.getParameter(Parameters.Todo_Id));
		DeleteTodo deleteTodo = new DeleteTodo();
		deleteTodo.execute(id);
		
		// todoリスト取得
		GetToDoList getToDoList = new GetToDoList();
		List<TodoApp> todoList  =  (List<TodoApp>)getToDoList.execute();
		request.setAttribute("todoList", todoList);
	//list.jspにフォワード
	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
