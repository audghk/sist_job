<%@page import="kr.co.sist.user.member.WebMemberVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.user.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="글 삭제 페이지"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty sessionScope.loginData }"><!-- 로그인 한 사람만 삭제 가능 -->
<c:redirect url="http://192.168.10.216/jsp_prj/index.jsp"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://192.168.10.216/jsp_prj/common/favicon.ico"/>
<!--bootstrap시작-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<!--bootstrap끝-->
<link rel="stylesheet" href="http://192.168.10.216/jsp_prj/common/css/main.css" media="all" />
<link rel="stylesheet" href="http://192.168.10.216/jsp_prj/common/css/board.css" type="text/css" media="all" />

<!--jQuery CDN 시작-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!--jQuery CDN 끝-->

<style type="text/css">

</style>
<% request.setCharacterEncoding("UTF-8"); %>
<!-- parameter받기 -->
<jsp:useBean id="bVO" class="kr.co.sist.user.board.BoardVO" scope="page"/>
<jsp:setProperty property="*" name="bVO"/>
<script type="text/javascript">
		
		<%
		try{
		    //아이디는 세션에 저장된 값을 받아서 설정(외부에서 조작 불가)
		bVO.setId(((WebMemberVO)session.getAttribute("loginData")).getId());
		    
		BoardDAO bDAO=BoardDAO.getInstance();
		int cnt=bDAO.deleteBoard(bVO);
		if(cnt==1){
		  
		%>
		alert("글을 삭제했습니다.");
		location.href="http://192.168.10.216/jsp_prj/board/board_list.jsp?currentPage=${param.currentPage}";
		<%
		}else{
		%>
		alert("글 삭제 실패");
		history.back();
		<%
		}
		}catch(SQLException se) {
		    se.printStackTrace();
		    %>
		    location.href="http://192.168.10.216/jsp_prj/error/err_500.html";
		    <%
		}//end catch
		%>
		$(function(){
			
		});//ready
</script>
</head>
<body>
<div>
	
</div>
</body>
</html>