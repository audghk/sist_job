<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../assets/layout/user/lib.jsp" />  
	<!-- golgolz start -->
	<!-- golgolz end -->
	<style text="text/css">
		<!-- golgolz start -->
		   body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            font-size: 18px;
            width: 500px; /* 폼의 너비 설정 */
            margin: 0 auto; /* 좌우 가운데 정렬 */
        }
        h1 {
            text-align: center;
            font-size: 24px;
            margin-bottom: 20px;
        }
        .item {
            margin-bottom: 20px;
            padding-bottom: 10px;
            border-bottom: 1px solid #ccc;
        }
        .item:last-child {
            border-bottom: none;
        }
        .options label {
            display: inline-block;
             margin-bottom: 5px; 
            margin-right: 10px;
        }
        .options input[type="radio"] {
            margin-right: 5px;
        }
        button {
            display: block;
            width: 100%;
            padding: 10px;
            font-size: 18px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
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
			<form action="/submit" method="post">
        <h1>설문조사</h1>
        <div class="item">
            <label for="item1" style="margin-bottom: 20px; display: block;">1. 이직 시 나의 커리어에 도움이 될까요?</label>
            <div class="options">
                <input type="radio" id="item1_yes" name="item1" value="yes">
                <label for="item1_yes">예</label><br>
                <input type="radio" id="item1_maybe" name="item1" value="maybe">
                <label for="item1_maybe">글쎄요</label><br>
                <input type="radio" id="item1_no" name="item1" value="no">
                <label for="item1_no">아니오</label>
            </div>
        </div>
        <div class="item">
            <label for="item2" style="margin-bottom: 20px; display: block;">2. 연차를 마음대로 사용할 수 있나요?</label><br>
            <div class="options">
                <input type="radio" id="item2_yes" name="item2" value="yes">
                <label for="item2_yes">예</label><br>
                <input type="radio" id="item2_maybe" name="item2" value="maybe">
                <label for="item2_maybe">글쎄요</label><br>
                <input type="radio" id="item2_no" name="item2" value="no">
                <label for="item2_no">아니오</label>
            </div>
        </div>
        <div class="item">
            <label for="item3" style="margin-bottom: 20px; display: block;">3. 급여는 만족스럽나요?</label><br>
            <div class="options">
                <input type="radio" id="item3_yes" name="item3" value="yes">
                <label for="item3_yes">예</label><br>
                <input type="radio" id="item3_maybe" name="item3" value="maybe">
                <label for="item3_maybe">글쎄요</label><br>
                <input type="radio" id="item3_no" name="item3" value="no">
                <label for="item3_no">아니오</label>
            </div>
        </div>
        <div class="item">
            <label for="item4" style="margin-bottom: 20px; display: block;">4. 직원을 위한 복지 혜택이 충분한가요?</label><br>
            <div class="options">
                <input type="radio" id="item4_yes" name="item4" value="yes">
                <label for="item4_yes">예</label><br>
                <input type="radio" id="item4_maybe" name="item4" value="maybe">
                <label for="item4_maybe">글쎄요</label><br>
                <input type="radio" id="item4_no" name="item4" value="no">
                <label for="item4_no">아니오</label>
            </div>
        </div>
        <button type="submit">제출</button>
    </form>
			
			<!-- golgolz end -->
			</section>
			<jsp:include page="../assets/layout/user/footer.jsp" />  
		</main>
	</div>
</body>
</html>