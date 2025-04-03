package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GetToDoList;
import model.GetUpdateTodo;
import model.Parameters;
import model.PostUpdateTodo;
import model.TodoApp;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パラメータからID取得
		int todoId = Integer.parseInt(request.getParameter(Parameters.Todo_Id));
		//更新するtodoを取得
		GetUpdateTodo getUpdateTodo = new GetUpdateTodo();
		TodoApp todoApp =(TodoApp) getUpdateTodo.execute(todoId);
		
		request.setAttribute("todoApp", todoApp);
		//
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/update.jsp");
		dispatcher.forward(request, response);
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
		 int id = Integer.parseInt(request.getParameter(Parameters.Todo_Id));
		 String todo = request.getParameter(Parameters.Todo);
		 Date timeLimit = Date.valueOf(request.getParameter(Parameters.Time_Limit));
		 System.out.println(id);
		 
			 TodoApp todoApp = new TodoApp(id, todo, timeLimit);
			 PostUpdateTodo postUpdateTodo = new PostUpdateTodo();
			 postUpdateTodo.execute(todoApp);
			 
			// todoリスト取得
			GetToDoList getToDoList = new GetToDoList();
			List<TodoApp> todoList  =  (List<TodoApp>)getToDoList.execute();
			request.setAttribute("todoList", todoList);
		//list.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);

	}

}
