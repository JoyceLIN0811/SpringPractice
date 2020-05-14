<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GetAll</title>
<style>

</style>
</head>
<body>

<jsp:include page="/funding/top.jsp" />


<c:forEach items="${posts}" var="posts" varStatus="s">
<div style="float:left;margin:30px;margin-left:55px;width: 18rem;" class="card">
  <img src="${pageContext.request.contextPath}/imgs/1.jpg" class="card-img-top" >
  <div  class="card-body">
    <h2 class="card-title">主題:${posts.postname}</h2>
    <p class="card-text">提案人:${posts.name}</p>
    <p class="card-text">金額:${posts.amount}</p>
    <p class="card-text">到期日:${posts.expdate}</p>
    
    <form action="PostSearch.do" method="post" >
    	<input type="hidden" name="postno" value="${posts.postno}" >
		<input class="btn btn-primary" type="submit" name="send" value="查看">
	</form>
  </div>
</div>
</c:forEach>



</body>
</html>