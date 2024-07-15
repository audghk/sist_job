<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../assets/layout/user/lib.jsp" />  
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<!-- bootstrap start -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.ko.min.js"></script> 
	<!-- bootstrap end -->
	<!-- golgolz start -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="preload"
		href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-dynamic-subset.min.css"
		as="style">
	<link rel="preload"
		href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-std-dynamic-subset.min.css"
		as="style">
	<link rel="preload"
		href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-jp-dynamic-subset.min.css"
		as="style">
	<meta name="viewport" content="width=device-width">
	<title>Wanted OneID</title>
	<meta name="description" content="모든 원티드 서비스를 하나의 계정으로 이용할 수 있습니다.">
	<meta property="og:description" content="모든 원티드 서비스를 하나의 계정으로 이용할 수 있습니다.">
	<meta property="og:image" content="https://image.wanted.co.kr/wantedoneid/meta_image_default_new.jpg">
	<link rel="shortcut icon" href="https://static.wanted.co.kr/favicon/new/favicon.ico">
	<link rel="icon" type="image/png" sizes="16x16" href="https://static.wanted.co.kr/favicon/new/favicon-16x16.png">
	<link rel="icon" type="image/png" sizes="32x32" href="https://static.wanted.co.kr/favicon/new/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="https://static.wanted.co.kr/favicon/new/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="192x192"
		href="https://static.wanted.co.kr/favicon/new/favicon-192x192.png">
	<link rel="apple-touch-icon" sizes="57x57"
		href="https://static.wanted.co.kr/favicon/new/apple-touch-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60"
		href="https://static.wanted.co.kr/favicon/new/apple-touch-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72"
		href="https://static.wanted.co.kr/favicon/new/apple-touch-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76"
		href="https://static.wanted.co.kr/favicon/new/apple-touch-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114"
		href="https://static.wanted.co.kr/favicon/new/apple-touch-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120"
		href="https://static.wanted.co.kr/favicon/new/apple-touch-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144"
		href="https://static.wanted.co.kr/favicon/new/apple-touch-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152"
		href="https://static.wanted.co.kr/favicon/new/apple-touch-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180"
		href="https://static.wanted.co.kr/favicon/new/apple-touch-icon-180x180.png">
	<link rel="dns-prefetch" href="https://asset.wanted.co.kr/">
	<link rel="preconnect" href="https://asset.wanted.co.kr/">
	<link rel="preconnect" href="https://cdn.jsdelivr.net/" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.icomoon.io/78252/wantedicon/style-cf.css" media="screen">
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-std-dynamic-subset.min.css">
	<link rel="stylesheet" type="text/css"
		href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-dynamic-subset.min.csss">
	<link rel="stylesheet" type="text/css"
		href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-jp-dynamic-subset.min.css">
	<style>
		.async-hide {
			opacity: 0 !important;
		}
	</style>
	<meta name="next-head-count" content="32" />
	<link rel="preload" href="https://asset.wanted.co.kr/id-front/www/_next/static/css/9efeb41d609df83e.css" as="style"
		crossorigin="anonymous" />
	<link rel="stylesheet" href="https://asset.wanted.co.kr/id-front/www/_next/static/css/9efeb41d609df83e.css"
		crossorigin="anonymous" data-n-g="" />
	<!-- golgolz end -->
	<style data-emotion="css-global" data-s="">
		:root {
			--theme-palette-primary-normal: #0066ff;
		}

		html,
		body,
		#__next {
			padding: 0;
			margin: 0;
			width: 100%;
			height: 100%;
			min-width: 320px;
			text-rendering: optimizeLegibility;
			-webkit-font-smoothing: antialiased;
			-webkit-text-size-adjust: none;
			word-break: keep-all;
			overflow-wrap: anywhere;
		}

		a {
			color: inherit;
			-webkit-text-decoration: none;
			text-decoration: none;
		}

		* {
			box-sizing: border-box;
			margin: 0;
			padding: 0;
		}

		* {
			font-family: Pretendard, 'Pretendard JP', 'Pretendard Std', -apple-system, system-ui, BlinkMacSystemFont, Roboto, 'Segoe UI', Helvetica, Arial, 'Apple SD Gothic Neo', 'Malgun Gothic', 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol', sans-serif;
		}

		html:lang(ja) * {
			font-family: 'Pretendard JP', Pretendard, 'Pretendard Std', -apple-system, system-ui, BlinkMacSystemFont, Roboto, 'Segoe UI', Helvetica, Arial, 'Hiragino Sans', 'Yu Gothic', Meiryo, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol', sans-serif;
			word-break: break-all;
		}

		html:lang(en_US) * {
			font-family: 'Pretendard Std', Pretendard, 'Pretendard JP', -apple-system, system-ui, BlinkMacSystemFont, Roboto, 'Segoe UI', Helvetica, Arial, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol', sans-serif;
		}
	</style>
	<style data-emotion="JobsFeed_Jobsfeed__DpeV9" data-s="">
		.JobsFeed_Jobsfeed__DpeV9 {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-flex-direction: column;
			-ms-flex-direction: column;
			flex-direction: column;
			-webkit-align-items: center;
			-webkit-box-align: center;
			-ms-flex-align: center;
			align-items: center;
			min-height: 100%;
		}
	</style>
	<style data-emotion="css k82zmk" data-s="">
		.css-k82zmk {
			width: 100%;
			height: 60px;
			min-height: 60px;
			border-bottom: 1px solid #0000000d;
			background: linear-gradient(0deg,
					rgba(255, 255, 255, 0.7) 0%,
					rgba(255, 255, 255, 0.7 100%),
					linear-gradient(0deg,
						#ffffff 0%,
						#ffffff 100%),
					#000000);
			background-blend-mode: normal, soft-light, normal;
			-webkit-backdrop-filter: blur(32px);
			backdrop-filter: blur(32px);
		}

		@media (max-width: 767px) {
			.css-k82zmk {
				display: none;
				position: relative;
				z-index: 1;
			}
		}
	</style>
	<style data-emotion="css 11mea6q" data-s="">
		.css-11mea6q {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-align-items: center;
			-webkit-box-align: center;
			-ms-flex-align: center;
			align-items: center;
			max-width: 1060px;
			width: 100%;
			height: 100%;
			margin: 0 auto;
			padding: 14px 20px;
		}

		.css-11mea6q>button {
			background-color: transparent;
			border: none;
			cursor: pointer;
		}
	</style>
	<style data-emotion="css 1ihsymv" data-s="">
		.css-1ihsymv {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-align-items: inherit;
			-webkit-box-align: inherit;
			-ms-flex-align: inherit;
			align-items: inherit;
			-webkit-box-pack: inherit;
			-ms-flex-pack: inherit;
			-webkit-justify-content: inherit;
			justify-content: inherit;
		}
	</style>
	<style data-emotion="css zaf2lb" data-s="">
		.css-zaf2lb {
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
			width: 1em;
			height: 1em;
			display: inline-block;
			fill: currentColor;
			-webkit-flex-shrink: 0;
			-ms-flex-negative: 0;
			flex-shrink: 0;
			font-size: inherit;
			height: 32px;
			width: 156px;
		}
	</style>
	<style data-emotion="Section_Section__P1hhc" data-s="">
		.Section_Section__P1hhc {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-flex-direction: column;
			-ms-flex-direction: column;
			flex-direction: column;
			-webkit-box-pack: center;
			-ms-flex-pack: center;
			-webkit-justify-content: center;
			justify-content: center;
			-webkit-align-items: center;
			-webkit-box-align: center;
			-ms-flex-align: center;
			align-items: center;
			height: 100%;
			width: 100%;
			background-color: #FFFFFF;
		}

		@media (max-width: 767px) {
			.css-embvl1 {
				height: -webkit-fit-content;
				height: -moz-fit-content;
				height: fit-content;
				margin: 0;
			}
		}
	</style>
	<style data-emotion="css hpuads" data-s="">
		.css-hpuads {
			width: 100%;
			max-width: 1060px;
			padding-left: 20px;
			margin-bottom: 20px;
			margin-top: 20px;
		}

		@media (max-width: 767px) {
			.css-hpuads {
				display: none;
			}
		}
	</style>
	<style data-emotion="css dkzxe" data-s="">
		.css-dkzxe {
			background-color: transparent;
			border: none;
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-align-items: center;
			-webkit-box-align: center;
			-ms-flex-align: center;
			align-items: center;
			gap: 6px;
			cursor: pointer;
			height: 32px;
			padding: 4px 7px;
		}

		.css-dkzxe>span {
			font-size: 20px;
		}
	</style>
	<style data-emotion="css 1h47l4s" data-s="">
		.css-1h47l4s {
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
			width: 1em;
			height: 1em;
			display: inline-block;
			fill: currentColor;
			-webkit-flex-shrink: 0;
			-ms-flex-negative: 0;
			flex-shrink: 0;
			font-size: inherit;
		}
	</style>
	<style data-emotion="css 1ge33jc" data-s="">
		.css-1ge33jc {
			letter-spacing: var(--text-spacing-body);
			font-size: var(--text-size-body);
			line-height: var(--text-height-body);
		}
	</style>
	<style data-emotion="css k88rq" data-s="">
		.css-k88rq {
			color: rgba(55, 56, 60, 0.61);
			font-weight: var(--text-weight-body-bold);
			text-align: left;
			letter-spacing: var(--text-spacing-body);
			font-size: var(--text-size-body);
			line-height: var(--text-height-body);
		}
	</style>
	<style data-emotion="css 1ktsezg" data-s="">
		.css-1ktsezg {
			width: 100%;
			max-width: 400px;
			background-color: #ffffff;
			margin-bottom: 60px;
		}

		@media (max-width: 767px) {
			.css-1ktsezg {
				max-width: unset;
			}
		}
	</style>
	<style data-emotion="css 1nm9gyu" data-s="">
		.css-1nm9gyu {
			height: -webkit-fit-content;
			height: -moz-fit-content;
			height: fit-content;
			-webkit-flex: none;
			-ms-flex: none;
			flex: none;
			width: 100%;
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-flex-direction: row;
			-ms-flex-direction: row;
			flex-direction: row;
			-webkit-box-pack: space-around;
			-ms-flex-pack: space-around;
			-webkit-justify-content: space-around;
			justify-content: space-around;
			padding: 0px 20px;
		}

		@media (max-width: 767px) {
			.css-1nm9gyu {
				height: 56px;
			}
		}
	</style>
	<style data-emotion="css oan6e" data-s="">
		.css-oan6e {
			visibility: hidden;
			min-width: 64px;
		}

		@media (max-width: 767px) {
			.css-oan6e {
				visibility: visible;
				display: -webkit-box;
				display: -webkit-flex;
				display: -ms-flexbox;
				display: flex;
				-webkit-box-pack: start;
				-ms-flex-pack: start;
				-webkit-justify-content: flex-start;
				justify-content: flex-start;
				-webkit-align-items: center;
				-webkit-box-align: center;
				-ms-flex-align: center;
				align-items: center;
				font-weight: 400;
				font-size: 17px;
			}
		}
	</style>
	<style data-emotion="css 1krggrv" data-s="">
		.css-1krggrv {
			border: none;
			background: none;
			cursor: pointer;
			padding: 8px;
			margin: -8px;
			fill: #000000;
		}

		.css-1krggrv svg {
			fill: inherit;
		}
	</style>
	<style data-emotion="css ibouw8" data-s="">
		.css-ibouw8 {
			letter-spacing: var(--text-spacing-headline);
			font-size: var(--text-size-headline);
			line-height: var(--text-height-headline);
			visibility: hidden;
			min-width: 64px;
		}

		@media (max-width: 767px) {
			.css-ibouw8 {
				visibility: visible;
				display: -webkit-box;
				display: -webkit-flex;
				display: -ms-flexbox;
				display: flex;
				-webkit-box-pack: start;
				-ms-flex-pack: start;
				-webkit-justify-content: flex-start;
				justify-content: flex-start;
				-webkit-align-items: center;
				-webkit-box-align: center;
				-ms-flex-align: center;
				align-items: center;
				font-weight: 400;
				font-size: 17px;
			}
		}
	</style>
	<style data-emotion="css 1ub1oa4" data-s="">
		.css-1ub1oa4 {
			color: #000000;
			font-weight: var(--text-weight-headline-bold);
			text-align: center;
			letter-spacing: var(--text-spacing-headline);
			font-size: var(--text-size-headline);
			line-height: var(--text-height-headline);
			visibility: hidden;
			min-width: 64px;
		}

		@media (max-width: 767px) {
			.css-1ub1oa4 {
				visibility: visible;
				display: -webkit-box;
				display: -webkit-flex;
				display: -ms-flexbox;
				display: flex;
				-webkit-box-pack: start;
				-ms-flex-pack: start;
				-webkit-justify-content: flex-start;
				justify-content: flex-start;
				-webkit-align-items: center;
				-webkit-box-align: center;
				-ms-flex-align: center;
				align-items: center;
				font-weight: 400;
				font-size: 17px;
			}
		}
	</style>
	<style data-emotion="css 1iooy02" data-s="">
		.css-1iooy02 {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-flex: 1;
			-ms-flex: 1;
			flex: 1;
			-webkit-box-pack: center;
			-ms-flex-pack: center;
			-webkit-justify-content: center;
			justify-content: center;
			-webkit-align-items: center;
			-webkit-box-align: center;
			-ms-flex-align: center;
			align-items: center;
			font-size: 28px;
			font-weight: 700;
			color: #171719;
		}

		.css-1iooy02 i {
			font-size: 20px;
		}

		@media (max-width: 767px) {
			.css-1iooy02 {
				font-size: 17px;
				font-style: normal;
				font-weight: 600;
				line-height: 141.2%;
			}
		}
	</style>
	<style data-emotion="css w4nvoy" data-s="">
		.css-w4nvoy {
			letter-spacing: var(--text-spacing-headline);
			font-size: var(--text-size-headline);
			line-height: var(--text-height-headline);
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-flex: 1;
			-ms-flex: 1;
			flex: 1;
			-webkit-box-pack: center;
			-ms-flex-pack: center;
			-webkit-justify-content: center;
			justify-content: center;
			-webkit-align-items: center;
			-webkit-box-align: center;
			-ms-flex-align: center;
			align-items: center;
			font-size: 28px;
			font-weight: 700;
			color: #171719;
		}

		.css-w4nvoy i {
			font-size: 20px;
		}

		@media (max-width: 767px) {
			.css-w4nvoy {
				font-size: 17px;
				font-style: normal;
				font-weight: 600;
				line-height: 141.2%;
			}
		}
	</style>
	<style data-emotion="css 14qpgc6" data-s="">
		.css-14qpgc6 {
			color: #000000;
			font-weight: var(--text-weight-headline-bold);
			text-align: center;
			letter-spacing: var(--text-spacing-headline);
			font-size: var(--text-size-headline);
			line-height: var(--text-height-headline);
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-flex: 1;
			-ms-flex: 1;
			flex: 1;
			-webkit-box-pack: center;
			-ms-flex-pack: center;
			-webkit-justify-content: center;
			justify-content: center;
			-webkit-align-items: center;
			-webkit-box-align: center;
			-ms-flex-align: center;
			align-items: center;
			font-size: 28px;
			font-weight: 700;
			color: #171719;
		}

		.css-14qpgc6 i {
			font-size: 20px;
		}

		@media (max-width: 767px) {
			.css-14qpgc6 {
				font-size: 17px;
				font-style: normal;
				font-weight: 600;
				line-height: 141.2%;
			}
		}
	</style>
	<style data-emotion="css 1jxi7lq" data-s="">
		.css-1jxi7lq {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			min-width: 64px;
			-webkit-box-pack: end;
			-ms-flex-pack: end;
			-webkit-justify-content: flex-end;
			justify-content: flex-end;
			-webkit-align-items: center;
			-webkit-box-align: center;
			-ms-flex-align: center;
			align-items: center;
		}

		.css-1jxi7lq i {
			font-size: 14px;
		}
	</style>
	<style data-emotion="css ng7qrx" data-s="">
		.css-ng7qrx {
			margin-top: 56px;
			scrollbar-width: none;
			-ms-overflow-style: none;
		}

		.css-ng7qrx::-webkit-scrollbar {
			display: none;
		}

		@media (max-width: 767px) {
			.css-ng7qrx {
				margin: 0;
				padding: 30px 20px;
			}
		}
	</style>
	<style data-emotion="css 1b2vfnn" data-s="">
		.css-1b2vfnn {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-flex-direction: column;
			-ms-flex-direction: column;
			flex-direction: column;
			gap: 30px;
			padding: 0 20px;
		}

		@media (max-width: 767px) {
			.css-1b2vfnn {
				padding: 0;
			}
		}
	</style>
	<style data-emotion="css 1ia1k3o" data-s="">
		.css-1ia1k3o {
			position: relative;
		}

		.css-1ia1k3o input {
			padding-right: 22%;
		}

		.css-1ia1k3o>button {
			position: absolute;
			z-index: 1;
			top: 50%;
			right: 6px;
			-webkit-transform: translateY(-15%);
			-moz-transform: translateY(-15%);
			-ms-transform: translateY(-15%);
			transform: translateY(-15%);
			width: -webkit-fit-content;
			width: -moz-fit-content;
			width: fit-content;
			height: -webkit-fit-content;
			height: -moz-fit-content;
			height: fit-content;
			min-height: initial;
			background-color: transparent;
			padding: 10px;
		}

		.css-1ia1k3o>button:disabled {
			background-color: transparent;
		}
	</style>
	<style data-emotion="css cssveg" data-s="">
		.css-cssveg {
			position: relative;
		}
	</style>
	<style data-emotion="css env1z2" data-s="">
		.css-env1z2 {
			margin-bottom: 8px;
		}
	</style>
	<style data-emotion="css pxichc" data-s="">
		.css-pxichc {
			letter-spacing: var(--text-spacing-subhead);
			font-size: var(--text-size-subhead);
			line-height: var(--text-height-subhead);
		}
	</style>
	<style data-emotion="css afh7p0" data-s="">
		.css-afh7p0 {
			color: rgba(55, 56, 60, 0.61);
			font-weight: var(--text-weight-subhead-bold);
			text-align: left;
			letter-spacing: var(--text-spacing-subhead);
			font-size: var(--text-size-subhead);
			line-height: var(--text-height-subhead);
		}
	</style>
	<style data-emotion="css 1sbrczv" data-s="">
		.css-1sbrczv {
			width: 100%;
			height: 48px;
			min-height: 48px;
			padding: 0px 16px;
			outline: none;
			background-color: transparent;
			border: 1px solid rgba(112, 115, 124, 0.22);
			color: #171719;
			border-radius: 10px;
			font-size: 16px;
			font-weight: 400;
		}

		.css-1sbrczv::-webkit-outer-spin-button,
		.css-1sbrczv::-webkit-inner-spin-button {
			-webkit-appearance: none;
			margin: 0;
		}

		.css-1sbrczv[type='number'] {
			-moz-appearance: textfield;
		}

		.css-1sbrczv:focus {
			border: 1px solid var(--theme-palette-primary-normal);
		}

		.css-1sbrczv::-webkit-input-placeholder {
			color: rgba(55, 56, 60, 0.28);
		}

		.css-1sbrczv::-moz-placeholder {
			color: rgba(55, 56, 60, 0.28);
		}

		.css-1sbrczv:-ms-input-placeholder {
			color: rgba(55, 56, 60, 0.28);
		}

		.css-1sbrczv::placeholder {
			color: rgba(55, 56, 60, 0.28);
		}

		.css-1sbrczv:-moz-read-only {
			color: rgba(55, 56, 60, 0.28);
			-webkit-text-fill-color: rgba(55, 56, 60, 0.28);
			background-color: #F4F4F5;
			opacity: 1;
		}

		.css-1sbrczv:read-only {
			color: rgba(55, 56, 60, 0.28);
			-webkit-text-fill-color: rgba(55, 56, 60, 0.28);
			background-color: #F4F4F5;
			opacity: 1;
		}
	</style>
	<style data-emotion="css zzrlz5" data-s="">
		.css-zzrlz5 {
			width: 100%;
			height: 48px;
			min-height: 48px;
			border-radius: 10px;
			border: none;
			font-size: 16px;
			cursor: pointer;
			background-color: #ffffff;
			border: none;
		}

		.css-zzrlz5:disabled {
			color: rgba(55, 56, 60, 0.16);
			background-color: #F4F4F5;
			border: none;
			cursor: default;
		}

		.css-zzrlz5:disabled span {
			color: rgba(55, 56, 60, 0.16);
		}

		.css-zzrlz5 span {
			color: var(--theme-palette-primary-normal);
		}
	</style>
	<style data-emotion="css htgykj" data-s="">
		.css-htgykj {
			color: #000000;
			font-weight: var(--text-weight-subhead-bold);
			text-align: left;
			letter-spacing: var(--text-spacing-subhead);
			font-size: var(--text-size-subhead);
			line-height: var(--text-height-subhead);
		}
	</style>
	<style data-emotion="css ut4l54" data-s="">
		.css-ut4l54 p {
			margin-top: 8px;
		}
	</style>
	<style data-emotion="css evy94o" data-s="">
		.css-evy94o {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-flex-direction: column;
			-ms-flex-direction: column;
			flex-direction: column;
			gap: 8px;
		}

		.css-evy94o>div {
			margin: 0;
		}
	</style>
	<style data-emotion="css 14o8ny9" data-s="">
		.css-14o8ny9 {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-flex-direction: column;
			-ms-flex-direction: column;
			flex-direction: column;
			gap: 8px;
		}
	</style>
	<style data-emotion="css 2w308u" data-s="">
		.css-2w308u {
			height: 50px;
			min-height: 50px;
			border-radius: 10px;
			width: 100%;
			border: 1px solid rgba(112, 115, 124, 0.22);
			background-color: #ffffff;
			position: relative;
		}

		.css-2w308u select:disabled {
			background: #F4F4F5;
		}
	</style>
	<style data-emotion="css 14pvjnj" data-s="">
		.css-14pvjnj {
			padding-left: 12px;
			width: 100%;
			position: absolute;
			left: 0;
			-webkit-appearance: none;
			-moz-appearance: none;
			-ms-appearance: none;
			appearance: none;
			height: 100%;
			border: none;
			background: none;
			z-index: 1;
			font-size: 16px;
			color: #171719;
			font-weight: 400;
		}
	</style>
	<style data-emotion="css 1px7y17" data-s="">
		.css-1px7y17 {
			position: absolute;
			right: 16px;
			font-size: 16px;
			top: 50%;
			-webkit-transform: translateY(-50%);
			-moz-transform: translateY(-50%);
			-ms-transform: translateY(-50%);
			transform: translateY(-50%);
		}
	</style>
	<style data-emotion="css gjm025" data-s="">
		.css-gjm025 {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-flex-direction: row;
			-ms-flex-direction: row;
			flex-direction: row;
			position: relative;
			gap: 10px;
		}
	</style>
	<style data-emotion="css 3nuf1p" data-s="">
		.css-3nuf1p {
			width: 100%;
			height: 48px;
			min-height: 48px;
			border-radius: 10px;
			border: none;
			font-size: 16px;
			cursor: pointer;
			background-color: #ffffff;
			border: 1px solid rgba(112, 115, 124, 0.22);
			padding: 0 15px;
			width: auto;
			-webkit-flex: none;
			-ms-flex: none;
			flex: none;
			border-radius: 10px;
			border: 1px solid rgba(112, 115, 124, 0.22);
		}

		.css-3nuf1p:disabled {
			color: rgba(55, 56, 60, 0.16);
			background-color: #F4F4F5;
			border: none;
			cursor: default;
		}

		.css-3nuf1p:disabled span {
			color: rgba(55, 56, 60, 0.16);
		}

		.css-3nuf1p span {
			color: var(--theme-palette-primary-normal);
		}

		.css-3nuf1p:disabled {
			border: 1px solid #F4F4F5;
		}
	</style>
	<style data-emotion="css kfktv3" data-s="">
		.css-kfktv3 {
			color: #000000;
			font-weight: var(--text-weight-body-bold);
			text-align: left;
			letter-spacing: var(--text-spacing-body);
			font-size: var(--text-size-body);
			line-height: var(--text-height-body);
		}
	</style>
	<style data-emotion="css qcrtlj" data-s="">
		.css-qcrtlj {
			letter-spacing: var(--text-spacing-footnote);
			font-size: var(--text-size-footnote);
			line-height: var(--text-height-footnote);
		}
	</style>
	<style data-emotion="css 1ezm7e3" data-s="">
		.css-1ezm7e3 {
			color: #00BF40;
			font-weight: var(--text-weight-footnote-normal);
			text-align: left;
			letter-spacing: var(--text-spacing-footnote);
			font-size: var(--text-size-footnote);
			line-height: var(--text-height-footnote);
		}
	</style>
	<style data-emotion="css 1n70r34" data-s="">
		.css-1n70r34 hr {
			margin: 15px 0;
		}

		.css-1n70r34 p {
			font-size: 15px;
		}
	</style>
	<style data-emotion="css 5hccr8" data-s="">
		.css-5hccr8 {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-flex-direction: row;
			-ms-flex-direction: row;
			flex-direction: row;
			-webkit-align-items: flex-start;
			-webkit-box-align: flex-start;
			-ms-flex-align: flex-start;
			align-items: flex-start;
			position: relative;
			min-height: 25px;
			width: 100%;
		}

		.css-5hccr8>span {
			margin-top: 2px;
			font-size: 20px;
		}

		.css-5hccr8>span svg {
			width: 0.5em;
		}
	</style>
	<style data-emotion="css 1axjas8" data-s="">
		.css-1axjas8 {
			width: 18px;
			height: 18px;
			font-size: 16px;
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-box-pack: center;
			-ms-flex-pack: center;
			-webkit-justify-content: center;
			justify-content: center;
			-webkit-align-items: center;
			-webkit-box-align: center;
			-ms-flex-align: center;
			align-items: center;
			border-radius: 3px;
			border: 1.5px solid rgba(112, 115, 124, 0.22);
			margin-top: 2px;
		}
	</style>
	<style data-emotion="css 31p8kg" data-s="">
		.css-31p8kg {
			opacity: 0;
			width: calc(100% - 90px);
			height: 100%;
			position: absolute;
			cursor: pointer;
		}
	</style>
	<style data-emotion="css 1smbjja" data-s="">
		.css-1smbjja {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-flex: 1;
			-ms-flex: 1;
			flex: 1;
		}
	</style>
	<style data-emotion="css 1r9ue6g" data-s="">
		.css-1r9ue6g {
			letter-spacing: var(--text-spacing-bodyalt);
			font-size: var(--text-size-bodyalt);
			line-height: var(--text-height-bodyalt);
			margin: 0px 0px 0px 8px;
			word-break: keep-all;
		}
	</style>
	<style data-emotion="css 5iu2fa" data-s="">
		.css-5iu2fa {
			color: #171719;
			font-weight: var(--text-weight-bodyalt-bold);
			text-align: left;
			letter-spacing: var(--text-spacing-bodyalt);
			font-size: var(--text-size-bodyalt);
			line-height: var(--text-height-bodyalt);
			margin: 0px 0px 0px 8px;
			word-break: keep-all;
		}
	</style>
	<style data-emotion="css 6cy68w" data-s="">
		.css-6cy68w {
			border: none;
			width: 100%;
			border-bottom: 1px solid rgba(112, 115, 124, 0.22);
		}
	</style>
	<style data-emotion="css sfv171" data-s="">
		.css-sfv171 {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-flex-direction: column;
			-ms-flex-direction: column;
			flex-direction: column;
			gap: 12px;
		}
	</style>
	<style data-emotion="css 12qszhy" data-s="">
		.css-12qszhy {
			color: rgba(55, 56, 60, 0.61);
			font-weight: var(--text-weight-bodyalt-normal);
			text-align: left;
			letter-spacing: var(--text-spacing-bodyalt);
			font-size: var(--text-size-bodyalt);
			line-height: var(--text-height-bodyalt);
			margin: 0px 0px 0px 8px;
			word-break: keep-all;
		}
	</style>
	<style data-emotion="css 6n1bel" data-s="">
		.css-6n1bel {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			margin-left: 28px;
		}
	</style>
	<style data-emotion="css 15nb0ri" data-s="">
		.css-15nb0ri {
			height: 22px;
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-box-pack: center;
			-ms-flex-pack: center;
			-webkit-justify-content: center;
			justify-content: center;
			-webkit-align-items: center;
			-webkit-box-align: center;
			-ms-flex-align: center;
			align-items: center;
			margin-right: 18px;
			cursor: pointer;
		}

		.css-15nb0ri input[type='checkbox'] {
			display: none;
		}

		.css-15nb0ri svg {
			color: #888;
			margin-right: 6px;
			font-size: 20px;
		}

		.css-15nb0ri input[type='checkbox']:checked+svg {
			color: #000;
		}
	</style>
	<style data-emotion="css 17l23i" data-s="">
		.css-17l23i {
			letter-spacing: var(--text-spacing-body);
			font-size: var(--text-size-body);
			line-height: var(--text-height-body);
			margin-left: 0px;
			margin-top: 0px;
			margin-bottom: 0px;
		}
	</style>
	<style data-emotion="css 1l9ox50" data-s="">
		.css-1l9ox50 {
			color: rgba(55, 56, 60, 0.61);
			font-weight: var(--text-weight-body-normal);
			text-align: left;
			letter-spacing: var(--text-spacing-body);
			font-size: var(--text-size-body);
			line-height: var(--text-height-body);
			margin-left: 0px;
			margin-top: 0px;
			margin-bottom: 0px;
		}
	</style>
	<style data-emotion="css 1tbd2jx" data-s="">
		.css-1tbd2jx {
			position: relative;
		}

		@media (max-width: 767px) {
			.css-1tbd2jx {
				z-index: 10;
				position: -webkit-sticky;
				position: sticky;
				bottom: 30px;
			}
		}
	</style>
	<style data-emotion="css 1csonyh" data-s="">
		.css-1csonyh {
			position: absolute;
			top: 30px;
			left: 0;
			right: 0;
			bottom: -30px;
			background: #ffffff;
			z-index: -1;
		}
	</style>
	<style data-emotion="css 270vek" data-s="">
		.css-270vek {
			position: absolute;
			left: 0;
			right: 0;
			bottom: 40px;
			height: 30px;
			background: linear-gradient(180deg,
					rgba(0, 0, 0, 0) 0%,
					#ffffff 100%);
			z-index: -1;
			pointer-events: none;
		}
	</style>
	<style data-emotion="css 1yzn4b" data-s="">
		.css-1yzn4b {
			width: 100%;
			height: 48px;
			min-height: 48px;
			border-radius: 10px;
			border: none;
			font-size: 16px;
			cursor: pointer;
			background-color: var(--theme-palette-primary-normal);
			border: none;
		}

		.css-1yzn4b:disabled {
			color: rgba(55, 56, 60, 0.16);
			background-color: #F4F4F5;
			border: none;
			cursor: default;
		}

		.css-1yzn4b:disabled span {
			color: rgba(55, 56, 60, 0.16);
		}

		.css-1yzn4b span {
			color: #ffffff;
		}
	</style>
	<style data-emotion="css 1vilj37" data-s="">
		.css-1vilj37 {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			width: 100%;
			height: 89px;
			min-height: 89px;
			border-top: 1px solid #0000000d;
		}

		.css-1vilj37>div {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-align-items: center;
			-webkit-box-align: center;
			-ms-flex-align: center;
			align-items: center;
			-webkit-box-pack: justify;
			-webkit-justify-content: space-between;
			justify-content: space-between;
			max-width: 1060px;
			width: 100%;
			height: 100%;
			margin: 0 auto;
		}

		@media (max-width: 767px) {
			.css-1vilj37 {
				height: 184px;
				min-height: 184px;
				margin: 32px auto 0 auto;
				width: calc(100% - 40px);
				padding-top: 32px;
			}

			.css-1vilj37>div {
				-webkit-flex-direction: column-reverse;
				-ms-flex-direction: column-reverse;
				flex-direction: column-reverse;
				-webkit-box-pack: end;
				-ms-flex-pack: end;
				-webkit-justify-content: flex-end;
				justify-content: flex-end;
				gap: 12px;
			}
		}
	</style>
	<style data-emotion="css 1wc1o3l animation-9wl9yj" data-s="">
		.css-1wc1o3l {
			width: 123px;
			height: 20px;
			border-radius: 10px;
			background: rgba(112, 115, 124, 0.08);
			-webkit-animation: animation-9wl9yj 2s ease-in-out infinite;
			animation: animation-9wl9yj 2s ease-in-out infinite;
		}

		@-webkit-keyframes animation-9wl9yj {
			0% {
				opacity: 0.2;
			}

			50% {
				opacity: 1;
			}

			100% {
				opacity: 0.2;
			}
		}

		@keyframes animation-9wl9yj {
			0% {
				opacity: 0.2;
			}

			50% {
				opacity: 1;
			}

			100% {
				opacity: 0.2;
			}
		}
	</style>
	<style data-emotion="css 1yioz69" data-s="">
		.css-1yioz69 {
			display: -webkit-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-align-items: center;
			-webkit-box-align: center;
			-ms-flex-align: center;
			align-items: center;
			gap: 40px;
		}

		@media (max-width: 767px) {
			.css-1yioz69 {
				-webkit-flex-direction: column-reverse;
				-ms-flex-direction: column-reverse;
				flex-direction: column-reverse;
				gap: 24px;
			}
		}
	</style>
	<style data-emotion="css 1u33umm animation-9wl9yj" data-s="">
		.css-1u33umm {
			width: 165px;
			height: 20px;
			border-radius: 10px;
			background: rgba(112, 115, 124, 0.08);
			-webkit-animation: animation-9wl9yj 2s ease-in-out infinite;
			animation: animation-9wl9yj 2s ease-in-out infinite;
		}

		@-webkit-keyframes animation-9wl9yj {
			0% {
				opacity: 0.2;
			}

			50% {
				opacity: 1;
			}

			100% {
				opacity: 0.2;
			}
		}

		@keyframes animation-9wl9yj {
			0% {
				opacity: 0.2;
			}

			50% {
				opacity: 1;
			}

			100% {
				opacity: 0.2;
			}
		}
	</style>
	<style data-emotion="css 2231vq animation-9wl9yj" data-s="">
		.css-2231vq {
			width: 120px;
			height: 40px;
			border-radius: 10px;
			background: rgba(112, 115, 124, 0.08);
			-webkit-animation: animation-9wl9yj 2s ease-in-out infinite;
			animation: animation-9wl9yj 2s ease-in-out infinite;
		}

		@-webkit-keyframes animation-9wl9yj {
			0% {
				opacity: 0.2;
			}

			50% {
				opacity: 1;
			}

			100% {
				opacity: 0.2;
			}
		}

		@keyframes animation-9wl9yj {
			0% {
				opacity: 0.2;
			}

			50% {
				opacity: 1;
			}

			100% {
				opacity: 0.2;
			}
		}
	</style>
	<style data-emotion="css" data-s=""></style>
	<style text="text/css">
		<!-- golgolz start -->
			option{
			font-size: 15px;
			}
			.input-group-text img {
			 width: 5px;
			height: 5px;
			}
		<!-- golgolz end -->
	</style>
	<script text="text/javascript">
		$(function(){
			<!-- golgolz start -->
			$('#datepicker').datepicker({
				format: 'yyyy-mm-dd', // 날짜 형식 지정
				autoclose: true, // 날짜 선택 후 자동으로 닫힘
				language: 'ko' // 한국어 설정
			});
			<!-- golgolz end -->
		});//ready
	</script>
</head>
<body>
    <div id="__next" data-reactroot="">
		<jsp:include page="../assets/layout/user/header.jsp" />
		<main class="JobsFeed_Jobsfeed__DpeV9">  
			<section class="Section_Section__P1hhc">
			<!-- golgolz start -->
							<div class="css-hpuads"><button type="button" class="css-dkzxe">
								<span class="css-1ihsymv"><svg
								viewBox="0 0 24 24" color="rgba(55, 56, 60, 0.61)" class="css-1h47l4s">
								<path fill-rule="evenodd" clip-rule="evenodd" fill="rgba(55, 56, 60, 0.61)"
									d="M2.8637 11.3635C2.51223 11.715 2.51223 12.2848 2.8637 12.6363L9.8637 19.6363C10.2152 19.9878 10.785 19.9878 11.1365 19.6363C11.488 19.2848 11.488 18.715 11.1365 18.3635L5.67289 12.8999H20.5001C20.9972 12.8999 21.4001 12.497 21.4001 11.9999C21.4001 11.5028 20.9972 11.0999 20.5001 11.0999L5.67289 11.0999L11.1365 5.6363C11.488 5.28483 11.488 4.71498 11.1365 4.36351C10.785 4.01203 10.2152 4.01203 9.8637 4.36351L2.8637 11.3635Z">
								</path>
							</svg></span>
						<p ="Typography" color="rgba(55, 56, 60, 0.61)" class="css-k88rq" style="margin-top: 10px;">취소하고 돌아가기</p>
					</button></div>
				<div class="css-1ktsezg">
					<div class="css-1nm9gyu">
						<div class="css-oan6e"><button type="button" class="css-1krggrv">
								<p ="Typography" color="#000000" class="css-1ub1oa4">취소</p>
							</button></div>
						<div class="css-1iooy02">
							<p ="Typography" color="#000000" class="css-14qpgc6">회원가입</p>
						</div>
						<div class="css-1jxi7lq"></div>
					</div>
					<div class="css-ng7qrx">
						<form class="css-1b2vfnn">
							<div>
								<div class="css-1ia1k3o">
									<div class="css-cssveg">
										<div class="css-env1z2"><label ="Typography"
												color="rgba(55, 56, 60, 0.61)" for="email"
												class="css-afh7p0">이메일</label></div><input type="email"
											placeholder="이메일을 입력해주세요." name="email" ="Input_email"
											autocomplete="new-password" class="css-1sbrczv" value="">
									</div>
									<button type="button"  class="css-zzrlz5" disabled="disabled">
									<span ="Typography" color="#000000" class="css-htgykj" >중복 확인</span></button>
								</div>
								<div class="css-ut4l54"></div>
							</div>
							<div class="css-evy94o">
								<div class="css-env1z2"><label ="Typography" color="rgba(55, 56, 60, 0.61)"
										for="username" class="css-afh7p0">이름</label></div><input type="text"
									placeholder="이름을 입력해주세요." name="username" ="Input_username"
									autocomplete="new-password" class="css-1sbrczv" value="">
							</div>
							<div>
								<div class="css-env1z2"><label ="Typography" color="rgba(55, 56, 60, 0.61)"
										for="mobile" class="css-afh7p0">휴대폰 번호</label></div>
								<div class="css-14o8ny9">
									<div class="css-gjm025" style="margin-bottom: 20px;"><input type="number" pattern="[0-9]*"
											placeholder="(예시) 01013245768" name="mobile" ="Input_mobile"
											autocomplete="on" class="css-1sbrczv" value="">
								</div>
							</div>
								<div class="css-env1z2"><label ="Typography" color="rgba(55, 56, 60, 0.61)"
										for="mobile" class="css-afh7p0">전화번호</label></div>
								<div class="css-14o8ny9">
									<div class="css-gjm025" style="margin-bottom: 15px;"><input type="number" pattern="[0-9]*"
											placeholder="(예시) 021234567" name="mobile" ="Input_mobile"
											autocomplete="on" class="css-1sbrczv" value="">
								</div>
							</div>
							</div>
							<div class="css-evy94o">
								<div class="css-env1z2"><label ="Typography" color="rgba(55, 56, 60, 0.61)"
										for="password" class="css-afh7p0">비밀번호</label></div>
								<div class="css-evy94o"><input type="password" placeholder="비밀번호를 입력해주세요."
										name="password" ="Input_password" autocomplete="on"
										class="css-1sbrczv" value=""></div><input type="password"
									placeholder="비밀번호를 다시 한번 입력해주세요." name="passwordConfirm"
									="Input_passwordConfirm" autocomplete="on" class="css-1sbrczv" value="">
								<p ="Typography" color="rgba(55, 56, 60, 0.61)" class="css-1eroab9" style="font-size: 12px;">영문 대소문자,
									숫자, 특수문자를 3가지 이상으로 조합해 8자 이상 16자 이하로 입력해주세요.</p>
							</div>
							<div style="margin-top: 20px; margin-bottom: 5px;"><h1 style="font-size: 15px">기타 인적사항</h1></div>
							<div class="css-evy94o">
								<div class="css-env1z2" ><label ="Typography" color="rgba(55, 56, 60, 0.61)"
										for="birthday" class="css-afh7p0" >성별</label></div>
								<div class="" style="text-align: center">
								<span style="margin-right: 10px; font-size: 15px;"><input type="radio" name="gender" class="gender" value="남자" style="width: 15px; height: 15px; margin: 3px;">남자</span>
								<span style="margin-left: 10px; font-size: 15px;"><input type="radio" name="gender" class="gender" value="여자" style="width: 15px; height: 15px; margin: 3px;">여자</span></div>
							</div>
							<div class="css-evy94o" style="margin-top: 20px;">
								<div class="css-env1z2"><label ="Typography" color="rgba(55, 56, 60, 0.61)"
										for="birthday" class="css-afh7p0">생년월일</label></div>
								<div class="input-group" style="text-align: center">
								<input type="text" class="css-1sbrczv" id="datepicker" style="background-color: #FFFFFF; width: 85%;" placeholder="생년월일을 선택해주세요." readonly>
								<img src="http://localhost/recruit-app/assets/images/mypage/calenderImg.png" alt="달력 아이콘" class="input-group-text" style="width: 15%; height: 48px;">
								</div>
							</div>
							<div class="question-css" style="margin-top: 20px; margin-bottom:30px;">
								<div style="text-align: center; margin: 15px; ">
								<p style="font-size: 15px">보안 질문 설정</p>
								</div>
								<div class="css-2w308u">
								
								<select class="css-14pvjnj">
									<option>질문선택</option>
									<option>질문1</option>
									<option>질문2</option>
									<option>질문3</option>
									<option>질문4</option>
								</select>
								<div class="css-1px7y17"><span class="css-1ihsymv"><svg viewBox="0 0 24 24" class="css-1h47l4s"><path fill="rgba(55, 56, 60, 0.61)" d="M3.08071 7.58071C3.58839 7.07303 4.41151 7.07303 4.91919 7.58071L12 14.6615L19.0807 7.58071C19.5884 7.07303 20.4115 7.07303 20.9192 7.58071C21.4269 8.08839 21.4269 8.91151 20.9192 9.41919L12.9192 17.4192C12.4115 17.9269 11.5884 17.9269 11.0807 17.4192L3.08071 9.41919C2.57303 8.91151 2.57303 8.08839 3.08071 7.58071Z"></path></svg></span></div>
								</div>
								<div class="answer-css" style="margin-top: 10px; ">
									<input type="text" class="css-1sbrczv" placeholder="내용을 입력해주세요.">
								</div>
							</div>
							<div class="css-1n70r34" style="margin-top: 20px; margin-bottom: 30px;">
								<div class="css-5hccr8" style="margin-bottom:5px;">
									<input type="checkbox" style="width: 15px; height: 15px; margin-top: 3px;">
									<div class="css-1smbjja">
										<p ="Typography" color="#171719" class="css-5iu2fa">전체 동의</p>
									</div>
								</div>
								<div class="css-sfv171">
									<div class="css-5hccr8">
											<input type="checkbox" style="width: 15px; height: 15px; margin-top: 3px;">
										<div class="css-1smbjja">
											<p ="Typography" color="rgba(55, 56, 60, 0.61)"
												class="css-12qszhy">만 14세 이상입니다. (필수)</p>
										</div>
									</div>
									<div class="css-5hccr8">
										<input type="checkbox" style="width: 15px; height: 15px; margin-top: 3px;">
										<div class="css-1smbjja">
											<p ="Typography" color="rgba(55, 56, 60, 0.61)"
												class="css-12qszhy">Goojzzk 이용약관 동의 (필수)</p>
										</div>
									</div>
									<div class="css-5hccr8">
										<input type="checkbox" style="width: 15px; height: 15px; margin-top: 3px;">
										<div class="css-1smbjja">
											<p ="Typography" color="rgba(55, 56, 60, 0.61)"
												class="css-12qszhy">Goojzzk 개인정보 수집 및 이용 동의 (필수)</p>
										</div>
									</div>
								</div>
							</div>
							<div class="css-1tbd2jx">
								<div class="css-1csonyh"></div>
								<div class="css-270vek"></div>
								<button type="submit" class="css-1yzn4b"><span ="Typography" color="#000000"
										class="css-kfktv3">가입하기</span></button>
							</div>
						</form>
					</div>
				</div>
			<!-- golgolz end -->
			</section>
			<jsp:include page="../assets/layout/user/footer.jsp" />  
		</main>
	</div>
</body>
</html>