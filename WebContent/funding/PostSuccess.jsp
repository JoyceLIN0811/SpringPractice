<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PostSuccess</title>
</head>
<body>
<jsp:include page="/funding/top.jsp" />
<br>
<h1>新增成功 , 歡迎${post.name}</h1>
<h1>你的提案主題為: ${post.postname}</h1>
</body>
</html>