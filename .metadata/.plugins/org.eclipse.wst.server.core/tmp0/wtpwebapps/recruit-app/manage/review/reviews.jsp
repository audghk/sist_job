<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../assets/layout/admin/lib.jsp" />
<script type="text/javascript">
	$(function(){
    	$("#review_menu").addClass("bg-gradient-primary");
	});
</script>
<!-- golgolz start -->		

<link href="http://localhost//recruit-app/assets/css/pagenation.css" rel="stylesheet" />
<link href="http://localhost//recruit-app/assets/css/manage/order/admin.css" rel="stylesheet" />
<link href="http://localhost//recruit-app/assets/css/manage/order/reset.css" rel="stylesheet" />
<!-- golgolz end -->
</head>
<body>
	<jsp:include page="../../assets/layout/admin/header.jsp" />
	<main
		class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ps ps--active-y">
		<nav
			class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl"
			id="navbarBlur" data-scroll="true">
			<div class="container-fluid py-1 px-3">
				<nav aria-label="breadcrumb">
					<ol
						class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
						<li class="breadcrumb-item text-sm"><a
							class="opacity-5 text-dark" href="javascript:;">
							관리자 기능</a></li>
						<!-- 하단의 대시보드 텍스트를 본인 기능으로 변경 필요  -->
						<li class="breadcrumb-item text-sm text-dark active"
							aria-current="page">리뷰 관리</li>
					</ol>
					<h5 class="font-weight-bolder mb-0">리뷰 관리</h5>
				</nav>
			</div>
		</nav>
	
	<div class="container-fluid py-4">
			<!-- golgolz start -->
			<div class="s_wrap">
	<form name="fsearch" id="fsearch" method="get" onsubmit="return handleFormSubmit(event); " action="">
<input type="hidden" name="code" value="list">
<div class="tbl_frm01">
	<table>
	<colgroup>
		<col class="w100">
		<col>
	</colgroup>
	<tbody>
	<tr>
		<th scope="row">검색어</th>
		<td>
			<select name="sfl">
				<option value="id">아이디</option>
				<option value="name">회원명</option>
			</select>
			<input type="text" name="stx" value="" class="frm_input" size="30">
		</td>
	</tr>
	
	</tbody>
	</table>
</div>
<div class="btn_confirm">
	<input type="submit" value="검색" class="btn_medium">
</div>
</form>

<div class="local_ov mart30">
	총 회원수 : <b class="fc_red">3</b>명
</div>
<div class="tbl_head01">
	<table>
	<thead>
	 <tr>
                <th scope="col" style="width: 50px;">번호</th>
                <th scope="col" style="width: 50px;">아이디</th>
                <th scope="col" style="width: 50px;">작성자</th>
                <th scope="col" style="width: 150px;">제목</th>
                <th scope="col" style="width: 130px;">가입일</th>
                <th scope="col" style="width: 60px;">추천수</th>
                <th scope="col" style="width: 60px;">삭제여부</th>
            </tr>
	</thead>
	<tbody class="list">
	<tr>
                <td>1</td>
                <td>user1</td>
                <td>작성자1</td>
                <td>제목1</td>
                <td>2023-01-01</td>
                <td>10</td>
                <td>Yes</td>
            </tr>
	
				 <% 
				/*  String inputId = request.getParameter("stx");
				 String sfl = request.getParameter("sfl");

				 String frDate = request.getParameter("fr_date");
				 String toDate = request.getParameter("to_date");

				 // 입력값을 디버깅합니다.
				 System.out.println("fr_date: " + frDate + ", to_date: " + toDate);

				 // inputId를 trim()하여 공백을 제거한 후, 빈 문자열인지 확인.
				 if (inputId != null && inputId.trim().isEmpty()) {
				     inputId = null; // 공백 값인 경우 inputId를 null로 설정.
				 }

				 System.out.println("------"+inputId+"-----"+sfl);
				 System.out.println("inputId 값 디버깅: " + (inputId == null ? "null" : inputId));

				 // 사용자 정보 목록을 얻는 로직
				 UserManageDAO dao = new UserManageDAO();
				 List<UserManageVO> userList = null;

				 // 날짜 포맷팅 및 초기값 설정
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				 String today = formatter.format(new Date());

				 if (frDate == null || frDate.trim().isEmpty()) {
				     frDate = "1970-01-01"; // 시작 날짜가 입력되지 않았을 때, 초기 날짜 설정
				 }
				 if (toDate == null || toDate.trim().isEmpty()) {
				     toDate = today; // 종료 날짜가 입력되지 않았을 때, 오늘 날짜로 설정
				 }

				// 검색 조건에 따라 DAO 메소드 호출
				 if (sfl != null && sfl.equals("id") && inputId != null && !inputId.trim().isEmpty() && frDate != null && !frDate.trim().isEmpty() && toDate != null && !toDate.trim().isEmpty()) {
				     // inputId와 날짜 범위에 따른 검색 수행
				     try {
				         userList = dao.selectUserInfoByIdAndDateRange(inputId, frDate, toDate);
				         System.out.println("------ inputId와 날짜 범위 조건에 따른 사용자가 조회되었습니다. ------");
				         System.out.println("inputId: " + inputId + ", frDate: " + frDate + ", toDate: " + toDate);
				     } catch (Exception e) {
				         e.printStackTrace();
				     }
				 } else if (inputId != null && !inputId.trim().isEmpty() && sfl != null && sfl.equals("name")) {
				     // inputName과 날짜 범위에 따른 검색 수행
				     try {
				         userList = dao.selectUserInfoByNameAndDateRange(inputId, frDate, toDate);
				         System.out.println("------ inputName과 날짜 범위 조건에 따른 사용자가 조회되었습니다. ------");
				         System.out.println("inputName: " + inputId + ", frDate: " + frDate + ", toDate: " + toDate);
				     } catch (Exception e) {
				         e.printStackTrace();
				     }
				 } else if (inputId != null && sfl != null) {
				     // sfl 값에 따라 다른 검색 수행
				     switch (sfl) {
				         case "id":
				             userList = dao.selectUserInfoById(inputId);
				             System.out.println("------ 사용자 ID에 따른 정보가 조회되었습니다. ------");
				             break;
				         case "name":
				             userList = dao.selectUserInfoByName(inputId);
				             System.out.println("------ 사용자 이름에 따른 정보가 조회되었습니다. ------");
				             break;
				         default:
				             System.out.println("sfl 값이 유효하지 않습니다.");
				             break;
				     }
				 } else {
				     // 날짜 범위에 따른 검색 수행
				     userList = dao.selectUserInfoByDateRange(frDate, toDate);
				     System.out.println("------ 날짜 범위에 따른 사용자 정보가 조회되었습니다. ------");
				 }
				
				 int pageScale = 10;
			        int currentPage = Integer.parseInt(request.getParameter("page") != null ? request.getParameter("page") : "1");
			        int startNum = pageScale * (currentPage - 1) + 1;
			        int endNum = startNum + pageScale - 1;

				// 사용자 정보 출력
				 for (int i = 0;i < userList.size(); i++) {
				     //UserManageVO userInfo = userList.get(i);
				     // 각 사용자에 대한 행 번호(rowNum)를 i + 1로 설정
				     int rowNum = i + 1; 
				     
				     */
				     
				     %>
				     <%-- <tr id="<%=userInfo.getId() %>" class="user-row">
				         <td><%= rowNum %></td> <!-- 행 번호 출력 -->
				         <td class="tal"><span class="sv_wrap"><%= userInfo.getName() %></span></td>
				         <td class="tal"><%= userInfo.getId() %></td>
				         <td><%= userInfo.getTel() %></td>
				         <td><%= userInfo.getInput_date() %></td>
				         <td><%= userInfo.getTotal_amount() %></td>
				         <td><%= userInfo.getAccess_limit_flag() %></td>
				         <td><%= userInfo.getWithdrawal_flag() %></td>
				     </tr> --%>
				     <%
				 //} 
    %>
	
	
	
		</tbody>
	</table>
	
</div>




</div>
</div>

	<!-- golgolz end -->
	</main>
</body>
</html>