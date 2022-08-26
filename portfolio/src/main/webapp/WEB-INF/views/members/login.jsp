<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		var result = '${result}';
		var processName = '${processName}';
		
		if(result === 'fail') {
			alert(processName+" 실패를 하였습니다.");
		}else if(result === 'success') {
			alert(processName+" 성공을 하였습니다.");
		}
		
		$("#joinBtn").on("click", function(){
			location.href="/join"
		});
		
		$("#listBtn").on("click", function(){
			location.href="/memberList"
		});
	});
</script>
</head>
<body>
	<p>Login Page</p>
	
	<form action="/login" method="post">
		<div class="form-group">
		<label for="userid">아이디 :</label>
		<input type="text" id="userid" name="userid"/>
		<br/>
		<label for="userpwd">비밀번호 :</label>
		<input type="text" id="userpwd" name="userpwd"/>
		</div>		
		<button type="submit">로그인</button>
		<button type="button" id="joinBtn">회원가입</button>
		<button type="button" id="listBtn">회원목록</button>
	</form>
</body>
</html>