<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../assets/layout/user/lib.jsp" />  
	<!-- golgolz start -->
    <link href="http://localhost/recruit-app/assets/css/recruit/part-sv-202405271315.css" rel="stylesheet" type="text/css"/>
    <link href="http://localhost/recruit-app/assets/css/recruit/rcr-sv-202405271315.css" rel="stylesheet" type="text/css"/>
	<!-- golgolz end -->
	<style text="text/css">
		<!-- golgolz start -->
		.lgiSubMain{
			z-index: -2;
		}
		<!-- golgolz end -->
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
				<div id="wrap" class="bg-gray lgiSubMain">
					<div id="container">
						<div id="content" class="clear" data-pagecode="AM"
							data-value-json='{"dutyCtgr":0,"duty":null,"dkwrd":null,"local":null,"subwayUpp":null,"subway":null,"career":null,"careerStart":null,"careerEnd":null,"edu":null,"cotype":null,"jobtype":null,"industryCtgr":0,"industry":null,"ikwrd":null,"position":null,"age":null,"pay":null,"paytype":null,"payinput":null,"sex":null,"majorCtgr":null,"major":null,"license":null,"pref":null,"wel":null,"textinclude":null,"textexclude":null,"IncludeAgeZero":false,"IncludeGenderIrrelevant":false,"iframeFlag":false,"monJobType":null,"monJobTypeArray":null,"monLocalArray":null,"menucode":"local","searchtype":"B","hasSubwayOnlyCache":false,"hasLocalOnlyCache":null,"dutyArr":null,"dkwrdArr":null,"localArr":null,"subwayUppArr":null,"subwayArr":null,"careerArr":null,"eduArr":null,"cotypeArr":null,"jobtypeArr":null,"industryArr":null,"ikwrdArr":null,"positionArr":null,"payArr":null,"majorCtgrArr":null,"majorArr":null,"licenseArr":null,"prefArr":null,"welArr":null,"textincludeArr":null,"textexcludeArr":null,"dutyCtgrSelect":null,"IndustryCtgrSelect":null,"dutySelect":null,"IndustrySelect":null,"localCtgrSelect":null,"majorCtgrSelect":null,"isAllDutySearch":false,"isAllLocalSearch":true}'>
							<h1 class="skip">메뉴별 채용공고</h1>
							<!-- Side Menu -->
							<div class="rcr_cnt" id="bbArea">
								<!-- 검색설정 -->
								<div class="cntWrap clear" id="devSearchForm"
									data-value-json='{"dutyCtgr":0,"duty":null,"dkwrd":null,"local":null,"subwayUpp":null,"subway":null,"career":null,"careerStart":null,"careerEnd":null,"edu":null,"cotype":null,"jobtype":null,"industryCtgr":0,"industry":null,"ikwrd":null,"position":null,"age":null,"pay":null,"paytype":null,"payinput":null,"sex":null,"majorCtgr":null,"major":null,"license":null,"pref":null,"wel":null,"textinclude":null,"textexclude":null,"IncludeAgeZero":false,"IncludeGenderIrrelevant":false,"iframeFlag":false,"monJobType":null,"monJobTypeArray":null,"monLocalArray":null,"menucode":"local","searchtype":"B","hasSubwayOnlyCache":false,"hasLocalOnlyCache":null,"dutyArr":null,"dkwrdArr":null,"localArr":null,"subwayUppArr":null,"subwayArr":null,"careerArr":null,"eduArr":null,"cotypeArr":null,"jobtypeArr":null,"industryArr":null,"ikwrdArr":null,"positionArr":null,"payArr":null,"majorCtgrArr":null,"majorArr":null,"licenseArr":null,"prefArr":null,"welArr":null,"textincludeArr":null,"textexcludeArr":null,"dutyCtgrSelect":null,"IndustryCtgrSelect":null,"dutySelect":null,"IndustrySelect":null,"localCtgrSelect":null,"majorCtgrSelect":null,"isAllDutySearch":false,"isAllLocalSearch":true}'
									data-search-type="">
									<h2 class="titDetailSch">채용공고 상세검색</h2>
									<!-- 최근 검색한 조건 -->
									<div class="detail-search-button">
										<div class="recentSetting">
											<button type="button" class="btn_rs on" id="devSearchedTerms">
												최근 검색한 조건 <strong>0건</strong>
											</button>
										</div>
									</div>
								</div>
								<div class="advertisement" style="display: none"></div>
								<!-- 채용공고리스트 -->
								<div id="dev-gi-list">
									<div class="tplJobListWrap devTplTabBx">
										<h2 class="bn_hd_2 blind">채용공고 리스트</h2>
										<input type="hidden" id="hdnGICnt" value=" 117,341" />
										<div class="tplTabBx jobListTab">
											<ul class="tplTab clear" id="anchorGICnt_1">
												<li class="on" data-tab-index="0">
													<button type="button">
														<span data-text="전체">전체 <em>(117,341건)</em></span>
													</button>
												</li>
											</ul>
										</div>

										<div class="tplJobListFunc clear">
											<div class="tplJobManBtn" id="toolGI">
												<div class="exceptSec">
													<div class="tplSltBx tplGiSlt devTplSltBx">
														<label for="sortTab">포함단어</label> <select name="sortTab"
															id="sortTab" class="tplSlt" title="공고 정렬순 선택">
															<option value="1" selected="">포함단어</option>
															<option value="2">제외단어</option>
														</select>
													</div>
													<div class="exceptWord">
														<input type="text" id="lb_exceptWord" name="includeText" />
														<label for="lb_exceptWord" class="dev-ph-label">기업명,
															공고제목 등 검색</label>
														<button type="button" id="dev-gi-search">
															<span class="blind">검색</span>
														</button>
													</div>
												</div>
												<div class="tplSltBx-wrap">
													<div class="tplSltBx tplGiSlt devTplSltBx">
														<div class="setRcmdTip clearfix" tabindex="0"
															style="display: none">
															<button type="button" id="dev-btn-recommanded-order"
																class="setRcmdSet">
																<em class="under">추천순 정렬</em>을 이용해보세요<em class="pnt">!</em>
															</button>
															<button type="button" id="dev-btn-recommanded-close"
																class="setRcmdClose">
																닫기</button>
														</div>
														<label for="sortTab">추천순</label> <select name="orderTab"
															id="orderTab" class="tplSlt" title="공고 정렬순 선택">
															<option value="2">등록일순</option>
															<option value="3">최신업데이트순</option>
															<option value="4">마감일순</option>
															<option value="5">경력순</option>
															<option value="7">학력순</option>
															<option value="20" selected="selected">추천순</option>
														</select>
													</div>
												</div>
											</div>
										</div>

										<div class="tplJobListFunc clear" style="display: none">
											<button type="button" class="tplBtn tplBtn_2 tplBtnApply">
												<span>지원하기</span>
											</button>
											<button type="button" class="tplBtn tplBtn_2 tplBtnScr">
												<span>스크랩</span>
											</button>
											<button type="button" class="tplBtn tplBtn_2 tplBtnFav">
												<span>관심기업</span>
											</button>
										</div>
										<div class="lySmMoreArea jkSidebarArea"></div>

										<div class="tplList tplJobList">
											<table
												summary="전체 채용정보 목록으로 회사명, 채용제목, 미리보기, 등록일·마감일로 구성되어 있습니다.">
												<caption>
													<span class="blind">전체 채용정보 목록</span>
												</caption>
												<colgroup>
													<col width="50px" />
													<col width="158px" />
													<col width="*" />
													<col width="82px" />
													<col width="120px" />
												</colgroup>
												<thead>
													<tr>
														<th scope="col">행 선택</th>
														<th scope="col">회사명</th>
														<th scope="col">채용제목</th>
														<th scope="col">미리보기</th>
														<th scope="col">등록일·마감일</th>
													</tr>
												</thead>
												<tbody>
													<tr class="devloopArea" data-effectctgr-code="0"
														data-info=" 44738554|47018175|arneg2|C|AM||487603">
														<th scope="row"><span class="tplChkRect tplChkRect_1">
														</span></th>
														<td class="tplCo">
															<!--app.svcFunc.clickCnt--> <a
															href="https://www.jobkorea.co.kr/Recruit/Co_Read/C/487603"
															class="link normalLog" data-clickctgrcode="B01"
															target="_blank">아르네코리아㈜</a>

															<div class="typ"></div>
														</td>
														<td class="tplTit">
															<div class="titBx">
																<strong><a
																	href="https://www.jobkorea.co.kr/Recruit/GI_Read/44738554?rPageCode=AM&amp;logpath=21&amp;sn=6"
																	class="link normalLog" title="[아르네코리아㈜] 개발팀 정규직 채용(광주)"
																	data-clickctgrcode="B02" target="_blank">[아르네코리아㈜]
																		개발팀 정규직 채용(광주)</a></strong>

																<p class="etc">
																	<span class="cell">신입·경력</span> <span class="cell">학력무관</span>
																	<span class="cell">광주 광산구 외</span> <span class="cell">정규직</span>

																	<span class="cell"></span>
																</p>
																<p class="dsc">기구설계, CAM, 제어·설계, 캐드원, A·S센터, 3D설계,
																	CDU, 중정비, 플랜트, 경정비, 제품개발, CAM, 2D설계, 생산기술, 검사소</p>
															</div>
														</td>
														<td class="tplPrv"></td>
														<td class="odd">
															<button type="button"
																class="tplBtn tplBtn_1 tplBtnOrg dev-btn-apply">
																<span>즉시지원</span>
															</button> <span class="time dotum"><span
																class="tahoma">05/22</span>(수) 등록</span> <span
															class="date dotum"><span
																class="tahoma">~06/07</span>(금)</span>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
										<div id="dvGIPaging">
											<div class="tplPagination newVer">
												<ul>
													<li><span class="now" data-page="1">1</span></li>
													<li><a
														href="https://www.jobkorea.co.kr/recruit/_GI_List?Page=2"
														data-page="2">2</a></li>
													<li><a
														href="https://www.jobkorea.co.kr/recruit/_GI_List?Page=3"
														data-page="3">3</a></li>
													<li><a
														href="https://www.jobkorea.co.kr/recruit/_GI_List?Page=4"
														data-page="4">4</a></li>
													<li><a
														href="https://www.jobkorea.co.kr/recruit/_GI_List?Page=5"
														data-page="5">5</a></li>
													<li><a
														href="https://www.jobkorea.co.kr/recruit/_GI_List?Page=6"
														data-page="6">6</a></li>
													<li><a
														href="https://www.jobkorea.co.kr/recruit/_GI_List?Page=7"
														data-page="7">7</a></li>
													<li><a
														href="https://www.jobkorea.co.kr/recruit/_GI_List?Page=8"
														data-page="8">8</a></li>
													<li><a
														href="https://www.jobkorea.co.kr/recruit/_GI_List?Page=9"
														data-page="9">9</a></li>
													<li><a
														href="https://www.jobkorea.co.kr/recruit/_GI_List?Page=10"
														data-page="10">10</a></li>
												</ul>

												<p>
													<a
														href="https://www.jobkorea.co.kr/recruit/_GI_List?Page=11"
														class="tplBtn btnPgnNext" data-page="11">다음<i
														class="ico"></i></a>
												</p>
											</div>
										</div>
									</div>
								</div>
								<!-- 전문채용관 링크영역 -->
								<div id="special_recruit"></div>
							</div>
						</div>
					</div>
				</div>
				<!-- golgolz end -->
			</section>
			<jsp:include page="../assets/layout/user/footer.jsp" />  
		</main>
	</div>
</body>
</html>