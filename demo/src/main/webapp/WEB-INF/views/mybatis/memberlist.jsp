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
<form id="searchform" action="">
<select name="item" >
 <option>이름검색</option>
 <option>폰번호검색</option>
 <option>이메일검색</option>
 <option>아이디검색</option>
</select>
검색어:<input type=text name="searchword">
<input type=submit value="검색요청">
<input type=submit value="모든회원리스트">
</form>

<script src="/js/jquery-3.7.1.min.js"></script>
<script>

$("input:submit").on('click', function(){
	alert($(this).val());
	if($(this).val() == "모든회원리스트"){
		$("#searchform").attr("action", "membermybatislist");
	}
	else if($(this).val() == "검색요청"){
		$("#searchform").attr("action", "membersearchlist");
	}
});

</script>
<!-- 1>검색요청 클릭하면 membersearchlist url 매핑 컨트롤러 메소드 호출
     2>item=이름검색 : MemberDTO dto=new MemberDTO(); dto.setName(searchword변수)
     ......
     3> 서비스 메소드 호출 - 이미 구현 완료
     4> 3번 결과 모델 - mybatis/memberlist.jsp 검색리스트 출력
 -->
<h1>회원 리스트 출력합니다.</h1>
<c:forEach items="${memberlist }" var="dto" varStatus="vs">
	<h3>${dto.id} : ${dto.name} : ${dto.email }</h3>
</c:forEach>

<h1>총회원수 : ${membercount }</h1>

</body>
</html>