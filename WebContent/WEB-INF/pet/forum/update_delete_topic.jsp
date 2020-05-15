<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layout/online">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css"
	rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />
<head>
<script type="text/javascript">
	function confirmDelete() {
		if (confirm("確定刪除此文章 ? ")) {
			document.forms[0].action = "update_delete_topic?topicId=${mytopic_content.topicId}&action=delete";
			document.forms[0].method = "POST";
			document.forms[0].submit();
		} else {

		}
	}

	function UpdateTopic() {
		if (confirm("確定修改此文章 ? ")) {
			document.forms[0].action = "update_delete_topic?topicId=${mytopic_content.topicId}&action=update";
			document.forms[0].method = "POST";
			document.forms[0].submit();
		} else {

		}
	}
</script>
<title>Update_Delete Topic</title>
</head>
<body>
	<main layout:fragment="content">
		<article class="container" style="padding: 3% 0 2%;">
			<header class="row">
				<div class="col s12">
					<blockquote class="flow-text left">修改文章</blockquote>
					<blockquote class="flow-text right">
						<a href="<c:url value='forum' />" style="color: black">回討論區首頁</a>
					</blockquote>
				</div>
			</header>
			<section>

				<c:set var="title" value='${mytopic_content.title}' />
				<c:set var="categoryId" value='${mytopic_content.categoryId}' />
				<c:set var="content" value='${mytopic_content.content}' />
				<form action="<c:url value='update_delete_topic'/>"
					method="post">

					<div class="row">
						<div class="col s12">
							<p>
								<input value="1" name="categoryId" class="with-gap" type="radio"
									id="life" required="required"
									<c:if test="${mytopic_content.categoryId == '1'}">checked="checked"</c:if> />
								<label for="life">生活</label>
							</p>
							<p>
								<input value="2" name="categoryId" class="with-gap" type="radio"
									id="knowledge" required="required"
									<c:if test="${mytopic_content.categoryId == '2'}">checked="checked"</c:if> />
								<label for="knowledge">資訊</label>
							</p>
							<p>
								<input value="3" name="categoryId" class="with-gap" type="radio"
									id="news" required="required"
									<c:if test="${mytopic_content.categoryId == '3'}">checked="checked"</c:if> />
								<label for="news">新聞</label>
							</p>
							<p>
								<input value="4" name="categoryId" class="with-gap" type="radio"
									id="question" required="required"
									<c:if test="${mytopic_content.categoryId == '4'}">checked="checked"</c:if> />
								<label for="question">發問</label>
							</p>

							<p>
								<input value="5" name="categoryId" class="with-gap" type="radio"
									id="adopt" required="required"
									<c:if test="${mytopic_content.categoryId == '5'}">checked="checked"</c:if> />
								<label for="adopt">認養</label>
							</p>
							<p>
								<input value="6" name="categoryId" class="with-gap" type="radio"
									id="other" required="required"
									<c:if test="${mytopic_content.categoryId == '6'}">checked="checked"</c:if> />
								<label for="other">其他</label>
							</p>
						</div>
					</div>
					<div class="row">
						<div class="col s12">
							<label>Title: <input type="text" name="title"
								maxlength="32" data-length="32" required="required"
								value="${mytopic_content.title}" />
							</label>
							<!-- 							<label>Title: <input type="text" name="title" -->
							<!-- 								maxlength="32" data-length="32" required="required" -->
							<%-- 								value="${mytopic_content.title}" /> --%>
							<!-- 							</label> -->
						</div>
					</div>
					<div class="row">
						<div class="col s12">
							<label>Content: <textarea name="content"
									class="materialize-textarea" maxlength="1024"
									required="required" cols="40" rows="20">${mytopic_content.content}</textarea>
							</label>
							<!-- 							<label>Content: <textarea name="content" -->
							<!-- 									class="materialize-textarea" maxlength="1024" -->
							<%-- 									required="required" cols="40" rows="20">${mytopic_content.content}</textarea> --%>
							<!-- 							</label> -->
						</div>
					</div>
					<input type="hidden" name="username"
						value="${mytopic.getUsername()}" /> <input type="hidden"
						name="username" value="${mytopic.getUsername()}" />
					<div class="row">
						<div class="col s12 center">


							<Input class="btn waves-effect waves-light btn-large"
								type="button" name="update" value="修改文章" onclick='UpdateTopic()' />
							<Input class="btn waves-effect waves-light btn-large"
								type="button" name="delete" value="刪除文章"
								onclick="confirmDelete()" />
						</div>
					</div>
				</form>
			</section>
		</article>
	</main>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
</body>
</html>
