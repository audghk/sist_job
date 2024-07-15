<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
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
	th, td{border:1px solid #333;}
	#nameTitle{width:120px}
	#scoreTitle{width:600px}
</style>
<script type="text/javascript">
	$(function(){
		
	});//ready
</script>
</head>
<body>
<div>
<%!//0으로 초기화됨
int i;//instance variable
%>
인스턴스 변수 : <strong><%= i %></strong>
<%!
	public String formatDate(){
  		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String tempDate=sdf.format(new Date());
		
		return tempDate;
	}
%>
<%!
public String createRadio(int cnt, String name, int nameNum, int checkNum){
	StringBuilder radio=new StringBuilder();
	
	if(cnt<1){
	  cnt=2;
	}
	if(checkNum < 0){
	  checkNum=0;
	}
	if(cnt > checkNum){
	  checkNum=cnt-1;
	}
	
	for(int i=1; i<=cnt; i++){
	radio.append("<input type='radio' name='").append(name).append(nameNum)
	.append("'").append(" value='").append(i).append("'")
	.append(i==checkNum?" checked='checked'":"").append(">").append(i).append("점&nbsp;\n"); 
	}
	
	return radio.toString();
}
%>
<%
//scriptlet은 JSP가 Java Source Code로 변경될 때 _jspService method 안으로
//코드가 생성되므로 method를 정의할 수 없다.
//public void test(){
//	  
//}
String[] names={"김동섭","윤웅찬","진수현","김병년","정명호"};
%>
<input type="text" value="<%= formatDate() %>"/><br/>

</div>
<div><h2><%= formatDate() %></h2></div>
<table class="table" style="width:620px">
<tr>
<th id="nameTitle">이름</th>
<th id="scoreTitle">점수</th>
</tr>
<%
for(int i=0; i<names.length; i++){
%>
	<tr>
	<td><%= names[i] %></td>
	<td>
	<%-- <%
	for(int j=1; j<11; j++){
	%>
	<input type="radio" name="score_<%= i %>"<%= j==5?" checked='checked'":"" %> value="<%= j %>"/><%= j %>&nbsp;
	<%
	}
	%> --%>
	<%= createRadio(10, "score_", i, 10) %>
	</td>
	</tr>
<%
}
%>
</table>
</body>
</html>