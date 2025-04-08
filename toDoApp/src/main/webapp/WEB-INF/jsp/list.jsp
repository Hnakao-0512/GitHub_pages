<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page import="java.util.List, java.util.ArrayList, model.TodoApp, model.Parameters" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List</title>
</head>
<body>
 <%
        List<TodoApp> todoList = (List)request.getAttribute("todoList");
 %>
 <% for(TodoApp todoApp : todoList){  %>
       <h4><%=todoApp.getTodo()%></h4>
       <label>期限 <%=todoApp.getTimeLimit()%><br>
       <a href="Update?<%=Parameters.Todo_Id %>=<%= todoApp.getId() %>">todoを更新する</a>
       <a href="Delete?<%=Parameters.Todo_Id %>=<%= todoApp.getId() %>">todoを削除する</a>
 <% } %>


<form action="Main" method="post">
    <label>Todo: </label><input type="text" name="<%=Parameters.Todo%>"><br>
    <label>期限: </label><input type="date" name="<%=Parameters.Time_Limit%>"> <br>
    <input type="submit" value="Todoを登録する">
</form>

</body>
</html>