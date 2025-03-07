<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#ajaxbtn").on('click', function(){
		$.ajax( {
			url: "ajaxlogin",
			data : {'id':$("input[name=id]").val() , 'pw':$("input[name=pw]").val() },
			type : 'post',
			dataType : 'json',
			success : function(response){// @ResponseBody "{"loginresult":"xxx"}"
				$("#result").html(response.loginresult);
				$("#result").css("border", "2px solid blue");
				if(response.loginresult == "로그인 성공"){
					$("#result").css("color", "green");
				}
				else{
					$("#result").css("color", "red");
				}
			},
			error : function(request, status, error){
				alert("코드=" + request.status + "\n메시지=" + request.responseText + "\n오류=" + error);
				
			}
		} );//ajax
	});//ajaxbtn on
	
	$("#ajaxbtn2").on('click', function(){//ajax내정보조회
		$.ajax( {
			url: "ajaxmyinform",
			data : {'id':$("input[name=id]").val() , 'pw':$("input[name=pw]").val() },
			type : 'get',
			dataType : 'json',
			success : function(response){// @ResponseBody 
				$("#result").html("<h3>id=" + response.id +"</h3>");
				$("#result").append("<h3>이름=" + response.name +"</h3>");
				$("#result").append("<h3>이메일=" + response.email +"</h3>");
				$("#result").append("<h3>폰번호=" + response.phone +"</h3>");
				$("#result").append("<h3>가입일=" + response.regdate +"</h3>");
			
				$("#result").css("border", "2px solid pink");
			},
			error : function(request, status, error){
				alert("코드=" + request.status + "\n메시지=" + request.responseText + "\n오류=" + error);
				
			}
		} );//ajax
	});//ajaxbtn2 on
	
	$("#ajaxbtn3").on('click', function(){//ajax내정보조회
		$.ajax( {
			url: "ajaxlist",
			data : {'id':$("input[name=id]").val() , 'pw':$("input[name=pw]").val() },
			type : 'get',
			dataType : 'json',
			success : function(response){ // 타입=배열객체 
				alert(response.length)
				$("#result").html("");
				for(let i = 0; i < response.length; i++){
					$("#result").append("<h3>id=" + response[i].id +"</h3>");
					$("#result").append("<h3>이름=" + response[i].name +"</h3>");
					$("#result").append("<h3>이메일=" + response[i].email +"</h3>");
					$("#result").append("<h3>폰번호=" + response[i].phone +"</h3>");
					$("#result").append("<h3>가입일=" + response[i].regdate +"</h3>");
				}
			
				$("#result").css("border", "2px solid lime");
			},
			error : function(request, status, error){
				alert("코드=" + request.status + "\n메시지=" + request.responseText + "\n오류=" + error);
				
			}
		} );//ajax
	});//ajaxbtn3 on
	
	$("#uploadbtn").on('click', function(){//파일업로드
		
		let data = new FormData($("#uploadForm")[0] ) ; //    form태그 jquery객체명-dom객체 변환 - js FormData 객체 변환;
		alert(data)
		$.ajax( {
			url: "ajaxupload",
			data : data,
			type : 'post', 
			encType:"multipart/form-data",
			processData : false, // name1=value1 전송x
			contentType : false,//request.setContentType("text/html;charset=utf-8") 전송x
		
			dataType : 'json',
			success : function(response){
				$("#result").html("");
				
					$("#uploadresult").append("<h3>업로드결과=" + response.uploadresult +"</h3>");
						
				$("#uploadresult").css("border", "2px solid lime");
			},
			error : function(request, status, error){
				alert("코드=" + request.status + "\n메시지=" + request.responseText + "\n오류=" + error);
				
			}
		} );//ajax
	});//uploadbtn on

	$("a").on('click', function(ev){
		ev.preventDefault();
		$.ajax( {
			url: "ajaxrole/" + $(this).text(),
			//data : {'id'},
			type : 'get', 
	
			dataType : 'json',
			success : function(response){
				$("#result").html("");
				$("#uploadresult").append("<h3>롤=" + response.role +"</h3>");
				$("#uploadresult").css("border", "2px solid lime");
			},
			error : function(request, status, error){
				alert("코드=" + request.status + "\n메시지=" + request.responseText + "\n오류=" + error);
				
			}
		} );//ajax
	});//a태그 on
	
});//ready
</script>
</head>
<body>
<h1>로그인폼</h1>
<form action="nonajaxlogin" method=post >
아이디<input type=text name="id"><br>
암호<input type="password" name="pw"><br>
<input type=submit value="로그인">
<input type=button value="ajax로그인" id="ajaxbtn">
<input type=button value="ajax내정보조회" id="ajaxbtn2">
<input type=button value="ajax회원리스트" id="ajaxbtn3">
</form>


<!-- 
ajax - admin/user/blacklist
1> <input submit/reset>  , <a> -- 동작 내장 미리 구현 기본동작 포함태그.-기본동작 말고 다른동작 구현- preventDefault()
 -->
<h3><a href="ajaxrole/">spring</a>나의 역할 구분</h3>
<h3><a href="ajaxrole/">admin</a>나의 역할 구분 </h3>
<h3><a href="ajaxrole/">test</a>나의 역할 구분 </h3>

<div id="result"></div>

<hr>
<h1>파일업로드폼</h1>
<form id="uploadForm"> 
파일설명:<input type=text name="detail"><br>
파일선택:<input type=file name="uploadfile"><br><!-- 파일열기창(windows 자원) + 파일 선택 -->
<input type=button id="uploadbtn" value="ajax파일업로드">
</form>

<div id="uploadresult"></div>

</body>
</html>






