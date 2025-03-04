<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../assets/layout/admin/lib.jsp" />
<link href="//i.jobkorea.kr/content/css/ver_2/event/banner.promotion-sv-202401301659.css" rel="stylesheet" type="text/css" />
<link href="view-source:https://www.jobkorea.co.kr/help/inquiry" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/content/css/ver_2/common-sv-202405271315.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/common/gnb-sv-202405231305.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/content/css/ver_2/mtc/mtc_lounge-sv-202402231655.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/content/css/ver_2/help/help-sv-202402231655.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/layout/footer-sv-202405131313.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/pages/main/auto_search-sv-202405231305.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/content/css/ver_2/mtc/inquiry_selection.css?v=2024052914000" rel="stylesheet" type="text/css" />

<style type="text/css">
	#qnaFrm{margin-left:300px; margin-right:40px}
</style>

<script type="text/javascript">
	$(function(){
    	$("#qna_menu").addClass("bg-gradient-primary");
	});
</script>
<!-- golgolz start -->
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
							aria-current="page">문의 관리</li>
					</ol>
					<h6 class="font-weight-bolder mb-0">문의 관리</h6>
				</nav>
			</div>
		</nav>
	</main>
	<!-- golgolz start -->
	<div>
	<div class="loungeContent inquiryContent inquiryContent--selection"  id="qnaFrm">
       <!--  <div class="topHdWrap">
            <h2 class="lug_hd_2">문의</h2>
        </div> -->

        <!--// 문의하기 -->
        <div class="inquiryFormWrap">

<!--// tap menu -->
<div class="mtcTplTab">
	<ul class="tabItems">
		<li class="on"><a href="qna_list.jsp">문의 내역</a></li>
		<li class=""><a href="new_qnas_list.jsp">새로운 문의</a></li>
	</ul>
</div>
<!-- tap menu //-->
<!--// 내 제안내역 보기 -->
	<div class="inquiryListWrap">
	<!--// List 시작 -->
		<div class="schListWrap">
		<div class="mtcSchListTb">
		<!--[개발] 문의 내용이 없는 경우 hide 처리 -->
			<table summary="내 제안내역 보기 목록으로 글번호, 내용, 날짜, 답변여부로 구성되어 있습니다.">
			<caption>내 제안내역 보기</caption>
				<colgroup>
					<col class="col_1">
					<col class="col_2">
					<col class="col_3">
					<col class="col_4">
				</colgroup>
				<thead class="blind">
					<tr>
					<th scope="col">글번호</th>
					<th scope="col">내용</th>
					<th scope="col">날짜</th>
					<th scope="col">답변여부</th>
					</tr>
				</thead>
				<tbody>
					<tr>
					<td>79483</td>
					<td class="alLeft"><span class="tit"><a href="old_qnas_detail.jsp">기업 리뷰는 어떻게 확인하는 지 궁금합니다.</a></span></td>
					<td>2024.05.24</td>
					<td class="">답변완료</td>
					</tr>
				</tbody>
				</table>

			<div class="listBtmArea">
			<div class="tplPagination">
		    <div class="tplPagination">
		        <ul>
		          <li><span class="now">1</span></li>
		        </ul>
		    </div>
			</div>
		</div>
	</div>
	</div>
<!-- List 끝 //-->
</div>
</div>
	<!-- golgolz end -->
</body>
</html>