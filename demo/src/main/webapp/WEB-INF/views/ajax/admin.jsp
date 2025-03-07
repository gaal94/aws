<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.7.1.min.js"></script>
<script>
	$(document).ready(function() {
		$("#listbtn").on('click', function() {
			$.ajax({
				url: "ajaxlist2",
				data : {'id':$("input[name=id]").val(), 'pw':$("input[name=pw]").val()},
				type : 'get',
				dataType : 'json',
				success : function(response) {
					$("#result1").html("");
					for(let i = 0; i < response.length; i++) {						
						$("#result1").append("<h3><a href=\"\">" + response[i].id + "</a> 암호 확인</h3>");
					}
					$("a").on('click', function(ev) {
						ev.preventDefault();
						$.ajax({
							url: "getpw/" + $(this).text(),
							type : 'get',
							dataType : 'json',
							success : function(response) {
								$("#result2").html("<h3>암호 = " + response.pw + "</h3>");
								$("#result2").css("border", "2px solid lime");
							},
							error : function(request, status, error) {
								alert("코드=" + request.status + "\n메시지=" + request.responseText + "\n오류=" + error);
							}
						});
					})
				},
				error : function(request, status, error) {
					alert("코드=" + request.status + "\n메시지=" + request.responseText + "\n오류=" + error);
				}
			});
		})
	})
</script>
</head>
<body>
	<form>
		아이디<input type=text name="id" id="id"><br>
		암호<input type=password name="pw" id="pw"><br>
		<input type=button id="listbtn" value="회원 아이디리스트">
	</form>
	<div id="result1"></div>
	<div id="result2"></div>
</body>
</html>