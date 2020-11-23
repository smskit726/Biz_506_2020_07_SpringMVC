<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>GRADE</title>
</head>
<body>
<table>
	<tr>
		<th>학번</th>
		<th>이름</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>총점</th>
		<th>평균</th>
		<th>기타</th>
	</tr>
	
	<c:if test="${empty G_LIST }">
		<tr><td colspan="8">데이터가 없습니다.</td></tr>
	</c:if>
	
	<c:forEach items="${G_LIST}" var="vo">
		<tr>
			<td>${vo.g_code}</td>
			<td><a href="${rootPath}/update?id=${vo.g_seq}">${vo.g_name}</a></td>
			<td>${vo.g_kor}</td>
			<td>${vo.g_eng}</td>
			<td>${vo.g_math}</td>
			<td>${vo.g_total}</td>
			<td>${vo.g_avg}</td>
			<td><a href="${rootPath}/delete?id=${vo.g_seq}">삭제</a></td>
		</tr>
	</c:forEach>
</table>
<div>
	<div><a href="${rootPath}/input">새로작성</a></div>
</div>
</body>
</html>