<%@page import="kr.co.sist.domain.EmpDomain"%>
<%@page import="java.util.List"%>
<%@page import="day0527.ExamMapper4DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="컬럼 여러개에 여러 행 조회"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name="frm" action="index.jsp">
	<input type="hidden" name="link" value="day0527/mcmr"/>
	<h2>부서번호에 해당하는 사원정보 조회</h2>
	<label>부서번호</label>
	<input type="text" name="deptno"/>
	<input type="text" style="display:none"/>
	<input type="submit" name="검색" class="btn btn-success btn-sm"/>
	
</form>
<div>
<c:if test="${ not empty param.deptno }">
입력하신 부서번호 [<strong><c:out value="${ param.deptno }"/></strong>번]의 사원정보 검색결과<br>
<c:catch var="e">
<%
int deptno=Integer.parseInt(request.getParameter("deptno"));
ExamMapper4DAO em4DAO=ExamMapper4DAO.getInstance();
List<EmpDomain> list=em4DAO.mcmr(deptno);
pageContext.setAttribute("list", list);
%>
<table class="table table-hover">
<tr>
<th style="width: 80px">사원번호</th>
<th style="width: 200px">사원명</th>
<th style="width: 120px">사원직무</th>
<th style="width: 120px">연봉</th>
<th style="width: 200px">입사일</th>
</tr>
<c:if test="${ empty list }">
<tr>
<td colspan="5" style="text-align:center">
사원이 존재하지 않는 부서
</td>
</tr>
</c:if>
<c:forEach var="ed" items="${ list }" varStatus="i">
<tr>
<td><c:out value="${ ed.empno }"/></td>
<td><c:out value="${ ed.ename }"/></td>
<td><c:out value="${ ed.job }"/></td>
<td><c:out value="${ ed.sal }"/></td>
<td><c:out value="${ ed.hiredateStr }"/></td>
</tr>
</c:forEach>
</table>
</c:catch>
<c:if test="${not empty e }">
부서번호는 숫자로만 구성됩니다.
</c:if>
</c:if>

</div>