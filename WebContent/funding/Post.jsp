<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post</title>
<script>
	document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("name").addEventListener("blur", checkName);
    document.getElementById("postname").addEventListener("blur", checkPostName);
    document.getElementById("amount").addEventListener("blur", checkAmount);
    document.getElementById("expdate").addEventListener("blur", checkExpdate);
    document.getElementById("content").addEventListener("blur", checkContent);
});
	function checkName() {
        let theName = document.getElementById("name").value;
        let theNameLen = theName.length;
        if (theNameLen == "") {
            document.getElementById("msgName").innerHTML = "<img src='imgs/error.jpg'>不可空白"
        } else if (theNameLen < 2) {
            document.getElementById("msgName").innerHTML = "<img src='imgs/error.jpg'>至少輸入兩個字"
        } else if (theNameLen >= 2) {
            let re = /^[\u4E00-\u9FFF]{2,}$/;
            if (re.test(theName)) {
                document.getElementById("msgName").innerHTML = "<img src='imgs/check.jpg'>"
            } else {
                document.getElementById("msgName").innerHTML = "<img src='imgs/error.jpg'>請輸入中文"
            }
        }
    }

	function checkPostName(){
		let thePostName = document.getElementById("postname").value;
		if (thePostName == "") {
            document.getElementById("msgPostName").innerHTML = "<img src='imgs/error.jpg'>不可空白"
        } else{
        	document.getElementById("msgPostName").innerHTML = "<img src='imgs/check.jpg'>"
        }
	}

	function checkAmount(){
		let theAmount = document.getElementById("amount").value;
		let theAmountLen = theAmount.length;
		if (theAmount == "") {
            document.getElementById("msgAmount").innerHTML = "<img src='imgs/error.jpg'>不可空白"
        } else if(theAmountLen <= 5){
        	document.getElementById("msgAmount").innerHTML = "<img src='imgs/error.jpg'>請大於五位數"
        } else if(theAmountLen > 5){
        	let re = /^[0-9]{5,}$/;
        	if(re.test(theAmount)){
        		document.getElementById("msgAmount").innerHTML = "<img src='imgs/check.jpg'>"
        	} else {
        		document.getElementById("msgAmount").innerHTML = "<img src='imgs/error.jpg'>只能輸入數字"
            }
        }
	}

	function checkExpdate(){
		let theExpdate = document.getElementById("expdate").value;
		if (theExpdate == "") {
            document.getElementById("msgExpdate").innerHTML = "<img src='imgs/error.jpg'>不可空白"
        } else{
        	document.getElementById("msgExpdate").innerHTML = "<img src='imgs/check.jpg'>"
        }
	}

	function checkContent(){
		let theContent = document.getElementById("content").value;
		if (theContent == "") {
            document.getElementById("msgContent").innerHTML = "<img src='imgs/error.jpg'>不可空白"
        } else{
        	document.getElementById("msgContent").innerHTML = "<img src='imgs/check.jpg'>"
        }
	}


</script>
</head>
<body>
<jsp:include page="/funding/top.jsp" />




<H1 style="text-align:center">提案</H1>
<div style="width:800px;margin-left:350px">
<form method="POST" action="<c:url value='/funding/postInsert.do' />"
	  id="postInsert" >
<div style="background-color:#98E294;border-radius:20px;padding-left:20px;padding-top:30px">
<label>主題:</label>
<input type="text" name="postname" style="width: 180px;" id="postname">
<span id="msgPostName"></span>
<br><br>

<label>提案人:</label>
<input type="text" name="name" style="width: 180px;" id="name">
<span id="msgName"></span>
<br><br>

<label>專案金額:</label>
<input type="text" name="amount" style="width: 180px;" id="amount">
<span id="msgAmount"></span>
<br><br>


<label>到期日:</label>
<input type="date" name="expdate"   style="width: 180px;" id="expdate">
<span id="msgExpdate"></span>
<br><br>
</div>
<br>
<div style="background-color:#A5F4EA;border-radius:20px;padding-left:20px;padding-top:30px">
<h3>專案介紹:</h3><br>
<span id="msgContent"></span><br>
<textarea cols="100" rows="15" name="content" id="content">
　輸入你想要寫的內容...
</textarea>
<br><br>

<input style="font-size:25px;margin-left:350px" type="submit" value="送出">
</div>




</form>
</div>
</body>
</html>