<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="" isELIgnored="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>    
	<link rel="icon" href="http://192.168.10.216/jsp_prj/common/favicon.ico" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="http://192.168.10.216/jsp_prj/common/css/main.css" type="text/css" media="all" />
	<link rel="stylesheet" href="http://192.168.10.216/jsp_prj/common/css/board.css" type="text/css" media="all" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<style text="text/css">
	</style>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4506f540cd66a1dbc8c0db892eba6582"></script>
	<script text="text/javascript">
		$(function(){
			$("#btn").click(function(){
				$.ajax({
					url: "search_restaurant.jsp",
					type: "GET",
					dataType: "JSON",
					error: function(xhr){
						alert(" 문제 발생 ! ");
						console.log("에러코드 : " + xhr.status + " /  에러 메세지 : " + xhr.statusText);
					},
					success: function(jsonObj){
						console.log(jsonObj.data);
					}
				});
			});
		});
		
		//조회결과로 table에 데이터를 동적생성
		function setTable(jsonObject){
			
			var output="<tr>";
			$.each(jsonObject.data, function(i, jsonObj){
				output += `<tr><td>${(i+1)}</td>
						   <td>${jsonObj.name}(${jsonObj.lat},${jsonObj.lng})</td>
						   <td>${jsonObj.menu}</td>`;				
			});
			
			output+="</tr>";
			
			//기존 데이터를 삭제하고
			$("#dataTbody").empty();
			//새로운 데이터를 보여준다.
			$("#dataTbody").append(output);
		}
	</script>
	<script>
		var positions = [
			{
		        title: '쌍용교육센터', 
		        latlng: new kakao.maps.LatLng(37.4993366,127.0332123)
		    }
		];
		
		$(function(){
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		    mapOption = { 
				center: new kakao.maps.LatLng(37.4993366,127.0332123), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };
		
			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			 
			// 마커를 표시할 위치와 title 객체 배열입니다 
		
			// 마커 이미지의 이미지 주소입니다
			var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
			    
			for (var i = 0; i < positions.length; i ++) {
			    
			    // 마커 이미지의 이미지 크기 입니다
			    var imageSize = new kakao.maps.Size(24, 35); 
			    
			    // 마커 이미지를 생성합니다    
			    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
			    
			    // 마커를 생성합니다
			    var marker = new kakao.maps.Marker({
			        map: map, // 마커를 표시할 지도
			        position: positions[i].latlng, // 마커를 표시할 위치
			        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
			        image : markerImage // 마커 이미지 
			    });
			}
		});
	</script>
</head>
<body>
<div>
	<div id="map" style="width:100%;height:400px;"></div>
	<input type="button" value="맛집보기" id="btn" class="btn btn-success btn-sm" />
	<div>
		<table id="tab" class="table">
			<thead>
				<tr>
					<th style="width: 80px">번호</th>
					<th style="width: 200px">식당명</th>
					<th style="width: 500px">메뉴</th>
				</tr>
			</thead>
			<tbody id="dataTbody"></tbody>
		</table>
	</div>
</div>
</body>
</html>