<%@page import="kr.co.sist.user.member.ProfileDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.IOException"%>
<%@page import="kr.co.sist.util.cipher.DataEncrypt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="파라메터 받는 JSP"%>
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
	<% request.setCharacterEncoding("UTF-8"); %>
	<jsp:useBean id="pVO" class="kr.co.sist.user.member.ProfileVO" scope="page" />
	<jsp:setProperty property="*" name="pVO" />
	<%
	pageContext.setAttribute("msg", "변경되지 않았습니다.");
	
	try{
		// 복호화 가능한 암호화(이름, 전화번호, 이메일)
		String key = "DMF1ucDxtqgxw5niaXcmYQ==";
	    DataEncrypt de = new DataEncrypt(key);
		pVO.setName(de.encryption(pVO.getName()));
		
		ProfileDAO pDAO = ProfileDAO.getInstance();
		pDAO.updateInfo(pVO);
		pageContext.setAttribute("msg", "변경되었습니다.");
	} catch( IOException | SQLException e){
	    e.printStackTrace();
	}
	%>
	<c:out value="${ param.id }" />님의 정보가 <c:out value="${msg}" />
</div>
</body>
</html>