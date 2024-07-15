<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://192.168.10.231/jsp_prj/common/favicon.ico">
<!-- bootstrap ���� -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<!-- bootstrap �� -->
<!--sist��Ÿ�Ͻ�Ʈ ����-->
<link rel="stylesheet" href="http://192.168.10.231/mybatis_prj/common/css/main.css" type="text/css" media="all" />
<link rel="stylesheet" href="http://192.168.10.231/mybatus_prj/common/css/board.css" type="text/css" media="all" />
<!--sist��Ÿ�Ͻ�Ʈ ��-->
<!-- JQUERY CDN ����-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!--JQUERY CDN ��-->
<style type="text/css">
	
</style>

<script type="text/javascript">
	$(function(){
		
	
	}); //ready
</script>
</head>
<body>
<div>
	<div>
	<%
	String[]linkName = {"컬럼 하나 한행 조회","컬럼 하나 어러행 조회","컬럼 여러개 한 행 조회","컬럼 여러개 여러 행조회","작은 값 조회","큰 값 조회","like"
			,"subquery","join","join &amp;subquery","테이블명이 동적일떄"
			,"OGNL : if","OGNL : choose","OGNL : foreach"," PL/SQL : Procedure"};
	String[]link = {"day0527/scsr","day0527/scmr","day0527/mcsr","day0527/mcmr","day0527/lessThan","day0527/greaterThan","day0528/like","day0529/subquery","day0529/join"
			,"day0529/join_subquery","day0529/dynamic_table","day0529/if","choose","foreach","set","procedure"};
	%>
	<table>
	<tr>
	<%for(int i=0 ; i < linkName.length ; i++){ %>
	<td><a href="index.jsp?link=<%=link[i]%>"><%=linkName[i]%></a><br/></td>
	<%} %>
	</tr>
	</table>
	</div>
	<c:if test="${not empty param.link}">
	<div>
	<c:import url="${param.link }.jsp"/>
	</div>
	</c:if>
</div>
</body>
</html>