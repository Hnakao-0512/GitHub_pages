package model;

import java.io.Serializable;
import java.sql.Date;

public class TodoApp implements Serializable {
	private int id; //ID
	private String todo;      //内容
	private Date timeLimit;   //期限
	
//初期化用	
 public TodoApp () {
	        id = 0;
	        todo = "";
	        timeLimit = new Date(System.currentTimeMillis());
	    }
 
 public TodoApp(int id, String todo, Date timeLimit) {
 	 	this.id = id;
		this.todo = todo;
		this.timeLimit = timeLimit;
		
}
 public TodoApp( String todo, Date timeLimit) {                         	 	
		this.todo = todo;
		this.timeLimit = timeLimit;
		
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTodo() {
	return todo;
}

public void setTodo(String todo) {
	this.todo = todo;
}

public Date getTimeLimit() {
	return timeLimit;
}

public void setTimeLimit(Date timeLimit) {
	this.timeLimit = timeLimit;
}
 
 
}
