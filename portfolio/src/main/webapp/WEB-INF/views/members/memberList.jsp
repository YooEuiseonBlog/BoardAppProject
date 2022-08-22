<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<p>Member List</p>
<c:forEach items="${memberList }" var="member">
	${member }<br/>
</c:forEach>
</body>
</html>