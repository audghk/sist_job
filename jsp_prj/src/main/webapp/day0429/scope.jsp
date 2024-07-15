<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
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
<%
String msg = "오늘은 월요일 입니다.";
%>
<hr>
<h2>EL에서는 변수를 직접 접근할 수 없다.</h2>
EL : ${msg}<br />
Expression : <%= msg %><br />
<%
// EL에서 변수를 접근하려면 scope 객첻에 할당되어야 하고, scope 객체명으로 접근 가능
// 1. scope 객체 할당
pageContext.setAttribute("m", msg);
pageContext.setAttribute("pageName", "김동섭");
request.setAttribute("reqName", "정명호");
session.setAttribute("sesName", "진수현");
application.setAttribute("appName", "정명호");

pageContext.setAttribute("name", "김동섭");
request.setAttribute("name", "정명호");
session.setAttribute("name", "진수현");
application.setAttribute("name", "정명호");
%>
2. scope 객체를 사용한 접근 : <strong>${pageScope.m}</strong>
<ul>
	<li>pageScope : ${pageScope.pageName} (${pageName})</li>
	<li>requestScope : ${requestScope.pageName} (${reqName})</li>
	<li>sessionScope : ${sessionScope.pageName} (${sesName})</li>
	<li>applicationScope : ${applicationScope.pageName} (${appName})</li>
	
	<li>pageScope : ${pageScope.name}</li>
	<li>requestScope : ${requestScope.name}</li>
	<li>sessionScope : ${sessionScope.name}</li>
	<li>applicationScope : ${applicationScope.name}</li>
</ul>
${name}
</div>
</body>
</html>