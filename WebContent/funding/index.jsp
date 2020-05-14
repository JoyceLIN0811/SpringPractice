<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<style type="text/css">

</style>
</head>
<body>
<jsp:include page="/funding/top.jsp" />
<div style="background-color:#FEED7E;font-size:25px;padding-left:300px">
<p>
歡迎蒞臨寵物募資平台，我們希望可以幫助更多的流浪動物，
<p>只要加入會員都可以刊登募資計畫，
<p>此計畫限制至少募資五位數以上、最多長達一個月最少10日的募資計畫。
<p>歡迎有能力的人幫助更多的寵物收容所!
</div>




<div style="width:1000px;margin-left:250px">
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active" >
      <img src="${pageContext.request.contextPath}/imgs/1.jpg" class="d-block w-100" style="height:500px">
    </div>
    <div class="carousel-item" >
      <img src="${pageContext.request.contextPath}/imgs/2.jpg" class="d-block w-100" style="height:500px" >
    </div>
    <div class="carousel-item" >
      <img src="${pageContext.request.contextPath}/imgs/3.jpg" class="d-block w-100" style="height:500px">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
</body>
</html>