<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../assets/layout/admin/lib.jsp" />

<link href="https://i.jobkorea.kr/content/css/ver_2/event/banner.promotion-sv-202401301659.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/content/css/ver_2/common-sv-202405271315.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/common/gnb-sv-202405231305.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/content/css/ver_2/mtc/mtc_lounge-sv-202402231655.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/content/css/ver_2/help/help-sv-202402231655.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/layout/footer-sv-202405131313.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/pages/main/auto_search-sv-202405231305.css" rel="stylesheet" type="text/css" />

<style type="text/css">
	#newQnaFrm{margin-left:300px; margin-right:40px}
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
	<div class="loungeContent inquiryContent" id="newQnaFrm">
					<div class="topHdWrap">
						<!-- <h2 class="lug_hd_2">문의</h2> -->
					</div>

					<!--// 내 제안내역 보기 상세 -->
					<div class="inquiryViewWrap">
						<div class="inquiryView">
							<div class="viewCont">
								<dl class="inqCont">
									<dt><strong>[제안/문의]</strong> 2024.05.24</dt>
									<dd>기업 리뷰는 어떻게 확인하는지 궁금합니다.</dd>
								</dl>
							</div>

							<div class="viewCont">
								<!-- <dl class="inqCont">
									<dt><strong>[답변]</strong> 2024.05.24</dt>
									<dd>안녕하세요? 회원님, 잡코리아 고객센터입니다.<br/>언제나 잡코리아를 믿고 이용해 주시는 회원님께 진심으로 감사의 마음을 전합니다.<br/><br/>회원님, MY기업 리뷰에서 작성하신 내용은 통계 자료로 반영 되는 부분이며 작성하신 리뷰 문장 자체가 노출되는 것은 아닙니다. (기업에서도 어느분이 작성하셨는지 확인 불가)<br/>자세한 리뷰 현황은 아래 페이지를 참고 부탁 드리겠습니다.<br/><br/>https://www.jobkorea.co.kr/Review/Home<br/><br/>잡코리아를 믿고 이용해 주시는 만큼 회원님의 기대에 어긋나지 않도록 최선을 다하겠습니다.<br/>이용해 보시고 이외 다른 문의사항이 있으시면 언제든지 말씀 남겨주세요.<br/>친절하고 신속하게 답변드리겠습니다.<br/><br/>감사합니다.</dd>
								</dl> -->
							</div>
						</div>

						
							<div class="btnListExDn">
								<a href="new_qnas_list.jsp" class="btnMtcTpl">목록</a> 
								<a href="qna_answer_frm.jsp" class="btnMtcTpl">답변하기</a>
							</div>
							<!-- <button type="button" onclick="javascript:window.scrollTo(0,0);" class="btnMtcTpl">TOP</button> -->
						
					</div>
					<!-- 내 제안내역 보기 상세 //-->
				</div>
		</div>
	<!-- golgolz end -->
</body>
</html>