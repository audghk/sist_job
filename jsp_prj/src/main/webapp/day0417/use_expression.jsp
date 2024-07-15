<%@page import="day0417.DataVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="표현식의 사용"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://192.168.10.216/jsp_prj/common/favicon.ico"/>
<!--bootstrap 시작-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<!--bootstrap 끝-->
<link rel="stylesheet" href="http://192.168.10.216/jsp_prj/common/css/main.css" type="text/css" media="all" />
<link rel="stylesheet" href="http://192.168.10.216/jsp_prj/common/css/board.css" type="text/css" media="all" />
<!--jQuery CDN 시작-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!--jQuery CDN 끝-->
<style type="text/css">
	td{border:1px solid #333; width:150px; text-align:center;/*  cursor:pointer; */}
	#image:hover{background-color:#dfdfdf}
	th{border:1px solid #333; text-align:center;}
	#gugu{border:1px solid #333; width:150;}
</style>
<script type="text/javascript">
	$(function(){
		$("#gourl").change(function(){
			var sel=$("#gourl")[0];
			if(sel.selectedIndex != 0){
				if(confirm(sel.value+"로 이동하시겠습니까?")){
					location.href=sel.value;
				}	
			}
		});//change		
	});//ready
	
	function print(i,j,result){//웹 서버에서 모든 일을 다 하고 결과만 출력
		alert(i+"X"+j+"="+result);
	}
	function print2(i,j){//웹 서버와 웹 클라이언트가 나눠서 일을 수행.
		alert(i+"X"+j+"="+(i*j));
	}
</script>
</head>
<body>
<div>
	<%
	String msg="오늘은 피곤한 수요일";
	String msg2="피곤함 오지는 수요일";
	%>
	<%-- <%= msg, msg2 %> 표현식은 out.print()로 코드가 변환되며 JspWriter 클래스에는
						  print() method가 매개변수를 하나로면 Overload 되어있다. --%>
	<%= msg %><br>
	<%= msg2 %>

	<table>
	<% 
	for(int i=1; i<10; i++){
	%>
	<tr>
<%-- 	<td onclick="alert('<%= 2*i %>')">2 X <%= i %></td>	 --%>
		<td onclick="print(2,'<%= i %>','<%= 2*i %>')">2 X <%= i %></td>	
		<td onclick="print2(2,'<%= i %>')">2 X <%= i %></td>	
	</tr>
	<%
	}
	%>
	</table>
	<%
		DataVO[] data=new DataVO[5];
		data[0]=new DataVO("김동섭","http://danawa.com","danawa.png");
		data[1]=new DataVO("진수현","http://youtube.com","youtube.png");
		data[2]=new DataVO("윤웅찬","http://google.com","google.png");
		data[3]=new DataVO("홍성강","http://www.coupang.com","coupang.png");
		data[4]=new DataVO("김병년","http://sist.co.kr","sist.png");
	%>
	
	<select id="gourl">
	<option>---선택---</option>
	<%
	for(int i=0; i<data.length; i++){
	%>
	<option value="<%= data[i].getUrl() %>"><%= data[i].getName() %></option>
	<%
	}
	%>
	</select>
	
	<table id="goimg">
	<th>이름</th>
	<th>이미지</th>
	<%
	for(int i=0; i<data.length; i++){
	%>
	<tr>
	<td><%= data[i].getName() %></td>
	<td><a href="<%= data[i].getUrl() %>"><img src="images/<%= data[i].getImg() %>"/></a></td>
	</tr>
	<%
	}
	%>
	</table>
	
	<table>
	<%
	for(int i=1; i<10; i++){
	  %>
	  <tr>
	  <%
	  for(int j=2; j<10; j++){
	  %>
	    <td><%= j %> X <%= i %> = <%= i*j %></td>
	  <%
	  }
	  %>
	  </tr>
	  <%  
	}
	%>
	</table>
	
</div>
</body>
</html>