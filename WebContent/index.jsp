<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통장만들기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
	<h2>회원가입</h2>
	 <form action=""></form>
	 
	 <form id = "account_form" action="<%=request.getContextPath()%>/account.do">
	 	입금액<input type="text" name="money" /> <br/>
	 	
	 	<input type="submit" id="btn" value = "전송">
	
	</form>
</div>
<script>
$('#account_form').submit(function(){
	alert('통장테스트');
	
});
</script>
</body>
</html>