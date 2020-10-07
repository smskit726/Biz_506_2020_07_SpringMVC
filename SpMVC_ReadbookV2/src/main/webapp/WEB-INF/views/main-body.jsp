<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>
<style>
	section#main-body {
		display: flex;
		width: 100%;
	}
	
	section#main-body article {
		flex: 1;
		border: 1px solid blue;
		margin: 10px;
	}
</style>
<section id="main-body">

	<article>
		<p>도서목록</p>
	</article>
	
	<article>
		<p>독서록</p>
	</article>
	
	<article>
		<p>공지사항</p>
	</article>
	
</section>