<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Page</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<p>Join Page</p>
<form method="post" action="/join">
	<div class="form-group">
		<label for="userid">아이디: </label>
		<input type="text" id="userid" name="userid" placeholder="아이디를 입력해주세요."/><br/>
		<label for="userpwd">비밀번호: </label>
		<input type="password" id="userpwd" name="userpwd" placeholder="비밀번호를 입력해주세요."/><br/>
		<label for="username">이름: </label>
		<input type="text" id="username" name="username" placeholder="이름을 입력해주세요."/><br/>
		<label for="nickname">닉네임: </label>
		<input type="text" id="nickname" name="nickname" placeholder="닉네임을 입력해주세요."/><br/>
		<label for="phone_num1">전화번호: </label>
		<input type="text" id="phone_num1" name="phone_num1"/>
		- <input type="text" id="phone_num2" name="phone_num2"/>
		- <input type="text" id="phone_num3" name="phone_num3"/><br/>
		<label for="email_id">이메일: </label>
		<input type="text" id="email_id" name="email_id" placeholder="아이디"/>
		@ <input type="text" id="email_domain" name="email_domain" placeholder="도메인"><br/>
		<label for="user_addr">주소: </label>
		<input type="text" id="user_addr" name="user_addr" placeholder="주소를 입력해주세요."/><br/>		
	</div>
	<button type="submit">회원등록</button>
	<button type="reset">취소</button>
</form>
</body>
</html>