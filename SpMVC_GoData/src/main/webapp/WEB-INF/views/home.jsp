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
</head>
<style>
html, body {
	heigth: 100%;
	width: 100%;
}

* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

header {
	display: flex;
	height: 200px;
	padding: 2rem;
	background-color: darkolivegreen;
	text-align: center;
	align-items: center;
	justify-content: center;
	margin: 0px;
	color: #fff;
}

nav.main-nav ul {
	display: flex;
	list-style: none;
	background-color: goldenrod;
	color: #fff;
}

nav.main-nav li:nth-child(2), nav.main-nav li:nth-child(3) {
	margin-left: auto;
}

nav.main-nav li:hover {
	background-color: #ccc;
	color: black;
}

nav.main-nav li {
	cursor: pointer;
	padding: 0.5rem;
}

table.hosp-list {
	border-collapse: collapse;
	border-spacing: 0;
	width: 90%;
	border: 1px solid #ccc;
	margin: 20px auto;
}

table.hosp-list th {
	text-align: left;
}

table.hosp-list tr {
	border: 1px solid #ddd;
	cursor: pointer;
}

table.hosp-list tr:nth-child(even) {
	background-color: #ccc;
}

table.hosp-list tr:nth-child(odd) {
	background-color: #fff;
}

table.hosp-list tr:hover {
	background-color: #ddd;
}

table.hosp-list td, table.hosp-list th {
	padding: 8px;
	vertical-align: top;
	white-space: nowrap; /* table의 text를 줄바꿈 하지 않기!*/
}
</style>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		const menu_station = document
				.querySelector("nav.main-nav .get-station")
		menu_station.onclick = function() {
			document.location.href = "${rootPath}/bis/station"
		}
	})
</script>
<body>
	<header>
		<h2>전주시 동물병원</h2>
	</header>
	<nav class="main-nav">
		<ul>
			<li>Home</li>
			<li><input></li>
			<li>
				<form>
					<input name="hosp" type="search" placeholder="동물병원 이름 입력 후 ENTER">
				</form>
			</li>
			<li class="get-station">노선정보가져오기</li>
		</ul>
	</nav>
	
	<section>
		<table class="hosp-list">
			<thead>
				<tr>
					<th>순번</th>
					<th>병원이름</th>
					<th>도로명주소</th>
					<th>지번주소</th>
					<th>전화번호</th>
					<th>위도</th>
					<th>경도</th>
					<th>데이터기준일</th>
				</tr>
			</thead>
			
			<tbody>
				<c:choose>
					<c:when test="${empty H_LIST}">
						<tr><td colspan="8">데이터 없음</td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${H_LIST}" var="hs" varStatus="i">
							<tr>
								<td>${i.count}</td>
								<td>${hs.apiDongName}</td>
								<td>${hs.apiNewAddress}</td>
								<td>${hs.apiOldAddress}</td>
								<td>${hs.apiTel}</td>
								<td>${hs.apiLat}</td>
								<td>${hs.apiLng}</td>
								<td>${hs.apiRegDate}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</section>
</body>
</html>