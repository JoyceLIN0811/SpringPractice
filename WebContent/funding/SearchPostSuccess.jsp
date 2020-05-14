<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SearchPostSuccess</title>
</head>
<body>
<jsp:include page="/funding/top.jsp" />


<div style="width:800px;margin-left:350px">
<div style="background-color:#98E294;border-radius:20px;padding-left:20px;padding-top:30px">
<h1>主題:${PBean.postname}</h1>
<br><br>

<h4>提案人:${PBean.name}</h4>
<br><br>

<h4>專案金額:${PBean.amount}</h4>
<br><br>


<h4>到期日:${PBean.expdate}</h4>
<br><br>
</div>
<br>
<div style="background-color:#A5F4EA;border-radius:20px;padding-left:20px;padding-top:30px">
<h1>專案介紹:</h1><br>
<h4>${PBean.content}</h4>
<br><br>
</div>
<br>
<span style='margin-left:350px;font-size: 25px'> 
<a style="color:#000000" href="<c:url value='/funding/GetAll.do' />">上一頁</a>
</span>
<br><br>



</div>
</body>
</html>