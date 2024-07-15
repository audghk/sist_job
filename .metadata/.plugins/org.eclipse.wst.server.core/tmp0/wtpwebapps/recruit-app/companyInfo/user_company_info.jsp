<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../assets/layout/user/lib.jsp" />  
<!-- golgolz start -->
<meta charset="UTF-8">
<link href="https://i.jobkorea.kr/content/css/ver_2/event/banner.promotion-sv-202401301659.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr//content/css/ver_2/modules/swiper/4.3.3/swiper.min.css?v=202405291400" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/content/css/ver_2/common-sv-202405271315.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/common/gnb-sv-202405231305.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/content/css/ver_1/salary/modules-sv-202401301659.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/content/css/ver_1/salary/index-sv-202401301659.css" rel="stylesheet" type="text/css" />
<link href="https://i.jobkorea.kr/deploy/pc/dist/css/personal/layout/footer-sv-202405131313.css" rel="stylesheet" type="text/css" />
	<!-- golgolz end -->
<style text="text/css">
	#btnSearchCompany{width:70px; height:40px; background-color:#FFFFFF; border:1px solid #333; margin-left:5px; font-size:15px}
</style>
<script text="text/javascript">
	$(function(){
		<!-- golgolz start -->
		<!-- golgolz end -->
	});
</script>
</head>
<body>
    <div id="__next" data-reactroot="">
		<jsp:include page="../assets/layout/user/header.jsp" />
		<main class="JobsFeed_Jobsfeed__DpeV9">  
			<section class="Section_Section__P1hhc">
			<!-- golgolz start -->
			<div>
 <form id="frmSearchCompany" action="/Salary/Index#salarySearchCompany" method="get">
            <div class="row salarySearchCompany" id="salarySearchCompany">
                <div class="container">
                    <!-- <i class="icon iconTop" aria-hidden="true"></i> -->
                    <div class="search searchCompany">
                       <!--  <div class="description"><em><strong>57</strong>만 기업</em>이 등록되어 있습니다.</div> -->
                       <!--  <div class="input inputSearch" id="searchCommon">
                            <label for="lbl_search" class="skip">검색</label>
                            <input id="txtCompanyName" name="coKeyword" placeholder="기업명을 검색해 보세요." type="text" value="" autocomplete="off" />
                            <button id="btnSearchCompany" type="button" class="button buttonSearch">검색</button> -->
                           <div class="popup" aria-live="polite" aria-hidden="true" id="autocompletePane">
                                <div class="noResult" id="noResultPane" style="display:none">
                                    <p>검색 결과가 없음.</p>
                                </div>
                                <div class="list" id="recommendPane" style="display:none">
                                    <ul></ul>
                                </div>
                                <div class="list" id="resultPane" style="display:none">
                                    <ul></ul>
                                </div>
                                <div class="popupFooter" id="recommendButtonPane" style="display:none">
                                    <button type="button" class="button buttonDeleteAll"><span>전체삭제</span></button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="filter" style="display: inline-block; text-align: left;">
                        <div class="label" style="display: inline-block; text-align: left;">선택조건 검색</div>
                        <div class="buttons" style="display: inline-block; text-align: left;">
                            <button type="button" class="button tab tab1 selected" aria-selected="false" data-tab="0"><span>전체</span></button>
                            <button type="button" class="button tab tab3" aria-selected="true" data-tab="2"><span>직무별</span></button>
                            <select value="직무 선택" style="margin-left:10px; margin-right:10px; width:100px; height:40px">
                            	<option name="w1" value="기획">기획</option>
                            	<option name="w2" value="법무">법무</option>
                            	<option name="w3" value="인사">인사</option>
                            	<option name="w4" value="회계">회계</option>
                            	<option name="w5" value="마케팅">마케팅</option>
                            </select>
                            <!-- <input type="hidden" name="tabindex" id="hidTabIndex" value="0" /> -->
                             <div class="input inputSearch" id="searchCommon" style="width:300px">
                            <input id="txtCompanyName" name="coKeyword" placeholder="기업명을 검색해 보세요." type="text" value="" autocomplete="off" style="width:300px"/>
                        	</div>
                            <input type="button" id="btnSearchCompany" value="검색"/>
                       </div>
                        <div class="dropdown category3 hidden" id="ddlJobType" aria-hidden="true">
                            <input type="hidden" name="jobTypeCode" id="hidJobTypeCode" value="" />
                            <button type="button" class="buttonChoose " aria-haspopup="true"><span>직무선택</span></button>
                            <!-- <div class="list" aria-hidden="true">
                                <ul>
                                    <li><button type="button"><span data-code="0">직무선택</span></button></li>
                                        <li><button type="button"><span data-code="10026">기획&#183;전략</span></button></li>
                                        <li><button type="button"><span data-code="10027">법무&#183;사무&#183;총무</span></button></li>
                                        <li><button type="button"><span data-code="10028">인사&#183;HR</span></button></li>
                                        <li><button type="button"><span data-code="10029">회계&#183;세무</span></button></li>
                                        <li><button type="button"><span data-code="10030">마케팅&#183;광고&#183;MD</span></button></li>
                                        <li><button type="button"><span data-code="10031">개발&#183;데이터</span></button></li>
                                        <li><button type="button"><span data-code="10032">디자인</span></button></li>
                                        <li><button type="button"><span data-code="10033">물류&#183;무역</span></button></li>
                                        <li><button type="button"><span data-code="10034">운전&#183;운송&#183;배송</span></button></li>
                                        <li><button type="button"><span data-code="10035">영업</span></button></li>
                                        <li><button type="button"><span data-code="10036">고객상담&#183;TM</span></button></li>
                                        <li><button type="button"><span data-code="10037">금융&#183;보험</span></button></li>
                                        <li><button type="button"><span data-code="10038">식&#183;음료</span></button></li>
                                        <li><button type="button"><span data-code="10039">고객서비스&#183;리테일</span></button></li>
                                        <li><button type="button"><span data-code="10040">엔지니어링&#183;설계</span></button></li>
                                        <li><button type="button"><span data-code="10041">제조&#183;생산</span></button></li>
                                        <li><button type="button"><span data-code="10042">교육</span></button></li>
                                        <li><button type="button"><span data-code="10043">건축&#183;시설</span></button></li>
                                        <li><button type="button"><span data-code="10044">의료&#183;바이오</span></button></li>
                                        <li><button type="button"><span data-code="10045">미디어&#183;문화&#183;스포츠</span></button></li>
                                        <li><button type="button"><span data-code="10046">공공&#183;복지</span></button></li>
                                </ul>
                            </div> -->
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row salaryList salaryCompanyList">
                <input type="hidden" id="hidMemChk" value="0" />
                <div class="container">
                    <div class="listHeader">

                        <div class="total">총 <em>572,139</em>건<span class="subtitle">(전체 평균연봉)</span></div>
                        <!-- <div class="sort">
                            <input type="hidden" name="haveAGI" id="hidHaveAGI" value="0" />
                            <button type="button" class="button buttonViewOnlyCompany " id="btnHaveAGI">
                                <span>채용중 기업만 보기</span>
                            </button>
                            <input type="hidden" name="orderCode" id="hidOrderCode" value="2" />
                            <div class="dropdown" id="ddlSort">
                                <button type="button" class="buttonChoose" aria-haspopup="true"><span>인기검색순</span></button>
                                <div class="list" aria-hidden="true">
                                    <ul>
                                        <li><button type="button"><span data-index="2">인기검색순</span></button></li>
                                        <li><button type="button"><span data-index="1">업데이트순</span></button></li>
                                        <li><button type="button"><span data-index="3">평균연봉 높은순</span></button></li>
                                        
                                        <li><button type="button"><span data-index="5">사원 많은순</span></button></li>
                                    </ul>
                                </div>
                            </div>
                        </div> -->
                    </div>
                    <div class="noData" id="listNoData"   style="display:none"  >

                        <p><strong>‘직무선택’</strong>에 대한 검색결과가 없습니다.<br>다른 검색어로 검색해주세요.</p>
                    </div>

                    <ul class="list" id="listCompany" >
                            <li>
                                <a href="/Company/1696583/Salary?C_IDX=1" target="_blank">
                                        <div class="thumbnail">
                                            <img src="//imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2023/9/09/JK_CO_msyvfp23090915182940.jpg?v=202406041618" onerror="companylogoOnError('/salary/logourl?ucono=1696583' , this)">
                                            <div class="inner">삼성전자㈜</div>
                                        </div>
                                    <div class="headers">
                                        <div class="text">삼성전자㈜</div>
                                            <button type="button" class="button buttonFavorites" onclick="jk.biz.core.layerlogin.loginCheckAndGo(null, this, [], '/Salary/Index#listCompany', 1);return false;" data-mem-sys="">좋아요</button>
                                                                            </div>
                                    <div class="summary">
                                                                                    <div class="item">매출액 170조 3천억원</div>
                                                                                    <div class="item">사원수 124,404명</div>
                                    </div>
                                    <div class="salary">
                                        <div class="inner"><strong>10,377</strong>만원</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="/Company/1360583/Salary?C_IDX=7" target="_blank">
                                        <div class="thumbnail">
                                            <img src="//imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2016/13/2x9an00bXu_cGpzromp2d3g26u0hnVfRd_akkj2qnu.jpg?v=202406041618&amp;hash=r&amp;serviceCode=CL" onerror="companylogoOnError('/salary/logourl?ucono=1360583' , this)">
                                            <div class="inner">현대자동차㈜</div>
                                        </div>
                                    <div class="headers">
                                        <div class="text">현대자동차㈜</div>
                                    </div>
                                    <div class="summary">
                                            <div class="item">자동차&#183;조선&#183;철강&#183;항공</div>
                                                                                    <div class="item">매출액 78조 3백억원</div>
                                                                                    <div class="item">사원수 73,500명</div>
                                    </div>
                                    <div class="salary">
                                        <div class="inner"><strong>11,742</strong>만원</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="/Company/1517115/Salary?C_IDX=2167" target="_blank">
                                        <div class="thumbnail">
                                            <img src="//imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2023/6/23/JK_CO_kXmqMBL23062314335619.png?v=202406041618" onerror="companylogoOnError('/salary/logourl?ucono=1517115' , this)">
                                            <div class="inner">잡코리아(유)</div>
                                        </div>
                                    <div class="headers">
                                        <div class="text">잡코리아(유)</div>
                                            <button type="button" class="button buttonFavorites" onclick="jk.biz.core.layerlogin.loginCheckAndGo(null, this, [], '/Salary/Index#listCompany', 1);return false;" data-mem-sys="">좋아요</button>
                                                                                    <div class="badge">채용중</div>
                                    </div>
                                    <div class="summary">
                                            <div class="item">포털&#183;컨텐츠&#183;커뮤니티</div>
                                                                                                                            <div class="item">사원수 530명</div>
                                    </div>
                                    <div class="salary">
                                        <div class="inner"><strong>6,132</strong>만원</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="/Company/1508733/Salary?C_IDX=354" target="_blank">
                                        <div class="thumbnail">
                                            <img src="//imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2022/1/06/JK_CO_YMc0NQg22010611014030.jpg?v=202406041618" onerror="companylogoOnError('/salary/logourl?ucono=1508733' , this)">
                                            <div class="inner">하이트진로㈜</div>
                                        </div>
                                    <div class="headers">
                                        <div class="text">하이트진로㈜</div>
                                            <button type="button" class="button buttonFavorites" onclick="jk.biz.core.layerlogin.loginCheckAndGo(null, this, [], '/Salary/Index#listCompany', 1);return false;" data-mem-sys="">좋아요</button>
                                                                            </div>
                                    <div class="summary">
                                            <div class="item">식품가공</div>
                                                                                    <div class="item">매출액 2조 2,467억원</div>
                                                                                    <div class="item">사원수 3,013명</div>
                                    </div>
                                    <div class="salary">
                                        <div class="inner"><strong>11,250</strong>만원</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="/Company/1532033/Salary?C_IDX=6021" target="_blank">
                                        <div class="thumbnail">
                                            <img src="//imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2016/10/2w3bs008Rw_eXiu3zl3d24w0esYbUq_vx2sw.gif?v=202406041618&amp;hash=r&amp;serviceCode=CL" onerror="companylogoOnError('/salary/logourl?ucono=1532033' , this)">
                                            <div class="inner">쿠팡</div>
                                        </div>
                                    <div class="headers">
                                        <div class="text">쿠팡</div>
                                            <button type="button" class="button buttonFavorites" onclick="jk.biz.core.layerlogin.loginCheckAndGo(null, this, [], '/Salary/Index#listCompany', 1);return false;" data-mem-sys="">좋아요</button>
                                                                                    <div class="badge">채용중</div>
                                    </div>
                                    <div class="summary">
                                            <div class="item">쇼핑몰&#183;오픈마켓&#183;소셜커머스</div>
                                                                                    <div class="item">매출액 4조 4227억원</div>
                                                                                    <div class="item">사원수 6,372명</div>
                                    </div>
                                    <div class="salary">
                                        <div class="inner"><strong>5,011</strong>만원</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="/Company/1710438/Salary?C_IDX=1258" target="_blank">
                                        <div class="thumbnail">
                                            <img src="//imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2021/10/21/2q1jz007Pq_qWla2i3a2oq0dzMjSz_uqzq.jpg?v=202406041618&amp;hash=r&amp;serviceCode=CL" onerror="companylogoOnError('/salary/logourl?ucono=1710438' , this)">
                                            <div class="inner">㈜하나투어</div>
                                        </div>
                                    <div class="headers">
                                        <div class="text">㈜하나투어</div>
                                            <button type="button" class="button buttonFavorites" onclick="jk.biz.core.layerlogin.loginCheckAndGo(null, this, [], '/Salary/Index#listCompany', 1);return false;" data-mem-sys="">좋아요</button>
                                                                                    <div class="badge">채용중</div>
                                    </div>
                                    <div class="summary">
                                            <div class="item">호텔&#183;여행&#183;항공</div>
                                                                                                                            <div class="item">사원수 1,297명</div>
                                    </div>
                                    <div class="salary">
                                        <div class="inner"><strong>4,542</strong>만원</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="/Company/1385349/Salary?C_IDX=8" target="_blank">
                                        <div class="thumbnail">
                                            <img src="//imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2017/6/2130s008R-_4X9u1963523-0esY8U6_5-2s-.jpg?v=202406041618&amp;hash=r&amp;serviceCode=CL" onerror="companylogoOnError('/salary/logourl?ucono=1385349' , this)">
                                            <div class="inner">엘지전자㈜</div>
                                        </div>
                                    <div class="headers">
                                        <div class="text">엘지전자㈜</div>
                                            <button type="button" class="button buttonFavorites" onclick="jk.biz.core.layerlogin.loginCheckAndGo(null, this, [], '/Salary/Index#listCompany', 1);return false;" data-mem-sys="">좋아요</button>
                                                                                    <div class="badge">채용중</div>
                                    </div>
                                    <div class="summary">
                                            <div class="item">전기&#183;전자&#183;제어</div>
                                                                                    <div class="item">매출액 28조 8천억원</div>
                                                                                    <div class="item">사원수 35,055명</div>
                                    </div>
                                    <div class="salary">
                                        <div class="inner"><strong>8,498</strong>만원</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="/Company/1834120/Salary?C_IDX=21" target="_blank">
                                        <div class="thumbnail">
                                            <img src="//imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2019/7/2a3fc008Rw_hXifqag3d2ww0ecYrUr_cx2cw.jpg?v=202406041618&amp;hash=r&amp;serviceCode=CL" onerror="companylogoOnError('/salary/logourl?ucono=1834120' , this)">
                                            <div class="inner">SOIL</div>
                                        </div>
                                    <div class="headers">
                                        <div class="text">SOIL</div>
                                            <button type="button" class="button buttonFavorites" onclick="jk.biz.core.layerlogin.loginCheckAndGo(null, this, [], '/Salary/Index#listCompany', 1);return false;" data-mem-sys="">좋아요</button>
                                                                            </div>
                                    <div class="summary">
                                            <div class="item">화학&#183;에너지&#183;환경</div>
                                                                                    <div class="item">매출액 35조 2천억원</div>
                                                                                    <div class="item">사원수 3,174명</div>
                                    </div>
                                    <div class="salary">
                                        <div class="inner"><strong>17,109</strong>만원</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="http://localhost/recruit-app/companyInfo/user_company_detail.jsp" target="_blank">
                                        <div class="thumbnail">
                                            <img src="//imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2011/10/2w1aj007Pm_gWzi2y3i2jm0djMcSj_ldjm.gif?v=202406041618&amp;hash=r&amp;serviceCode=CL" onerror="companylogoOnError('/salary/logourl?ucono=1882711' , this)">
                                            <div class="inner">넥슨코리아</div>
                                        </div>
                                    <div class="headers">
                                        <div class="text">넥슨코리아</div>
                                    </div>
                                    <div class="summary">
                                            <div class="item">컴퓨터&#183;하드웨어&#183;장비</div>
                                                                                    <div class="item">매출액 3조 9000억</div>
                                                                                    <div class="item">사원수 3,500명</div>
                                    </div>
                                    <div class="salary">
                                        <div class="inner"><strong>6,751</strong>만원</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="/Company/1487996/Salary?C_IDX=39" target="_blank">
                                        <div class="thumbnail">
                                            <img src="//imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2022/13/2539s008R-_2X0u8923829-0esY8U9_8-2s-.gif?v=202406041618&amp;hash=r&amp;serviceCode=CL" onerror="companylogoOnError('/salary/logourl?ucono=1487996' , this)">
                                            <div class="inner">대한항공</div>
                                        </div>
                                    <div class="headers">
                                        <div class="text">대한항공</div>
                                            <button type="button" class="button buttonFavorites" onclick="jk.biz.core.layerlogin.loginCheckAndGo(null, this, [], '/Salary/Index#listCompany', 1);return false;" data-mem-sys="">좋아요</button>
                                                                            </div>
                                    <div class="summary">
                                            <div class="item">자동차&#183;조선&#183;철강&#183;항공</div>
                                                                                    <div class="item">매출액 14조 5천억원</div>
                                                                                    <div class="item">사원수 17,931명</div>
                                    </div>
                                    <div class="salary">
                                        <div class="inner"><strong>9,806</strong>만원</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="/Company/1976007/Salary?C_IDX=924" target="_blank">
                                        <div class="thumbnail">
                                            <img src="//imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2020/12/16/2v7pq00aRn_zKldafzno3j2wn0gqYeIm_vpnw2qn.gif?v=202406041618&amp;hash=r&amp;serviceCode=CL" onerror="companylogoOnError('/salary/logourl?ucono=1976007' , this)">
                                            <div class="inner">카카오</div>
                                        </div>
                                    <div class="headers">
                                        <div class="text">카카오</div>
                                            <button type="button" class="button buttonFavorites" onclick="jk.biz.core.layerlogin.loginCheckAndGo(null, this, [], '/Salary/Index#listCompany', 1);return false;" data-mem-sys="">좋아요</button>
                                                                                    <div class="badge">채용중</div>
                                    </div>
                                    <div class="summary">
                                            <div class="item">포털&#183;컨텐츠&#183;커뮤니티</div>
                                                                                    <div class="item">매출액 2조 4,995억원</div>
                                                                                    <div class="item">사원수 3,680명</div>
                                    </div>
                                    <div class="salary">
                                        <div class="inner"><strong>10,209</strong>만원</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="/Company/16154114/Salary?C_IDX=8696" target="_blank">
                                        <div class="thumbnail">
                                            <img src="//imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2022/9/16/JK_CO_Gv7v7T422091611283337.JPG?v=202406041618" onerror="companylogoOnError('/salary/logourl?ucono=16154114' , this)">
                                            <div class="inner">메가스터디교육</div>
                                        </div>
                                    <div class="headers">
                                        <div class="text">메가스터디교육</div>
                                            <button type="button" class="button buttonFavorites" onclick="jk.biz.core.layerlogin.loginCheckAndGo(null, this, [], '/Salary/Index#listCompany', 1);return false;" data-mem-sys="">좋아요</button>
                                                                                    <div class="badge">채용중</div>
                                    </div>
                                    <div class="summary">
                                            <div class="item">학원&#183;어학원&#183;교육원</div>
                                                                                    <div class="item">매출액 8,356억</div>
                                                                                    <div class="item">사원수 1,700명</div>
                                    </div>
                                    <div class="salary">
                                        <div class="inner"><strong>4,177</strong>만원</div>
                                    </div>
                                </a>
                            </li>
                    </ul>

                    <div class="paginations" role="navigation" id="listPaging" >
                        <input type="hidden" id="hidCoPage" name="coPage" value="1" />
                                                        <strong class="item active">1</strong>
                               <!--  <a href="#" class="item" data-page="2">2</a>
                                <a href="#" class="item" data-page="3">3</a>
                                <a href="#" class="item" data-page="4">4</a>
                                <a href="#" class="item" data-page="5">5</a>
                                <a href="#" class="item" data-page="6">6</a>
                                <a href="#" class="item" data-page="7">7</a>
                                <a href="#" class="item" data-page="8">8</a>
                                <a href="#" class="item" data-page="9">9</a>
                                <a href="#" class="item" data-page="10">10</a> -->

                            <!-- <a href="#" class="item next" data-page="11">다음</a> -->
                    </div>

                </div>
            </div>
</form>
</div>
			
			<!-- golgolz end -->
			</section>
			<jsp:include page="../assets/layout/user/footer.jsp" />  
		</main>
	</div>
</body>
</html>