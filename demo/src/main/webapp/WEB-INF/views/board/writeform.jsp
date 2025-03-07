<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기폼</h1>
	<form action="boardwrite" method="post" enctype="multipart/form-data">
		<label for="title">제목</label><input type=text id="title" name="title"><br>
		<label for="contents">내용</label>
		<textarea rows="5" cols="50" id="contents" name="contents"></textarea>
		<label for="writer">작성자</label><input type=text id="writer" name="writer" 
		value=${sessionScope.sessionid } readonly="readonly"><br>
		<label for="pw">암호</label><input type="password" id="pw" name="pw"><br>
		<label for="file1">파일선택</label><input type="file" id="file1" name="multifile1"><br>
		<input type=submit value="글쓰기" >
	</form>
</body>
</html>