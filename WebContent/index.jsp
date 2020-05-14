<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>寵毛網</title>
<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/fragment/topcss/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/fragment/topcss/css/business-casual.css"
	rel="stylesheet">
<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">
<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">
</head>
<body style= "font-family: 微軟正黑體">
<%-- 	<c:set var="funcName" value="IND" scope="session" /> --%>
	<jsp:include page="/WEB-INF/pet/fragment/top.jsp" />
	
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
					<div id="carousel-example-generic" class="carousel slide">
						<!-- Indicators -->
						<ol class="carousel-indicators hidden-xs">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"></li>
							<li data-target="#carousel-example-generic" data-slide-to="4"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img class="img-responsive img-full"
									src="${pageContext.request.contextPath}/images/slider1.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="img-responsive img-full"
									src="${pageContext.request.contextPath}/images/slider2.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="img-responsive img-full"
									src="${pageContext.request.contextPath}/images/slider3.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="img-responsive img-full"
									src="${pageContext.request.contextPath}/images/slider4.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="img-responsive img-full"
									src="${pageContext.request.contextPath}/images/slider5.jpg"
									alt="">
							</div>
						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span class="icon-prev"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="icon-next"></span>
						</a>
					</div>
					<h2 class="brand-before">
						<small>Welcome to</small>
					</h2>
					<h1 class="brand-name">OUR WEB</h1>
					<hr class="tagline-divider">
					<h2>
						<small>By <strong>Team 2</strong>
						</small>
					</h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						About us <strong></strong>
					</h2>
					<hr>
					<img class="img-responsive img-border img-left"
						src="${pageContext.request.contextPath}/images/logo.png" alt="">
					<hr class="visible-xs" >
					<h3>不知何時開始，寵物不再只是顧家、抓老鼠、防小偷入侵的小小警衛</h3>
					<h3>「毛小孩」是牠們的新名字，在繁忙的生活裡，他們不僅僅是成為最療癒你的那一顆星星，也是無可取代的家人</h3>
					<h3>我們希望這些毛小孩在陪伴家人的時間裡都能開開心心，健健康康的，因此我們提供各項服務，滿足不同需求</h3>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						 <strong>《《 寵毛網將為您提供以下的服務 》》</strong>
					</h2>
					<hr>
					<h4>1. 網路商城</h4>
					<p>除了滿滿的愛之外，讓毛孩吃更加安全健康的食品、用更有質感的產品、玩更有意思的玩具、穿更暖活的衣服走遍各地，寵物用品不再僅僅只是日用品，而是為生活帶來更多美好與愛。</p>
					<p>在這裡每一項產品，都以最嚴苛的標準、以及長期使用後的心得，遴選出對毛小孩最好、最安全的產品，堅持只賣好東西！為的就是讓毛小孩都能夠用得安心。</p>

					<h4>2. 寵物服務</h4>
					<p>在這繁忙的時代，當你的毛小孩有需要時，我們提供寵物寄宿、寵物保姆、溜狗保姆、寵物日托、寵物美容、寵物計程車的預約服務。</p>
					<p>提供值得信賴與有愛的寵物保姆來溜達毛孩們，或安全的日托環境，給予毛孩周全的照顧，輕鬆找到安全、實惠的寵物住宿，讓毛孩得到最好的照料。</p>

					<h4>3. 專屬討論區――想要了解毛孩的想法或身體狀況? 想增進和毛孩之間的關係?</h4>
					<p>想知道最新、最正卻的營養、保健知識，還有如何正確地與毛小孩互動?</p>
					<p>在這裡你不只可以找到網友與家中毛孩相處的心情、情感、生活分享以及正確、健康的飼育觀念，協助你找出問題的關鍵原因，提出適當方法協助您有效解決一切有關毛孩的問題。</p>

					<h4>4. 選秀活動――在網絡發達的現代，每個人都有15分鐘的成名機會，但誰說只能局限於人呢?</h4>
					<p>現在家中的毛小孩也有機會成為網紅，在網路平台上發光發熱。只要上傳毛孩的照片、影片及介紹，就有機會透過投票活動爆紅，一舉成名</p>
					<p>我們將提供優勝者豐富的獎品，此外分享活動的會員還有機會抽中大獎喔！</p>

					<h4>5.募資平台</h4>
					<p>一個專屬毛孩的群眾集資平台，可以刊登各式各樣的創意計畫，不論是幫助流浪動物的計畫，或是研發各項產品，歡迎每一位喜歡毛孩、想為毛孩奉獻心力的人們。對於支持者們來說，可以透過贊助這些最新、最快、最與眾不同的商品或美好體驗、支持他們的夢想實現。</p>
					<p>對於想發起計畫的人來說，確定你的計畫目標後，只要在募資期限內達到目標，你就能從支持者那裡獲得資金實現夢想！</p>

				</div>
			</div>
		</div>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/fragment/topcss/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/fragment/topcss/js/bootstrap.min.js"></script>

	<!-- Script to Activate the Carousel -->
	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		})
	</script>

</body>
</html>