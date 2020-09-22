<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>도서정보 등록</title>

<style>
	form#books {
		width: 60%;
		margin: 10px auto;
	}
	
	form#books input {
		display: block;
		width: 90%;
		border: 1px solid #ddd;
		margin: 5px auto;
		padding: 8px;
	}
	
	form#books fieldset {
		border: 1px solid rgb(0,100,200);
		border-radius: 10px;
	}
</style>
</head>

<body>
<h3>도서정보 등록</h3>

<form method="POST" id="books">
	<fieldset>
		<legend>도서정보 입력</legend>
			<input name="seq" placholder="일련번호"/>
			<input name=title placholder="도서명"/>
			<input name=link placholder="상세링크"/>
			<input name=image placholder="이미지"/>
			<input name=author placholder="저자"/>
			<input name=price placholder="가격"/>
			<input name=discount placholder="할인"/>
			<input name=publisher placholder="출판사"/>
			<input name=isbn placholder="ISBN"/>
			<input name=description placholder="세부설명"/>
			<input name=pubdate placholder="출간일자"/>
			<input name=buydate placholder="구입일자"/>
			<input name=buyprice placholder="구입금액"/>
			<input name=buystore placholder="구입처"/>
			<button>저장</button>
	</fieldset>

</form>

</body>
</html>