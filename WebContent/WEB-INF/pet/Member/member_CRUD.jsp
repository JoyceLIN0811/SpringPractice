<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員專區</title>
</head>
<body style="background-color: lightblue">

<h2>會員專區</h2>

<h3>會員資料</h3>

<div style="border: 1px solid black; padding: 10px">
	<table>
				<tr>
					<td>Username :	</td>
					<td></td>

				</tr>
				<tr>
					<td>Password :	</td>
					<td></td>

				</tr>
				<tr>
					<td>Email :	</td>
					<td></td>

				</tr>
				<tr>
					<td>Gender</td>
					<td></td>

				</tr>
				<tr>
					<td>Birthday :	</td>
					<td></td>
				</tr>
				<tr>
					<td>Age :	</td>
					<td></td>
				</tr>
				<tr>
					<td>Address :	</td>
					<td></td>

				</tr>
				<tr>
					<td>Phone :	</td>
					<td></td>

				</tr>
				<tr>
					<td>PetType :	</td>
					<td></td>

				</tr>
				<tr>
					<td>MemberImage</td>
					<td></td>

				</tr>				
			</table>

</div>
	<br>
	<button  type="button" name="alter">修改會員資料</button>
<hr>
<a href="<c:url value='/index.jsp' />" >回首頁</a>

</body>
</html>