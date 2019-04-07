<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="model.Kakeibo"%>

<%
	//スコープからデータを受け取る、キャストする必要がある
	ArrayList<Kakeibo> list = (ArrayList<Kakeibo>) session.getAttribute("itiran");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Full VIEW</title>

<style>
<
style>#jb-container {
	width: 940px;
	margin: 10px auto;
	padding: 20px;
	border: 1px solid #bcbcbc;
}



#jb-content {
	width: 900px;
	padding: 20px;
	margin-bottom: 20px;
	float: left;
	border: 1px solid #bcbcbc;
	margin-bottom: 20px;
	float: left;
}

#jb-footer {
	clear: both;
	padding: 5px;
	border: 1px solid #bcbcbc;
	a: link{ color: blue;
	text-decoration: none;
}

@media ( max-width : 480px ) {
	#jb-container {
		width: auto;
	}
	#jb-content {
		float: none;
		width: auto;
	}
	#jb-footer {
		float: none;
		width: auto;
	}
}

a:visited {
	color: purple;
	text-decoration: none;
}

a:hover {
	color: red;
	text-decoration: underline;
}

a:active {
	color: white;
	background-color: green;
}

}
table {
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
	background: #ffb8c6;
}

td {
	width: 155px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #f0fff0;
}


</style>

</head>
<body>

	<div id="jb-container">
		
		<div id="jb-content">
			<table>
				<thead>
					<tr>
						<th>管理番号</th>
						<th>日付</th>
						<th>内容</th>
						<th>備考</th>
						<th>決済方法</th>
						<th>金額</th>
						<th>修正項目</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Kakeibo kkb : list) {
					%>
					<tr>
						<td>項目.<%=kkb.getId()%></td>
						<td><%=kkb.getDate()%></td>
						<td><%=kkb.getDetails()%></td>
						<td><%=kkb.getRemark()%></td>
						<td><%=kkb.getPayment()%></td>
						<td><%=kkb.getAmount()%>円</td>
						<td><a href="update.jsp?id=<%=kkb.getId()%>">変更</a>
						<br>
						<a href="DeleteServlet?id=<%=kkb.getId()%>">削除</a>
						</td>

					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		<div style="text-align:center">	<a href="index.jsp">トップページへ</a></div>
		</div>

		<div id="jb-footer">
		<div style="text-align:center">	<p>Copyright © 2019 Shin</p></div>
		</div>
	</div>

</body>
</html>
