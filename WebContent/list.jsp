<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="web.Kakeibo"%>

<%
	//スコープからデータを受け取る、キャストする必要がある
	ArrayList<Kakeibo> list = (ArrayList<Kakeibo>) session.getAttribute("itiran");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
<
style>table {
	border-collapse: separate;
	border-spacing: 1px;
	text-align: center;
	line-height: 1.5;
	margin: 20px 10px;
}

th {
	width: 155px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #fff;
	background: #ce4869;
}

td {
	width: 155px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #eee;
}
</style>

</head>
<body>
	<table>
		<thead>
			<tr>
				<th>管理番号</th>
				<th>収入</th>
				<th>支出</th>
				<th>コメント</th>
				<th>UPDATE</th>
				<th>DELETE</th>
				<th>DATE</th>
			</tr>
		</thead>
		<tbody>
			<%
			//	for (int i = 0; i < list.size(); i++) {
					for(Kakeibo kkb:list ){
			%>
			<tr>
				<td>項目.<%=kkb.getId()%></td>
				<td><%=kkb.getIncome()%>円</td>
				<td><%=kkb.getExpense()%>円</td>
				<td><%=kkb.getDetails()%></td>
				<td><a href="update.jsp?id=<%=kkb.getId()%>">変更</a></td>
				<td><a href="DeleteServlet?id=<%=kkb.getId()%>">削除</a></td>
				<td><%=kkb.getDate()%></td>

</tr>
			<%
				}
			%>
		</tbody>
	</table>


</body>
</html>