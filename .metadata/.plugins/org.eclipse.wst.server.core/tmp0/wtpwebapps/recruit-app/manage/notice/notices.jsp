<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<!DOCTYPE html>
<html>
<head>

<!--bootstrap 시작-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<!--bootstrap 끝-->

<link
	href="https://i.jobkorea.kr/content/css/ver_2/event/banner.promotion-sv-202401301659.css"
	rel="stylesheet" type="text/css" />
<link
	href="https://i.jobkorea.kr/content/css/ver_2/common-sv-202405271315.css"
	rel="stylesheet" type="text/css" />
<link
	href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/common/gnb-sv-202405231305.css"
	rel="stylesheet" type="text/css" />
<link
	href="https://i.jobkorea.kr/content/css/ver_2/mtc/mtc_lounge-sv-202402231655.css"
	rel="stylesheet" type="text/css" />
<link
	href="https://i.jobkorea.kr/content/css/ver_2/help/help-sv-202402231655.css"
	rel="stylesheet" type="text/css" />
<link
	href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/layout/footer-sv-202405131313.css"
	rel="stylesheet" type="text/css" />
<link
	href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/pages/main/auto_search-sv-202405231305.css"
	rel="stylesheet" type="text/css" />

<jsp:include page="../../assets/layout/admin/lib.jsp" />

<style type="text/css">
#notice_frm {
	margin: 40px;
	padding-left: 280px
}

#searchOption {
	float: right;
	margin-right: 10px
}

#search {
	float: right
}

#category2 {
	position:left;
	float: left;
	margin-left: 10px
}
</style>

<script type="text/javascript">
	$(function() {
		$("#notice_menu").addClass("bg-gradient-primary");
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
							class="opacity-5 text-dark" href="javascript:;"> 관리자 기능</a></li>
						<!-- 하단의 대시보드 텍스트를 본인 기능으로 변경 필요  -->
						<li class="breadcrumb-item text-sm text-dark active"
							aria-current="page">공지사항 관리</li>
					</ol>
					<h6 class="font-weight-bolder mb-0">공지사항 관리</h6>
				</nav>
			</div>
		</nav>
	</main>
	<!-- golgolz start -->
	<div class="loungeContent noticeListContent" id="notice_frm">
		<div class="topHdWrap clear">
			<h2 class="lug_hd_2">공지사항</h2>
			<form action="#">
				<fieldset>
					<legend>공지사항 검색</legend>
					<div class="searchBarItem mtcPlaceholder" id="search">
						<span class="phTx">키워드 검색</span> <input type="text" id="lb_sch"
							class="mtcSchInp" title="검색어 입력">
						<button type="button" class="mtcBtnB mtcSchBtn">
							<span class="skip">검색</span>
						</button>
					</div>
				</fieldset>
				<div id="searchOption">
					<label for="lb_sel01"></label> <select id="category1" 
						name="category1" style="height: 30px; width:60px">
						<option value="제목" selected>제목</option>
						<option value="내용">내용</option>
						<!-- <option value="평점높은순">평점높은순</option>
						<option value="평점낮은순">평점낮은순</option> -->
					</select>
				</div>
			</form>
		</div>

		<div class="schListWrap">
			<div class="mtcSchListTb">
				<table summary="">
					<caption>공지사항</caption>
					<colgroup>
						<col class="col_1">
						<col class="col_2">
						<col class="col_3">
					</colgroup>
					<thead>
						<tr>
							<th>
								<div class="lyTplArea schItems">
									<!-- 	<span class="tHd"><button type="button" class="btnListSort mtcBtnA">전체</button></span>
									<ul class="lyItems">
										<li><a href="/help/notice?tab=1&SearchWord=">전체</a></li>
										<li><a href="/help/notice?tab=2&SearchWord=">일반공지</a></li>
										<li><a href="/help/notice?tab=3&SearchWord=">서비스오픈</a></li>
									</ul>
									 -->

										<select>
											<option value="전체" selected>전체</option>
											<option value="일반공지">일반공지</option>
											<option value="서비스">서비스</option>
											<option value="이벤트">이벤트</option>
										</select>



								</div>
							</th>
							<th scope="col">제목</th>
							<th scope="col">날짜</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="sort">공지</td>
							<td class="alLeft"><span class="tit"><a
									href="notices_detail.jsp">[시스템 점검 공지] 3/28(목) AM
										01시-05시</a></span></td>
							<td class="date">2024.03.19</td>
						</tr>
						<tr>
							<td class="sort">공지</td>
							<td class="alLeft"><span class="tit"><a
									href="/help/notice/view?no=14762">잡코리아 x 우리들파트너스 제휴, 기업회원
										이벤트</a></span></td>
							<td class="date">2024.03.11</td>
						</tr>
						<tr>
							<td class="sort">공지</td>
							<td class="alLeft"><span class="tit"><a
									href="/help/notice/view?no=14759">[이벤트] 원픽 채용 약정형 상품 출시</a></span></td>
							<td class="date">2024.02.26</td>
						</tr>
						<tr>
							<td class="sort">공지</td>
							<td class="alLeft"><span class="tit"><a
									href="/help/notice/view?no=14756">[시스템 점검 공지] 2/23(금) AM
										01시-05시</a></span></td>
							<td class="date">2024.02.19</td>
						</tr>
						<tr>
							<td class="sort">공지</td>
							<td class="alLeft"><span class="tit"><a
									href="/help/notice/view?no=14755">[사전공지] 기업회원 인재검색 무료 문자
										잔여건수 소멸 안내</a></span></td>
							<td class="date">2024.02.16</td>
						</tr>
					</tbody>
				</table>

				

				<!-- 		<div class="listBtmArea">
                <div class="btnListExDn">
                    <a href="notice_list.jsp" class="btnMtcTpl">목록</a>
                </div> -->
			
			<input type="button" value="작성" class="btn btn-info btn-sm" style="margin-top:20px; float:right">

				<div class="listBtmArea">
					<div class="tplPagination">

						<ul>

							<li><span class="now">1</span></li>
							<li><a href="/help/notice?tab=1&amp;Page=2" data-page="2">2</a></li>
							<li><a href="/help/notice?tab=1&amp;Page=3" data-page="3">3</a></li>

						</ul>

						<p>
							<a href="/help/notice?tab=2&amp;Page=11"
								class="tplBtn btnPgnNext" data-page="11"><span>다음 페이지</span></a>
						</p>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- golgolz end -->
</body>
</html>