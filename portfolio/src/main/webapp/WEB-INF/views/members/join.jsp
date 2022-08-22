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
<p>${!empty sessionId? "회원수정 페이지":"회원가입 페이지" }</p>
<c:set var="checkReadOnly" value="${!empty sessionId? 'readonly':'' }"/>
<c:set var="btnTitle" value="${!empty sessionId? '회원수정' : '회원등록'}"/>
<c:set var="toAction" value="${!empty sessionId? '/edit': '/join' }"/>
<form method="post" action="${toAction }">
	<div class="form-group">
		<label for="userid">아이디: </label>
		<input type="text" id="userid" name="userid" placeholder="아이디를 입력해주세요." value="${member.userid }" ${checkReadOnly } /><br/>
		<label for="userpwd">비밀번호: </label>
		<input type="password" id="userpwd" name="userpwd" placeholder="비밀번호를 입력해주세요." value="${member.userpwd }"/><br/>
		<label for="username">이름: </label>
		<input type="text" id="username" name="username" placeholder="이름을 입력해주세요." value="${member.username }" ${checkReadOnly }/><br/>
		<label for="nickname">닉네임: </label>
		<input type="text" id="nickname" name="nickname" placeholder="닉네임을 입력해주세요." value="${member.nickname }"/><br/>
		<label for="phone_num1">전화번호: </label>
		<input type="text" id="phone_num1" name="phone_num1" value="${member.phone_num1 }"/>
		- <input type="text" id="phone_num2" name="phone_num2" value="${member.phone_num2 }"/>
		- <input type="text" id="phone_num3" name="phone_num3" value="${member.phone_num3 }"/><br/>
		<label for="email_id">이메일: </label>
		<input type="text" id="email_id" name="email_id" placeholder="아이디" value="${member.email_id }"/>
		@ <input type="text" id="email_domain" name="email_domain" placeholder="도메인" value="${member.email_domain}"/><br/>
		<label for="user_addr">주소: </label>
		<input type="text" id="user_addr" name="user_addr" placeholder="주소를 입력해주세요." value="${member.user_addr }"/><br/>		
	</div>
	<button type="submit">${btnTitle }</button>
	<button type="reset">취소</button>
</form>
</body>
</html>