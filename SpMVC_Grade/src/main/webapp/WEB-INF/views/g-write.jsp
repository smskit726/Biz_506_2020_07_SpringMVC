<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>성적입력</title>
</head>
<body>
	<form method="POST">
		<input type="hidden" name="g_seq" value="${GRADE.g_seq}">
		<div>
			<label for="g_code">학번</label>
			<input name="g_code" value="${GRADE.g_code}">
		</div>
		<div>
			<label for="g_name">이름</label>
			<input name="g_name" value="${GRADE.g_name}">
		</div>
		<div>
			<label for="g_kor">국어</label>
			<input name="g_kor" value="${GRADE.g_kor}">
		</div>
		<div>
			<label for="g_eng">영어</label>
			<input name="g_eng" value="${GRADE.g_eng}">
		</div>
		<div>
			<label for="g_math">수학</label>
			<input name="g_math" value="${GRADE.g_math}">
		</div>
		
		<div>
			<button>저장</button>
		</div>
	</form>
</body>
</html>