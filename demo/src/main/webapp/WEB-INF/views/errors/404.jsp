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
	<h1>요청 url 매핑 컨트롤러가 없거나 뷰가 없습니다.</h1>
	<%= request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI) %>
</body>
</html>