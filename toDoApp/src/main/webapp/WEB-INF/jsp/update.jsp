<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.TodoApp, model.Parameters" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update List</title>
</head>

<body>
<%
TodoApp todoApp = (TodoApp) request.getAttribute("todoApp");
%>

<form action="Update" method="post">
	<label>Todo: </label><input type="text" name="<%=Parameters.Todo %>" value="<%=todoApp.getTodo()%>"><br>
    <label>Limit: </label><input type="date" name="<%=Parameters.Time_Limit %>" value="<%=todoApp.getTimeLimit()%>"> <br>
    <input type="hidden" name="<%=Parameters.Todo_Id %>" value="<%=todoApp.getId() %>">
    <input type="submit" value="Todoを更新する">
</form>
</body>
</html>