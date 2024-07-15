<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<div class="formWrap formWrapProfile">
	<h2 class="header">
		인적사항
		<div class="description">
			<span class="star">*</span> 필수 입력 정보입니다.
		</div>
	</h2>
	<div class="form formProfile">
		<div class="row">
			<div class="input is-label input-profile-name is-value">
				<label for="UserInfo_M_Name">이름 <span class="star">*</span></label>
				<input type="text" class="dev-essential" name="UserInfo.M_Name"
					id="UserInfo_M_Name" value="우미연" data-format-type="name" />
				<div class="validation hidden" aria-hidden="true"></div>
			</div>
			<div class="input is-label input-profile-birth is-value">
				<label for="UserInfo_M_Born">생년월일 <span
					class="star">*</span></label> <input class="dev-essential"
					data-format-type="birth" data-max-date="2009.06.01" data-val="true"
					data-val-date="생년월일 필드는 날짜여야 합니다." id="UserInfo_M_Born"
					name="UserInfo.M_Born" placeholder="1988.03.01" type="text"
					value="1996-08-21 오전 12:00:00" />
				<div class="validation hidden" aria-hidden="true"></div>
			</div>
			<div class="dropdown dropdown-profile-sex is-label selected">
				<div class="label" aria-hidden="true">
					성별 <span class="star">*</span>
				</div>
				<button type="button" class="button buttonChoose dev-essential"
					aria-haspopup="true">
					<span>여자</span>
				</button>
				<div class="list hidden" aria-hidden="true">
					<ul>
						<li>
							<button type="button" class="button" data-value="False">
								<span>남자</span>
							</button>
						</li>
						<li>
							<button type="button" class="button" data-value="True">
								<span>여자</span>
							</button>
						</li>
					</ul>
				</div>
				<div class="validation hidden" aria-hidden="true">성별을 입력해주세요</div>
				<input class="dev-essential" id="UserInfo_M_Gender"
					name="UserInfo.M_Gender" type="hidden" value="True" />
			</div>
			<div class="input input-profile-email is-label is-value">
				<label for="UserInfo_M_Email">이메일 <span class="star">*</span></label>
				<input type="email" name="UserInfo.M_Email" id="UserInfo_M_Email"
					data-format-type="email" value="yeon.dev.8@gmail.com"
					autocomplete="off" spellcheck="false" class="dev-essential"
					data-privacy="이메일" />
				<div class="autocomplete hidden" aria-hidden="true">
					<div class="list">
						<ul></ul>
					</div>
				</div>
				<div class="validation hidden" aria-hidden="true"></div>
				<div class="backdrop">
					<div class="highlights"></div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="input is-label input-profile-tel is-value">
				<label for="UserInfo_M_Hand_Phone">전화번호 <span
					class="star">*</span></label> <input type="text"
					name="UserInfo.M_Hand_Phone" id="UserInfo_M_Hand_Phone"
					placeholder="010-1234-1234" value="010-1234-1234" maxlength="30"
					autocomplete="off" data-format-type="hp" class="dev-essential" />
				<div class="validation hidden" aria-hidden="true"></div>
			</div>
			<div class="input is-label input-profile-hp is-value">
				<label for="UserInfo_M_Hand_Phone">휴대폰번호 <span
					class="star">*</span></label> <input type="text"
					name="UserInfo.M_Hand_Phone" id="UserInfo_M_Hand_Phone"
					placeholder="010-1234-1234" value="010-1234-1234" maxlength="30"
					autocomplete="off" data-format-type="hp" class="dev-essential" />
				<div class="validation hidden" aria-hidden="true"></div>
			</div>
			<input id="UserInfo_M_Zipcode" name="UserInfo.M_Zipcode"
				type="hidden" value="" /> <input id="UserInfo_M_AddAddr"
				name="UserInfo.M_AddAddr" type="hidden" value="" /> <input
				id="UserInfo_M_AddrType" name="UserInfo.M_AddrType" type="hidden"
				value="L" /> <a href="javascript:post_check();"
				class="input is-label input-profile-addr"> <label
				for="temp_M_Addr_Text">주소</label> <input type="text"
				id="temp_M_Addr_Text" readonly="" class="dev-optional"
				data-privacy="주소" /> <input id="UserInfo_M_Addr_Text"
				name="UserInfo.M_Addr_Text" type="hidden" value="" /> <input
				id="UserInfo_M_Addr_Text1" name="UserInfo.M_Addr_Text1"
				type="hidden" value="" />&gt; <i class="icon icon-search"
				aria-hidden="true"></i>
			</a>
		</div>

		<div class="picture dropped" style="">
			<div class="guide">사진추가</div>
			<a href="javascript:;" class="buttonAddFile"> 사진등록 </a>
			<div class="image hidden">
				<input type="hidden" class="dev-optional dev-photo"
					data-privacy="사진" value="False" /> <img
					src="https://www.jobkorea.co.kr/User/Resume/Write" />
			</div>
			<button type="button" class="button buttonChangePicture"
				aria-hidden="false" style="display: none">
				<span>사진변경</span>
			</button>
			<button type="button" class="button buttonDelete" aria-hidden="false"
				style="display: none">삭제</button>
		</div>
	</div>
</div>
