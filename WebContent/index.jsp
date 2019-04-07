<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="model.Kakeibo"%>
<!DOCTYPE html>

<html lang="ja">
<head>
<meta charset="utf-8">
<title>WEB-KAKEIBO</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
#jb-container {
	width: 940px;
	margin: 10px auto;
	padding: 20px;
	border: 1px solid #bcbcbc;
}

#jb-header {
	padding: 5px;
	margin-bottom: 20px;
	border: 1px solid #bcbcbc;
}

#jb-content {
	width: 580px;
	padding: 20px;
	margin-bottom: 20px;
	float: left;
	border: 1px solid #bcbcbc;
}

#jb-sidebar {
	width: 260px;
	padding: 20px;
	margin-bottom: 20px;
	float: right;
	border: 1px solid #bcbcbc;
}

#jb-footer {
	clear: both;
	padding: 5px;
	border: 1px solid #bcbcbc;
	a: link{ color: blue;
	text-decoration: none;
}

 @media ( max-width: 480px ) {
        #jb-container {
          width: auto;
        }
        #jb-content {
          float: none;
          width: auto;
        }
        #jb-sidebar {
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
		<div id="jb-header">
		<div style="text-align:center">		<h1>簡単ウェブ家計簿</h1></div>
		</div>
		<div id="jb-content">

			<img src="img/piggybank.jpg" alt="My Image" width="580">
		</div>
		<div id="jb-sidebar">
			<h2>MENU</h2>
			<ul>
				<li><a href="SelectServlet">一覧項目へ</a></li>
				<br>
				<li><a href="insert.jsp">家計簿記入へ</a></li>


			</ul>
			<h2>MEMO</h2>
			<ul>
			<li>塵も積もれば山となる！</li>
			<br>
			<li>目指せ！億万長者
		</li><br>
		<li>5月1日から令和!
		</li>
			</ul>

		</div>
		<div id="jb-footer">
			<div style="text-align:center">	<p>Copyright © 2019 Shin</p>
			</div>
		</div>
	</div>
</body>
</html>