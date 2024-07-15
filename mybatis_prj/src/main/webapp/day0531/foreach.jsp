<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="day0531.ExamMapper7DAO"%>
<%@page import="day0530.ExamMapper6DAO"%>
<%@page import="kr.co.sist.domain.CarDomain"%>
<%@page import="day0529.ExamMapper5Service"%>
<%@page import="kr.co.sist.domain.JoinDomain"%>
<%@page import="day0529.ExamMapper5DAO"%>
<%@page import="kr.co.sist.domain.BoardDomain"%>
<%@page import="kr.co.sist.domain.EmpDomain"%>
<%@page import="java.util.List"%>
<%@page import="day0527.ExamMapper4DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="$사용조회"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<form name="frm" action="index.jsp">
		<input type="hidden" name="link" value="day0531/foreach" />
		<h2>사원정보 조회</h2>
		<label>부서번호</label>
		<input type="text" name="deptno"><br>
		<%
		String deptno = request.getParameter("deptno");
		String[] jobs = "SALESMAN,ANALYST,CLERK,MANAGER,PRESIDENT".split(",");
		pageContext.setAttribute("jobs", jobs);
		%>
		<label>직무</label>
		<c:forEach var="job" items="${jobs}">
			<input type="checkbox" name="job" value="${ job }"/><c:out value="${ job }"/>
		</c:forEach>
		<br/>
		<input type="submit" value="검색" class="btn btn-success" />
	</form>
</div>
<c:if test="${not empty param.deptno}">
[<c:out value="${param.deptno }"/>]번 부서에
<c:if test="${empty paramValues.job }">모든 직무</c:if>
<c:forEach var="job" items="${paramValues.job }">
<<c:out value="${job}"/> 
</c:forEach>
]검색결과<br>
	선택하신 [<strong><c:out value="${param.job}"/></strong>]으로 검색결과조회
	<c:catch var="e">
		<%
		ExamMapper7DAO em7DAO = ExamMapper7DAO.getInstance();
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("deptno", deptno);
		map.put("jobList",request.getParameterValues("job"));
		List<EmpDomain> list = em7DAO.dynamicForeach(map);
		pageContext.setAttribute("list", list);
		%>
	</c:catch>
	<table class="table table-hover">
		<thead>
			<tr>
				<th style="width: 120px">번호</th>
				<th style="width: 100px">사원번호</th>
				<th style="width: 200px">사원명</th>
				<th style="width: 150px">직무</th>
				<th style="width: 100px">연봉</th>
				<th style="width: 150px">입사일</th>
			</tr>
		</thead>
		<c:if test="${ empty list }">
			<tr>
				<td colspan="6" style="text-align: center">사원이 존재하지 않습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="ed" items="${ list }" varStatus="i">
			<tr>
				<td><c:out value="${ i.count }"/> </td>
				<td><c:out value="${ ed.empno }" /></td>
				<td><c:out value="${ ed.ename }" /></td>
				<td><c:out value="${ ed.job }" /></td>
				<td><fmt:formatNumber pattern="#,###,###" value="${ ed.sal }"/>만원</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${ ed.hiredate }"/></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${ not empty e }"> ${e}
		문제 발생
	</c:if>
</c:if>