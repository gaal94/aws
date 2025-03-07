<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일업로드폼</h1>
	<form action="fileupload" method=post enctype="multipart/form-data">
		업로더<input type=text name="uploader"><br>
		설명<input type=text name="desc"><br>
		업로드파일1(이미지만)<input type=file name=f1 accept="image/*"><br>
		업로드파일2<input type=file name=f2><br>
		<input type=submit value="파일업로드">
	</form>
	업로드파일미리보기<div id="preview"></div>
	<script src="/js/jquery-3.7.1.min.js"></script>
	<script>
		$("input[name=f1]").on('change', function(ev) {
			let reader = new FileReader();
			reader.readAsDataURL(ev.target.files[0]);
			reader.onload = function(e) {			
				let img = document.createElement("img");
				img.setAttribute("src", e.target.result);
				$("#preview").html(img);
			}
		})
	</script>
</body>
</html>