<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Blog - Business Casual - Start Bootstrap Theme</title>

 <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

<style>

</style>

</head>

<body>

	<div class="brand">寵毛網商城</div>
	<div class="address-bar">新品到貨 | 飼料優惠 | 寵愛毛孩</div>

	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
				<hr>
                    <h2 class="intro-text text-center">搜尋商品
                        <strong></strong>
                    </h2>
                    <hr>
                    
                    <form action="select2.do" class="form-inline my-2 my-lg-0">
      <select name='type'>
      				<option value="1">1.狗飼料</option>
                    <option value="2">2.貓飼料</option>
      </select>
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜尋</button>
    </form>
                   
				</div>
			</div>
		</div>
	</div>
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<p>寵毛網 &hearts; For you better</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js">
	

	
	</script>

</body>

</html>