<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>    
	<link rel="icon" href="http://192.168.10.211/jsp_prj/common/favicon.ico" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="http://192.168.10.211/jsp_prj/common/css/main.css" type="text/css" media="all" />
	<link rel="stylesheet" href="http://192.168.10.211/jsp_prj/common/css/board.css" type="text/css" media="all" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<style text="text/css">
	</style>
	<script text="text/javascript">
		$(function(){
			
		});
	</script>
</head>
<body>
<div>
<c:if test="false">
이것은 안보입니다.
</c:if>
<!-- 요청 링크를 클릭하면 strong 태그 내의 데이터가 사라지도록 해보기 -->
<c:if test="${empty param.flag }">
	<strong>아래의 요청링크를 클릭해주세요.</strong>
</c:if>
<a href="jstl_if.jsp?flag=1">요청</a>

<c:if test="${ empty sessionScope.id }">
	<a href="jstl_if_1.jsp">로그인</a>
</c:if>
<c:if test="${ not empty sessionScope.id }">
	<c:out value="${ name }" />님 로그인 하셨습니다.
	<a href="logout.jsp">로그아웃</a>
</c:if>
</div>
</body>
</html>