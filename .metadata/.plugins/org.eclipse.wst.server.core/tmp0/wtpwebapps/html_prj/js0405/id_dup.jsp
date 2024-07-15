<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복 검사</title>
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
<style type="text/css">
#idWrap {
	width: 468px;
	height: 330px;
	margin: 0px auto;
}

#background {
	width: 464px;
	height: 326px;
	background: #FFFFFF url(images/id_background.png) no-repeat;
	position: rekatube;
}

#inputWrap {
	position: absolute;
	top: 186px;
	left: 103px;
}
</style>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById("btn").addEventListener("click", sendID);
	}

	function sendID() {
		// 2. 현재 창에 입력된 id를 부모 창의 id로 교체
		opener.window.document.frm.id.value = document.subFrm.id.value;

		// 3. 창 닫기
		self.close();
	}
</script>
</head>
<body>
	<div id="idWrap">
		<div id="background">
			<div id="inputWrap">
				<form name="subFrm">
					<input type="text" name="id" class="inputBtn inputIdtype" /> <input
						type="button" value="사용" id="btn" class="btn btn-success btn-sm" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>