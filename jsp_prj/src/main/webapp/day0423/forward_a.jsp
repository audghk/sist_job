<%@page import="day0423.UrlVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="업무로직만 정의하는 JSP"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://192.168.10.216/jsp_prj/common/favicon.ico"/>
<!--bootstrap 시작-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<!--bootstrap 끝-->
<link rel="stylesheet" href="http://192.168.10.216/jsp_prj/common/css/main.css" type="text/css" media="all" />
<link rel="stylesheet" href="http://192.168.10.216/jsp_prj/common/css/board.css" type="text/css" media="all" />
<!--jQuery CDN 시작-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!--jQuery CDN 끝-->
<style type="text/css">
	
</style>
<script type="text/javascript">
	$(function(){
		
	});//ready
</script>
</head>
<body>
<div>
<%
//0.DB코드, 업무코드를 정의
String name="정명호";
UrlVO[] data={new UrlVO("1","http://java.sun.com","자바를 다운 받을 수 있는 URL"),
    		  new UrlVO("2","http://oracle.com","오라클을 다운 받을 수 있는 URL"),
    		  new UrlVO("3","http://jquery.com","jquery library를 다운 받을 수 있음"),
    		  new UrlVO("4","http://java.sun.com","자바를 다운 받을 수 있는 URL")
};
//1. 업무처리 결과를 scope객체 할당(디자인이 적용된 페이지에서 보여주기 위해)
request.setAttribute("name", name);
request.setAttribute("urlArr", data);

//2. 이동할 페이지(view페이지) URI설정
RequestDispatcher rd=request.getRequestDispatcher("forward_b.jsp");

//3. 이동
rd.forward(request, response);

%>
	이쁜 디자인
</div>
</body>
</html>