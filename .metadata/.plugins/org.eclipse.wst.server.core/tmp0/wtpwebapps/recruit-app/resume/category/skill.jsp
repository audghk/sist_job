<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<div class="formWrap formWrapSkill" id="formSkill"
	style="display: block">
	<h2 class="header">스킬</h2>
	<div class="form">
		<div class="colum dev-input-skill" style="">
			<div id="skillAutoComplete" class="input input-search-wrap is-label"
				data-comp_type="jkAc">
				<label id="skillSearch" for="skillText">찾으시는 스킬이 있나요?</label> <input
					type="text" id="skillText" data-type="Skill_Name"
					data-comp_type="jkAcInput" autocomplete="off" maxlength="50" /> <input
					type="hidden" data-type="Skill_Name" />
				<button type="button" class="delete-button">delete</button>
				<button type="button" class="search-button">search</button>
				<div id="skillSearchResult" class="autocomplete hidden"
					aria-hidden="true" data-comp_type="jkAcResultWrap">
					<div class="list">
						<ul></ul>
					</div>
				</div>
			</div>
		</div>
		<div class="colum dev-input-skill" style="">
			<div class="plus-keyword-wrap">
				<div class="tap-list">
					<button type="button" class="tab-button on" data-code="1000229">
						백엔드개발자</button>
				</div>
				<div class="keyword-list"></div>
				<button type="button" class="button button-reset">초기화</button>
			</div>
		</div>
	</div>
	<div class="popup popupSkill hidden" aria-hidden="true">
		<div class="popupContainerWrap">
			<div class="popupHeader">
				<span class="dev-all-skill-title">백엔드개발자</span> 스킬 전체보기<span
					class="pagination"><em class="current">9</em>/20</span>
				<!-- <p>자신을 대표하는 스킬을 선택하세요.</p> -->
			</div>
			<div class="popupContainer">
				<div class="plus-keyword-wrap">
					<div class="keyword-list"></div>
				</div>
			</div>
			<div class="popupFooter">
				<div class="btn-wrap">
					<button type="button" class="btn cancel">취소</button>
					<button type="button" class="btn check">확인</button>
				</div>
			</div>
			<button type="button"
				class="button buttonClose is-event is-popup-hidden"
				data-target=".popupSkill">닫기</button>
		</div>
	</div>
</div>
<script type="text/template" id="tplSkillAutoComplete"></script>
<script type="text/template" id="tplSkillTabMenuItem"></script>
<script type="text/template" id="tplSkillItem"></script>
<script type="text/template" id="tplSelectedSkillItem"></script>
