<%@page import="kr.co.sist.user.member.WebMemberVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.user.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="글쓰기 db추가 페이지"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty sessionScope.loginData }">
<c:redirect url="http://192.168.10.216/jsp_prj/index.jsp"/>
</c:if>

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
		bDAO.insertBoard(bVO);
		%>
		alert("글을 작성했습니다.");
		location.href="http://192.168.10.216/jsp_prj/board/board_list.jsp";
		<%
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
