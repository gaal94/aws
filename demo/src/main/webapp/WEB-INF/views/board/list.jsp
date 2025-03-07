<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.7.1.min.js"></script>
<script>
	$(document).ready(function() {
		
	});
</script>
</head>
<body>
	<h1>게시물 목록입니다.</h1>
	<table border="2">
		<tr><th>번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr>
		<c:forEach items="${ boardlist }" var="dto">
			<tr><td>${ dto.seq }</td><td><a href="boarddetail?seq=${ dto.seq }">${ dto.title }</a></td><td>${ dto.writer }</td><td>${ dto.viewcount }</td></tr>
		</c:forEach>		
	</table>
	<h3>페이지번호를 선택하세요.</h3>
	<%
	int total = (Integer)request.getAttribute("total");
	int totalpage = 0;
	if(totalpage % 3 == 0) {
		totalpage = total / 3;
	} else {
		totalpage = total / 3 + 1;
	}
	for(int i = 1; i <= totalpage; i++) {
	%>
		<a href="/boardlist?pagenum=<%= i %>"><%= i %>페이지</a>&nbsp;
	<%	
	}
	%>
</body>
</html>