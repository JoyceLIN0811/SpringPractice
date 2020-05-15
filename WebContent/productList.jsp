<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:set var="AppName" value="${SYSTEM.systemName}" scope="application" />
<title>index</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/business-casual.css" rel="stylesheet">


<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<style>
#pet {
	font-size: 10px;
}

.table tbody tr td {
	vertical-align: middle;
}

.custom {
	max-width: 1010px;
}

.custom2 {
	max-width: 200px;
}

.font1 {
	font-size: 15px;
}
</style>
</head>
<body>
	<c:set var="funcName" value="IND" scope="session" />
	<jsp:include page="${pageContext.request.contextPath}/fragment/topShop.jsp" />

	<div class="container">
		<div class="box">
			<div class="col-lg-12">
				<!--         			---------------------------------- -->
				<section class="container custom">
					<div class="row">
						<!-- 		左邊的清單 -->
						<div class="col-md-3 custom2">
							<div class="list-group sticky-top mt-3">
								<a href="<c:url value='/shopOnlion.jsp'/>"
									class="list-group-item list-group-item-action active "
									data-toggle="list">重新查詢</a> <a href="<c:url value='/index.jsp'/>"
									class="list-group-item list-group-item-action"
									data-toggle="list">回首頁</a> <a href=<c:url value='/pet_showCartContent.jsp' />
									class="list-group-item list-group-item-action"
									data-toggle="list">購物車</a> <a href="#"
									class="list-group-item list-group-item-action">其他用品</a> <a
									href="#"
									class="list-group-item list-group-item-action disabled"
									tabindex="-1" aria-disabled="true">限時下殺</a>
							</div>
						</div>
						<!-- --------------------------------------------------此處為商品------------------------------------------------------------------------------------------- -->
						<div class="col-md-9" id='pet'>
							<div class="tab-content">
								<div class="tab-pane active" id="pane-1" role="tabpanel">
									<div class="row">

										<c:forEach var="mem" items="${typeList}">
											<%--items藥用EL，不然會被當成逗點隔開的識別字串 --%>
											<table class="table font1">
												<tr>
													<td>${mem.getPetId()}</td>
													<td>價格:${mem.getPrice()}元</td>
													<td align='center'>${mem.getFileName()}</td>
													<td align='center'><img width='100'
														src="data:image/jpg;base64,${mem.getBiPhoto()}"></td>
													<td align='center'>${mem.getDescription()}</td>
													<td align='center'>
														<FORM action="BuyPetProduct.do" method="POST">
															購買數量:<select name='amount'>
																<option value="1">1</option>
																<option value="2">2</option>
																<option value="3">3</option>
															</select> <Input type='hidden' name='PetId'
																value='${mem.getPetId()}'> <Input type='hidden'
																name='filename' value='${mem.getFileName()}'> <Input
																type='hidden' name='categoryId'
																value='${mem.getCategoryId()}'> <Input
																type='hidden' name='description'
																value='${mem.getDescription()}'> <Input
																type='hidden' name='discount'
																value='${mem.getDiscount()}'> <Input
																type='hidden' name='price' value='${mem.getPrice()}'>
																

															<Input  class="btn btn-dark" type='submit' value='購買'>
														</FORM>
													</td>
												</tr>
											</table>
										</c:forEach>
										<!-- --------------------------------------------------商品結束------------------------------------------------------------------------------------------- -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!--         			---------------------------------- -->
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>
	<!-- Flexslider -->
	<script src="js/jquery.flexslider-min.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>
</body>
</html>