<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.co.aforce.beans.LoginBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">

</head>
<body>
<form action="/LoginProject/loginServlet" method="post">


		 ${Emsg}


	<p>
	<a>username</a><input type="text" name="username">
	</p>

	<p>
	<a>password</a><input type="password" name="password">
	</p>


	<input type="submit" value="ログイン">

</form>

</body>
</html>