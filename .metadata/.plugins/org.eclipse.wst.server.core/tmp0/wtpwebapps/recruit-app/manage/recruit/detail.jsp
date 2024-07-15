<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../assets/layout/admin/lib.jsp" />
<!-- golgolz start -->
<link href="./assets/css/manage/goods/general.css" rel="stylesheet" />
<link href="./assets/css/manage/goods/goods.css" rel="stylesheet" />
<link href="./assets/css/manage/goods/default.css" rel="stylesheet" />
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#company_menu").addClass("bg-gradient-primary");

	    $('#summernote').summernote({
	        tabsize: 2,
	        height: 300
	    });
	});
</script>
<style>
.subtitle{
	padding: 0px;
	margin-top: 20px;
}

#dataForm div:first-child{
	margin-top: 0px;
}

.container-fluid py-4 {
	padding-top: 0px;!important
}

.detail-control {
	font-size: 15px;
	margin-right: 2px;
}

#benefits li{
	font-size: 15px;
	height: 30px;
	list-style-type: decimal;
	list-style-position: inside;
	display: flex;
    align-items: center; /* 세로 중앙 정렬 */
}

#benefits li:hover{
	background-color: #DDD;
}
</style>
<!-- golgolz end -->
</head>
<body>
	<jsp:include page="../../assets/layout/admin/header.jsp" />
	<main
		class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ps--active-y">
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
							aria-current="page">채용 공고 관리</li>
					</ol>
					<h6 class="font-weight-bolder mb-0">채용 공고 상세</h6>
				</nav>
			</div>
		</nav>
		<div class="container-fluid py-4">
			<!-- golgolz start -->
			<div id="contentcolumn" class="">
				<div class="contents">
					<form id="dataForm" name="dataForm" action="http://localhost/online-shop/manage/goods/register_process.jsp" method="post" enctype="multipart/form-data">
						<div class="subtitle">
							<img src="http://localhost/online-shop/assets/images/manage/goods/register/bul_subtitle.gif" />
							공고 정보
						</div>
						<table class="tbstyleB" width="100%">
							<colgroup>
								<col width="15%" />
								<col width="85%" />
							</colgroup>
							<tbody>
								<tr>
									<td class="label">기업명</td>
									<td class="box text">
										<input type="text" name="name" value="" size="50" class="inputbox naver_shopping_prodName" />
										<input type="button" id="btn-register" class="btn btn-success btn-sm" value="조회" />
									</td>
								</tr>
								<tr>
									<td class="label">공고 제목</td>
									<td class="box text">
										<input type="text" name="name" value="" size="150" class="inputbox naver_shopping_prodName" />
									</td>
								</tr>
								<tr>
									<td class="label">모집 종료일</td>
									<td class="box text">
										<input type="text" name="name" value="" size="150" class="inputbox naver_shopping_prodName" />
									</td>
								</tr>
								<tr>
									<td class="label">모집 포지션</td>
									<td class="box text">
										<input type="text" name="name" value="" size="50" class="inputbox naver_shopping_prodName" />
										<input type="button" id="btn-register" class="btn btn-success btn-sm" value="조회" />
									</td>
								</tr>
								<tr>
									<td class="label">모집 인원</td>
									<td class="box text">
										<input type="text" name="name" value="" size="10" class="inputbox naver_shopping_prodName" />명
									</td>
								</tr>
							</tbody>
						</table>
						<div class="subtitle">
							<img src="http://localhost/online-shop/assets/images/manage/goods/register/bul_subtitle.gif" />
							근무 조건
						</div>
						<table class="tbstyleB" width="100%">
							<colgroup>
								<col width="15%" />
								<col width="85%" />
							</colgroup>
							<tbody>
								<tr>
									<td class="label">고용형태</td>
									<td class="box text">
										<input type="radio" name="school" value="정규직" /><label>정규직</label>
										<input type="radio" name="school" value="계약직" /><label>계약직</label>
										<input type="radio" name="school" value="무기계약직" /><label>무기계약직</label>
									</td>
								</tr>
								<tr>
									<td class="label">근무 요일</td>
									<td class="box text">
										<input type="text" name="name" value="" size="50" class="inputbox naver_shopping_prodName" />
									</td>
								</tr>
								<tr>
									<td class="label">근무 시간</td>
									<td class="box text">
										<input type="text" name="name" value="" size="50" class="inputbox naver_shopping_prodName" />
									</td>
								</tr>
								<tr>
									<td class="label">근무지</td>
									<td class="box text">
										<input type="text" name="name" value="" size="50" class="inputbox naver_shopping_prodName" />
									</td>
								</tr>
								<tr>
									<td class="label">급여</td>
									<td class="box text">
										<input type="radio" name="school" value="일급" /><label>일급</label>
										<input type="radio" name="school" value="주급" /><label>주급</label>
										<input type="radio" name="school" value="월급" /><label>월급</label>
										<input type="radio" name="school" value="연봉" /><label>연봉</label>
										<input type="text" name="name" value="" size="10" class="inputbox naver_shopping_prodName" /> 만원
									</td>
								</tr>
							</tbody>
						</table>
						<div class="subtitle">
							<img src="http://localhost/online-shop/assets/images/manage/goods/register/bul_subtitle.gif" />
							지원 조건
						</div>
						<table class="tbstyleB" width="100%">
							<colgroup>
								<col width="15%" />
								<col width="85%" />
							</colgroup>
							<tbody>
								<tr>
									<td class="label">경력</td>
									<td class="box text">
										<input type="radio" name="career" value="경력무관" /><label>경력무관</label>
										<input type="radio" name="career" value="신입" /><label>신입</label>
										<input type="radio" name="career" value="신입" /><label>경력 (</label>
										<input type="text" name="name" value="" size="5" class="inputbox naver_shopping_prodName" />년)
									</td>
								</tr>
								<tr>
									<td class="label">학력</td>
									<td class="box text">
										<input type="radio" name="school" value="고등학교 졸업" /><label>고등학교 졸업 </label>
										<input type="radio" name="school" value="전문대 졸업" /><label>전문대 졸업 </label>
										<input type="radio" name="school" value="대학교 졸업" /><label>대학교 졸업 </label>
										<input type="radio" name="school" value="대학원(석사)" /><label>대학원(석사) </label>
										<input type="radio" name="school" value="대학원(박사)" /><label>대학원(박사) </label>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="subtitle">
							<img src="http://localhost/online-shop/assets/images/manage/goods/register/bul_subtitle.gif" />
							공고상세
						</div>
						<div id="summernote"></div>
						<div class="alignCenter">
							<% if(request.getParameter("code") == null){ %>
								<input type="button" id="btn-register" class="btn btn-success btn-sm detail-control" value="등록하기" />
							<% } else { %>
								<input type="button" id="btn-update" class="btn btn-warning btn-sm detail-control" value="수정하기" />
								<input type="button" id="btn-delete" class="btn btn-danger btn-sm detail-control" value="삭제하기" />
							<% } %>
								<input type="button" id="btn-back" class="btn btn-success btn-sm detail-control" value="뒤로" onClick="javascript:history.back();"/>
						</div>
					</form>
				</div>
			</div>
			<!-- golgolz end -->
		</div>
	</main>
</body>
</html>