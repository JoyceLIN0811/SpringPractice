<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
<jsp:include page="/funding/top.jsp" />


<table class="table">
  <thead class="thead-dark">
    <tr style="font-size:25px">
      <th scope="col">序號</th>
      <th scope="col">主題</th>
      <th scope="col">提案人</th>
      <th scope="col">金額</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${posts}" var="posts" varStatus="s">
    <tr>
      <th scope="row">${posts.postno}</th>
      <td>${posts.postname}</td>
      <td>${posts.name}</td>
      <td>${posts.amount}</td>
      
      
  	  <td>
  	 	<form action="PostSearch2" method="post" style="float: left" >
  	  	<input type="hidden" name="postno" value="${posts.postno}" >
		<input class="btn btn-primary" type="submit" name="send" value="修改">
		</form>
		
		<form action="deletepostno" method="post"  >
		<input type="hidden" name="postno" value="${posts.postno}" >
		<input class="btn btn-primary" type="submit" name="send" value="刪除">
		</form>
	</td>
    </tr>
    </c:forEach>
  </tbody>
</table>


</body>
</html>