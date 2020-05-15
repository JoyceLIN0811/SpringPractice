<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員註冊</title>

</head>
<body style="background-color: lightblue">

<h2>會員註冊</h2>

	<form action="<c:url value="#" />" method="post">

		<div style="margin: 20px auto">
			<table>
				<tr>
					<td>Username :	</td>
					<td><input type="text" name="username" /></td>

				</tr>
				<tr>
					<td>Password :	</td>
					<td><input type="password" name="password" /></td>

				</tr>
				<tr>
					<td>Email :	</td>
					<td><input type="text" name="email" /></td>

				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="radio" name="gender" value="M" />Man <input
						type="radio" name="gender" value="F" />Woman</td>

				</tr>
				<tr>
					<td>Birthday :	</td>
					<td><input type="date" name="bday" /></td>
					<td><font color='red' size="-1">${errorMsg.mBbday}</font></td>
				</tr>
				<tr>
					<td>Age :	</td>
					<td><input type="text" name="age" /></td>
					<td><font color='red' size="-1">${errorMsg.mAge}</font></td>
				</tr>
				<tr>
					<td>Address :	</td>
					<td><input type="text" name="address" /></td>

				</tr>
				<tr>
					<td>Phone :	</td>
					<td><input type="text" name="phone" /></td>

				</tr>
				<tr>
					<td>PetType :	</td>
					<td><input type="text" name="petType" /></td>

				</tr>
				<tr>
					<td>MemberImage</td>
					<td><input type="file" name="memberImage" /></td>

				</tr>
				<tr>
					<td><input type="submit" name="Submit" /></td>
				</tr>

			</table>
	</form>
	<hr>

<a href="<c:url value='/index.jsp' />" >回首頁</a>

	</div>
</body>
</html>