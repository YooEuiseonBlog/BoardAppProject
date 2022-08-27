<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>posting page</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		$('#cancel-btn').on("click", function(){
			location.href="/board/list/1"
		});
	});
</script>
<c:set var="nickname" value="${!empty readOk? board.nickname : sessionNickname}"/>
<c:set var="author" value="${!empty readOk? board.author : sessionId}"/>
</head>
<body>
<p>${!empty readOk? 'Post Page' : 'Read Page' }</p>
<form action="/board/post" method="post">
	<div class="form-group">
	<input type="text" id="nickname" name="nickname" value="${nickname }" readonly/><br/>
	<input type="hidden" id="author" name="author" value="${author }" readonly/>
	<input type="text" id="title" name="title" value="${board.title }"/><br/>
	<textarea rows="10" cols="30" id="contents" name="contents">${board.contents }</textarea><br/>
	</div>
	<button type="submit">${!empty readOk? '수정' : '등록' }</button>
	<button type="button" id="cancel-btn">취소</button>
</form>
</body>
</html>