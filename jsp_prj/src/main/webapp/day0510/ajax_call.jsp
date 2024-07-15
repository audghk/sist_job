<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="AJAX사용"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://192.168.10.231/jsp_prj/common/favicon.ico">
<!-- bootstrap ���� -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<!-- bootstrap �� -->
<!--sist��Ÿ�Ͻ�Ʈ ����-->
<link rel="stylesheet" href="http://192.168.10.231/jsp_prj/common/css/main.css" type="text/css" media="all" />
<link rel="stylesheet" href="http://192.168.10.231/jsp_prj/common/css/board.css" type="text/css" media="all" />
<!--sist��Ÿ�Ͻ�Ʈ ��-->
<!-- JQUERY CDN ����-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!--JQUERY CDN ��-->
<style type="text/css">
	
</style>

<script type="text/javascript">
	$(function(){
		$("#btnHtml").click(function(){
			$.ajax({
				url : "response_html.jsp",
				type : "GET",
				async : true,
				dataType : "HTML",
				error : function(){
					alert(xhr.status + " / " + xhr.statusText);
				},
				success : function(data){ //응답된 HTML 이 들어온다.
					//화면 일부분을 갱신하여 응답된 데이터를 보여준다
					$("#output").html(data);
				}
			})
		
		})
		$("#btnText").click(function(){
			$.ajax({
				url : "response_text.jsp",
				type : "GET",
				dateType : "TEXT",
				error : function(xhr){
					console.log(xhr.status + " " + xhr.statusText);
				},
				success : function(data){
					var nameArr = data.split(",");
					
					var output ="<ul>";
					$.each(nameArr, function(i,name){
						output+="<li>" + name + "</li>";
					});
					output+= "</ul>"
					$("#output").html(output);
				}
			})//ajax
		})
		$("#btnXml").click(function(){
			$.ajax({
				url : "response_xml.jsp",
				type : "GET",
				dateType : "XML",
				error : function(xhr){
					$("#output").html("<strong>" + xhr.status + "</strong>");
				},
				success : function(data){
					
					//XML은 parsing 해서 사용한다.
					var nameNodes =  $(data).find("name");
					var output ="";
					$.each(nameNodes,function(i,nameNode){
						output += "<h"+(i+1) +">" + $(nameNode).text() + "</h"+(i+1) +">"
					});
					$("#output").html(output);
				}
			})
		})
		$("#btnJson").click(function(){
			$.ajax({
			url : "response_json.jsp",
			type : "POST",
			dataType : "JSON",//에러가 200이면 TEXT로 바꿔서 수정
			error : function(xhr){
				alert(xhr.status+"/"+xhr.statusText);
			},
			success: function(data){
				$("#name").val(data.name)
				$("#age").val(data.age)
				$("#hobby").val(data.hobby)
			}
				
			})
		})
	
	}); //ready
</script>
</head>
<body>
<div>
<div>
	<input type="button" value="HTML요청" class="btn btn-success btn-sm" id="btnHtml">
	<input type="button" value="TEXT요청" class="btn btn-success btn-sm" id="btnText">
	<input type="button" value="XML요청" class="btn btn-success btn-sm" id="btnXml">
	<input type="button" value="JSON요청" class="btn btn-success btn-sm" id="btnJson">
</div>
<div id="output"></div>
<label>이름</label><input type="text" name="name" id="name"/><br/>
<label>나이</label><input type="text" name="age" id="age"/><br/>
<label>취미</label><input type="text" name="hobby" id="hobby"/><br/>
</div>
</body>
</html>