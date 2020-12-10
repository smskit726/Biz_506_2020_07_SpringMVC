<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공공DB 활용</title>
<link href="${rootPath}/static/css/index.css?ver=001" rel="stylesheet"/>
<script>
document.addEventListener("DOMContentLoaded",function(){
	
	document.querySelector("#btn-home").addEventListener("click", function(){
		document.location.href = "${rootPath}/"
	})
	
	const menu_station = document.querySelector("nav.main-nav .get-station")
	menu_station.onclick = function(){
		document.location.href="${rootPath}/bis/station"
	}
	
	const select_cat = document.querySelector("select[name='cat']")
	
	// select input box의 change 이벤트를 설정하기
	select_cat.onchange = function(e) {
		// change 이벤트가 발생하면 value값을 추출하고
		const value = e.target.value
		// value값이 hosp이면 
		if(value === 'hosp') {
			// input box의 placeholder를 변경
			document.querySelector("input[name='search']")
					.placeholder = '병원명 입력후 ENTER'
		} else {
			document.querySelector("input[name='search']")
					.placeholder = '주소 입력후 ENTER'
		}
	}
})
</script>
</head>
<body>
	<header>
		<h2>공공DB 활용</h2>
	</header>
	<nav class="main-nav">
		<ul>
			<li id="btn-home">Home</li>
			<li>
				<form>
					<select name="cat">
						<option value="hosp">병원명</option>
						<option value="addr">주소</option>
					</select>
					<input name="search" type="search" placeholder="동물병원 이름 입력 후 ENTER">
				</form>
			</li>
			<li>
				<form action="${rootPath}/bis/station">
					<input name="station" type="search" placeholder="버스 정류소 이름을 입력한 후 ENTER">
				</form>
			</li>
			<li class="get-station">노선정보가져오기</li>
		</ul>
	</nav>
	<section class="main-body">
		<c:if test="${BODY == 'STATION'}">
			<%@ include file = "/WEB-INF/views/station_view.jspf"%>
			<%@ include file = "/WEB-INF/views/busstop_view.jspf"%>
		</c:if>
		<c:if test="${BODY == 'PET'}">
			<%@ include file = "/WEB-INF/views/hosp_view.jspf"%>
		</c:if>
	</section>
</body>
</html>