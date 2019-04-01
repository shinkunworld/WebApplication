<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<form action="InsertServlet" method="POST">
Details<input type="text" name="details"><br>
Remark<input type="text" name="remark"><br>
Payment<br>
<input type="radio" name="payment" value="amount">現金
<input type="radio" name="payment" value="card">カード
<input type="radio" name="payment" value="point">ポイント

 
<br>
Amount<input type="text" name="amount"><br>

<input type="submit" value="登録">
</form>
</body>
</html>