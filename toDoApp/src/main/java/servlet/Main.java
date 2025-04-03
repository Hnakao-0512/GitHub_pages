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
import model.Parameters;
import model.PostTodoList;
import model.TodoApp;

/**
 * Servlet implementation class ListToDo
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// todoリスト取得
		GetToDoList getToDoList = new GetToDoList();
		List<TodoApp> todoList  =  (List<TodoApp>)getToDoList.execute();
		// リクエストスコープに保存
		request.setAttribute("todoList", todoList);
		//list.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストスコープから取得
		request.setCharacterEncoding("UTF-8");
		String todo = (String) request.getParameter(Parameters.Todo);
		Date timeLimit = Date.valueOf(request.getParameter(Parameters.Time_Limit));
			// todoリスト登録
			TodoApp todoApp = new TodoApp(todo, timeLimit);
			PostTodoList postTodoList = new PostTodoList();
			postTodoList.execute(todoApp);
			
			// todoリスト取得
			GetToDoList getToDoList = new GetToDoList();
			List<TodoApp> todoList  =  (List<TodoApp>)getToDoList.execute();
			request.setAttribute("todoList", todoList);
		//list.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
