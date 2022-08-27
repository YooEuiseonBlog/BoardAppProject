<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>
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
		
		$("#post-btn").on("click", function(){
			location.href="/board/post"
		});	
	});
</script>
</head>
<body>
<p>BoardList</p>
<button type="button" id="post-btn">게시글쓰기</button><br/>
<c:forEach items="${boardList }" var="board">
	${board }<br/>
</c:forEach>
</body>
</html>