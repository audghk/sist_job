<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%
	String dayTitle="일,월,화,수~목.금,토";
	//EL에서 사용하기 위해 scope객체에 할당
	pageContext.setAttribute("dayTitle", dayTitle);
	%>
	<c:out value="${ dayTitle }"/>
	<hr>
	<table class="table">
	<tr>
	<c:forTokens var="data" items="${ dayTitle }" delims=",~.">
	<td><option value="${ data }"><c:out value="${ data }"/></option></td>
	</c:forTokens>
	</tr>
	</table>