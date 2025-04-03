package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TodoApp;

public class TodoDAO {

	// データベースから読み込み
	String JDBC_URL = "jdbc:mariadb://localhost/todoapp";
	String DB_USER = "root";
	String DB_PASS = "admin";
	// データベースから表取得
	public List<TodoApp> findAll() { 
		
		//SQL文(SELECT)を作成
		String sql = "SELECT " +
						"id, " +
						"todo, " +
						"timelimit " +
					"FROM todo" ;
		
		
		//ArrayListを作成
		List<TodoApp> todoList = new ArrayList<>();
		
		// データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			//SQL文(SELECT)をDBに送信
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SQLの実行し結果表を取得(ResultSetに格納) 
			ResultSet rs = pStmt.executeQuery();
			
			/*結果表に格納されているデータを変数に設定し表示*/
			while(rs.next()) {       
				int id = rs.getInt("id");  
				String todo = rs.getString("todo");
				Date timeLimit = rs.getDate("timeLimit");
				//取得した値をインスタンスに格納
				TodoApp todoApp = new TodoApp(id, todo, timeLimit);
				 
				//ArrayListインスタンスにtodoAppインスタンスを追加
				 todoList.add(todoApp);
				 
			}			
		} catch (SQLException e) {
			e.printStackTrace();   //接続やSQL処理失敗時の処理
			return null;
		}
		return todoList;
		
	}	
	// データベースに追加
	public boolean insertTodo(TodoApp todoApp) {
		
		
		// データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO todo(todo, timelimit) " +
					"VALUES(?, ?) "; 

			//SQL文(INSERT)をDBに送信準備
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, todoApp.getTodo()); 
			pStmt.setDate(2, todoApp.getTimeLimit()); 
			//SQLの実行し登録件数を取得 
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false; //登録失敗
			
			}			
		} catch (SQLException e) {
			e.printStackTrace();   //接続やSQL処理失敗時の処理
			return false;
		}
		return true; //登録成功
	
			}
	// 受けっとたIDのデータ取得
	public TodoApp getTodoId(int id) { 
			
			//SQL文(SELECT)を作成
			String sql = "SELECT " +
							"id, " +
							"todo, " +
							"timelimit " +
						"FROM todo WHERE id = ?" ;
			
			
			TodoApp todoApp = new TodoApp();
			
			// データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
				
				//SQL文(SELECT)をDBに送信準備
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				pStmt.setInt(1, id);
				//SQLの実行し結果表を取得(ResultSetに格納) 
				ResultSet rs = pStmt.executeQuery();
				//	データを格納			
				while(rs.next()) {       
					todoApp.setId(rs.getInt("id"));
					todoApp.setTodo(rs.getString("todo"));
					todoApp.setTimeLimit(rs.getDate("timeLimit"));
					
				}			
			} catch (SQLException e) {
				e.printStackTrace();   //接続やSQL処理失敗時の処理
				return null;
			}
			return todoApp;
	}

	public boolean updateTodo(TodoApp todoApp) { 
		
		//SQL文(SELECT)を作成
			String sql = "UPDATE " +
							"todo " +
							"SET " +
							"todo =  ?, " +
							"timelimit =  ? " +						
						  "WHERE id = ?" ;
			try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
				
				
				pStmt.setString(1, todoApp.getTodo()); 
				pStmt.setDate(2, todoApp.getTimeLimit()); 
				pStmt.setInt(3, todoApp.getId());
					
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false; //登録失敗
		}
			} catch (SQLException e) {
		e.printStackTrace();   //接続やSQL処理失敗時の処理
		return false;
	   }
	    return true;
	}
}
