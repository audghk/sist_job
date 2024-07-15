<%@page import="kr.co.sist.user.member.ProfileVO"%>
<%@page import="kr.co.sist.user.member.ProfileDAO"%>
<%@page import="kr.co.sist.util.cipher.DataDecrypt"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>    
	<link rel="icon" href="http://192.168.10.211/jsp_prj/common/favicon.ico" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="http://192.168.10.211/jsp_prj/common/css/main.css" type="text/css" media="all" />
	<link rel="stylesheet" href="http://192.168.10.211/jsp_prj/common/css/board.css" type="text/css" media="all" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<style text="text/css">
	</style>
	<script text="text/javascript">
		$(function(){
			$("#profileImg").change(function(event){ // 커서가 들어왓을때의 상태와 나갈떄의 상태가 다를때 호출, evt => 이벤트를 일으킨 객체
				// 0. 값이 없으면 할 필요가 ㅇㅅㅇ
				if($("#profileImg").val() == ""){
					alert("이미지를 선택해주세요.");
					return;
				}
			
				// 1. 파일 컴포넌트 얻기
				var file = event.target.files[0]; // -> 같은 종류의 이벤트가 여러개 발생할 수 있어서 배열로 들어옴
				alert(file);
				
				// 2. 스트림 생성
				var reader = new FileReader();
				
				// 3. onload 이벤트 핸들러 설정 ( 파일 읽기가 완료되면 호출 )
				reader.onload = function(evt) {
					// 이미지 태그에 src 속성을 선택한 파일명으로 설정
					$("#previewProfile").prop("src", evt.target.result);
				} // function
				
				// 4. FileReader 객체를 사용하여 선택한 파일을 읽어들인다.
				reader.readAsDataURL(file);
			});
			
			// 파일 업로드
			$("#btnImg").click(function(){
				if($("#profileImg").val() == ""){
					alert("이미지를 선택해주세요.");
					return;
				}
				
				// 1. 폼 얻기
				var frm = $("#frm")[0];
				
				// 2. Ajax로 전송할 폼 객체 생성
				var formData = new FormData(frm);
				
				$.ajax({
					url: "ajax_file_upload_process.jsp",
					type: "post",
					processData: false, // 쿼리스트링을 전송하지 않게 되고
					contentType: false ,// 파일 전송 방식으로 바뀐다.
					data: formData,		// file만 전송
					async: false,
					dataType: "JSON",
					error: function(xhr){
						alert("업로드 실패");
						console.log(xhr.status);
					},
					success: function(jsonObj){
						var msg = "이미지 변경 실패";
						
						if(jsonObj.result){
							msg = "이미지 변경 성공";
						}
						
						$("#uploadResult").html(msg);
					}
				});			
			});
			
			$("#btnSubmit").click(function(){
				$("#frm").submit();
			});
		});
	</script>
</head>
<body>
<%
	ProfileDAO profileDAO = ProfileDAO.getInstance();
	String id = (String)session.getAttribute("id");
	
	if(id == null){
	    id = "kim";
	}
	
	ProfileVO profile = null;
	
	try{
	    profile = profileDAO.selectProfile(id);
	    
	    String key = "DMF1ucDxtqgxw5niaXcmYQ==";
	    DataDecrypt dd = new DataDecrypt(key);
	
	    profile.setName(dd.decryption(profile.getName())); 
	    
	    pageContext.setAttribute("pVO", profile);
	} catch(SQLException se){
	    se.printStackTrace();
	}
%>
<c:if test="${ empty pVO }">
	<c:redirect url="index.html" />
</c:if>
<div>
	<form action="info_frm_process.jsp"method="post"name="frm"id="frm">
		<label>프로필 이미지</label>
		<input type="file" name="profileImg" id="profileImg" />
		<input type="button" value="이미지 업로드" id="btnImg" class="btn btn-warning btn-sm" />
		<span id="uploadResult"></span>
		<br />
		<img src="http://192.168.10.211/jsp_prj/upload/${ pVO.img }" id="previewProfile" style="width: 100px"/>
		<br />
		<label>ID</label> : <input type="text" name="id" id="id" value="${ pVO.id }"> <br />
		<label>Name</label> : <input type="text" name="name" id="name" value="${ pVO.name }"> <br />
		<input type="button" value="변경" id="btnSubmit" class="btn btn-info btn-sm" />
	</form>
</div>
</body>
</html>