<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員登入</title>
</head>
<body style="background-color: lightblue">

	<h2>會員登入</h2>
	<form action="<c:url value="#" />" method="post">
		<table>
			<tr>
				<td>Username :	</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password : 	</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<button  type="submit" name="login">登入</button>
	</form>



	<hr>
	<a href="<c:url value='/index.jsp' />">回首頁</a>

</body>
</html>