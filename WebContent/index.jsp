<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<h1>SIMPLE WEB-KAKEIBO</h1>
		</div>
		<div id="jb-content">

			<img src="img/piggybank.jpg" alt="My Image" width="580">
		</div>
		<div id="jb-sidebar">
			<h2>MENU</h2>
			<ul>
				<li><a href="SelectServlet">Fullview page</a></li>
				<li><a href="insert.jsp">Insert page</a></li>


			</ul>
			<h3>MEMO</h3>
			<ul>
			<li>目標金額30万円節約</li>
			</ul>

		</div>
		<div id="jb-footer">
			<p>Copyright © 2019 Shin</p>
		</div>
	</div>
</body>
</html>