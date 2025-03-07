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
		$("#deletebtn").on("click", function() {
			//let userpw = prompt("글암호를 입력하세요.");
			$("#inputpw").html("<input type='password' id='userpw'><input type='button' id='checkpwbtn' value='암호확인'>")
			$("#checkpwbtn").on('click', function() {				
				let userpw = $("#userpw").val();
				let dbpw = ${ detailboard.pw };
				if(userpw == dbpw) {
					//alert("암호일치");
					$.ajax({
						url: 'boarddelete',
						data: {seq: '${ detailboard.seq }'},
						type: 'get',
						dataType: 'json',
						success: function(res){
							$("#inputpw").append("<h3>" + res.result + "</h3>");
						}
					})
				} else {
					alert("암호불일치");
				}
			})
		});
		
		$("#updatebtn").on("click", function() {
			//let userpw = prompt("글암호를 입력하세요.");
			$("#inputpw").html("<input type='password' id='userpw'><input type='button' id='checkpwbtn' value='암호확인'>")
			$("#checkpwbtn").on('click', function() {				
				let userpw = $("#userpw").val();
				let dbpw = ${ detailboard.pw };
				if(userpw == dbpw) {
					//alert("암호일치");
					$.ajax({
						url: 'boardupdate',
						data: $("form").serialize(),
						type: 'get',
						dataType: 'json',
						success: function(res){
							$("#inputpw").append("<h3>" + res.result + "</h3>");
						}
					})
				} else {
					alert("암호불일치");
				}
			})
		});
		
		$("#listbtn").on('click', function() {
			location.href = "/boardlist";
		});
	});
</script>
</head>
<body>
	<h1>상세게시물 화면입니다.</h1>
	<form action="" method="">
		<table border=2>
			<tr><td>번호</td><td><input type=text value="${ detailboard.seq }" readonly name="seq"></td></tr>
			<tr><td>제목</td><td><input type=text value="${ detailboard.title }" name="title"></td></tr>
			<tr><td>내용</td><td><textarea cols=50 rows=5 name="contents">${ detailboard.contents }</textarea></td></tr>
			<tr><td>작성자</td><td><input type=text value="${ detailboard.writer }" readonly name="writer"></td></tr>
			<tr><td>조회수</td><td><input type=text value="${ detailboard.viewcount }" readonly name="viewcount"></td></tr>
			<tr><td>작성시간</td><td><input type=text value="${ detailboard.writingtime }" readonly name="writingtime"></td></tr>
			<tr><td>첨부파일명</td><td><a href="boarddownload?filename=${ detailboard.file1 }">${ detailboard.file1 }</a></td></tr>
			<tr><td colspan=2 style="text-align:center"><input type=button id="updatebtn" value="수정버튼"><input type=button id="deletebtn" value="삭제버튼"></td></tr>
		</table>
	</form>
	<div id="inputpw"></div>
	<input type=button value="게시물리스트" id="listbtn">
</body>
</html>