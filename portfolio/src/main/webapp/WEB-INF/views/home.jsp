<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		var result = '${result}';
		
		if(result === 'removeFail') {
			alert("회원 삭제 실패했습니다.");
		}else if(result === 'removeSuccess'){
			alert("회원 삭제가 성공하였습니다.");
		}
		
		$('#login-btn').on("click", function(){
			location.href="/login";
		});
		
		$('#logout-btn').on("click", function(){
			location.href="/logout";
		});
		
		$('#edit-btn').on("click", function(){
			location.href="/edit";
		});
		
		$('#del-btn').on("click", function(){
			location.href="/delete";
		});
		
		$('#list-btn').on("click", function(){
			location.href="/board/list";
		});
	})
</script>
</head>
<body>
	<p>Welcome Page</p>
	<p>${sessionId }</p>
	<p>${sessionNickname }</p>
	<button type="button" id="${!empty sessionId? 'logout-btn' : 'login-btn' }">${!empty sessionId? "로그아웃":"로그인"  }</button>
	<c:if test="${!empty sessionId }">
		<button type="button" id="edit-btn">회원수정</button>
		<button type="button" id="del-btn">회원삭제</button>
		<button type="button" id="list-btn">글 리스트</button>
	</c:if>
</body>
</html>