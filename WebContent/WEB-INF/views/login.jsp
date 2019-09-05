<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>은행관리시스템</title>
</head>
<body>
<div>
	<h2>로그인</h2>
	 <form id="login" action="">
	 	아이디<input type="text" /> <br/>
	 	비밀번호<input type="text" /> <br/>
	 	<input type="submit" value = "전송">
	</form>
</div>
</body>
<script>
$('#login').submit(function(){
	alert('성공');
});
</script>

</html>