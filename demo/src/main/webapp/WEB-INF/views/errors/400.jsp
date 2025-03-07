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
	<h1>요청 파라미터를 확인하세요.</h1>
	<%= request.getAttribute(RequestDispatcher.FORWARD_QUERY_STRING) %>
</body>
</html>