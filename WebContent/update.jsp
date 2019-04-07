<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>

<style>
#jb-container {
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
</style>
</head>
<body>
	<div id="jb-container">

		<div id="jb-content">
			管理番号:<%=id%><br>
			<form action="UpdateServlet" method="POST">
			<input type="hidden" name="id" value="<%=id%>"><br>
内容<br><input type="text" name="details"value="Ex)食費"onfocus="this.value=''"><br> <br>
				備考<br><input type="text" name="remark"value="Ex)牛丼"onfocus="this.value=''"><br> <br>
				決済方法<br> 
				<input type="radio" name="payment" value="現金">現金
				 <input
					type="radio" name="payment" value="カード">カード 
					<input
					type="radio" name="payment" value="ポイント">ポイント <br><br>
				金額<br><input type="text" name="amount"value="Ex)2000"onfocus="this.value=''"><br><br> <input
					type="submit" value="登録">
			</form>
		</div>
		<div id="jb-footer">
			<div style="text-align:center"><p>Copyright © 2019 Shin</p></div>
		</div></div>
</body>
</html>