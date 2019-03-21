<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>change</title>
</head>
<body>
	管理番号:<%=id%><br>
	<form action="UpdateServlet" method="POST">
		ID<input type="hidden" name="id" value="<%=id%>"><br>

	INCOME<input type="text" name="income"><br>
		 EXPENSE<input type="text" name="expense"><br>
	DETAILS<input type="text" name="details"><br>
		<input type="submit" value="変更"><br>
	</form>
</body>
</html>