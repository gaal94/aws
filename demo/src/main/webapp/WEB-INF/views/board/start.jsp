<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ !empty sessionid }">	
		<h3>${ sessionid } 회원님 로그인 중입니다.</h3>
	</c:if>
	<h4>메뉴</h4>
	<h4><a href="boardlist">게시물리스트 보기</a></h4>
	<h4><a href="boardwrite">글쓰기</a></h4>
	<h4><a href="boardlogin">로그인</a></h4>
	<h4><a href="boardlogout">로그아웃</a></h4>
</body>
</html>