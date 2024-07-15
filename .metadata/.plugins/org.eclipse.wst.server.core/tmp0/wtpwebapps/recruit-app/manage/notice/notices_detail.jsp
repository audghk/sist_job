<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<!DOCTYPE html>
<html>
<head>

<jsp:include page="../../assets/layout/admin/lib.jsp" />

<style type="text/css">
	#notice_detail_view{margin:40px; padding-left:280px}
</style>

<script type="text/javascript">
	$(function(){
    	$("#notice_menu").addClass("bg-gradient-primary");
	});
</script>
<!-- golgolz start -->
<link href="https://i.jobkorea.kr/content/css/ver_2/event/banner.promotion-sv-202401301659.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/content/css/ver_2/common-sv-202405271315.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/common/gnb-sv-202405231305.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/content/css/ver_2/mtc/mtc_lounge-sv-202402231655.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/content/css/ver_2/help/help-sv-202402231655.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/layout/footer-sv-202405131313.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/pages/main/auto_search-sv-202405231305.css" rel="stylesheet" type="text/css" />
<!-- golgolz end -->
</head>
<body>
	<jsp:include page="../../assets/layout/admin/header.jsp" />
	<div>
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
							aria-current="page">공지사항 관리</li>
					</ol>
					<h6 class="font-weight-bolder mb-0">공지사항 관리</h6>
				</nav>
			</div>
		</nav>
	</main>
	</div>
	<!-- golgolz start -->
	<div>
	<div class="loungeContent noticeViewContent" id="notice_detail_view">
        <div class="topHdWrap clear">
            <h2 class="lug_hd_2">공지사항</h2>
        </div>

        <div class="noticeViewWrap">
            <p class="noticeTit">
                <span class="sort">공지</span>
                <span class="tit">무료 공고 게재건수 변경 안내</span>
                <span class="date" style="padding-left:800px; text-align: right;">2020.02.03</span>
            </p>
            <div class="noticeView">
                <!--// 공지사항 내용 -->
                        <p>안녕하세요. 잡코리아 운영자입니다.<br/><br/>잡코리아를 이용해주시는 기업회원님께 진심으로 감사 드리며,<br/>기업의 공고 무료 게재건수가 변경되어 안내드립니다.<br/><br/>■ 변경일<br/>- 2020년 2월 3일(월) <br/><br/>■ 변경내용<br/> - 무료진행 공고 건수 5건 → 10건<br/> - 금일까지 대기중이였던 무료공고는 게재시작일에 맞춰 진행 공고로 변경됩니다.<br/>   (무료 10건까지)<br/> <br/>항상 잡코리아를 이용해주시는 회원님께 진심으로 감사 말씀드리며<br/>더욱 좋은 서비스로 보답할 수 있도록 노력하겠습니다.<br/><br/>변경되는 정책에 관한 문의는 귀사의 전담 채용매니저 또는 고객센터에 연락주시면<br/>친절히 안내해 드리겠습니다.<br/><br/>감사합니다.<br/><br/><br/>▷ 관련 문의<br/>* [기업회원] <a href="http://www.jobkorea.co.kr/Text_Co/Co_Service_Home.asp" target="_blank"><font color="blue"><u>귀사의 전담직원 연락처 확인하기</u></font></a><br/><br/>* 고객센터 ☎ 1588-9350<br/><br/>감사합니다.<br/></p>

                <!-- 공지사항 내용 //-->
            </div>
            
                <div >
                <input type="button" class="btn btn-info btn-sm" value="목록">
                <input type="button" class="btn btn-info btn-sm" value="수정">
                <input type="button" class="btn btn-info btn-sm" value="삭제">
                <input type="button" class="btn btn-info btn-sm" value="숨김">
                   
            </div>
        </div>
    </div>
</div>
	<!-- golgolz end -->
</body>
</html>