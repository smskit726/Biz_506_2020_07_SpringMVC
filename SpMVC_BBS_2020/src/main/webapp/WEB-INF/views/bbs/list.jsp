<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>
<script>
	document.addEventListener("DOMContentLoaded", function(){
		document.querySelector("#bbs-write").addEventListener("click", function(){
			document.location.href="${rootPath}/bbs/write"
		})
	})
</script>
<style>

	div.btn_box{
		text-align: right;
	}
	button#bbs-write {
		border: none;
		background-color: coral;
		outline: none;
		border-radius: 5px;
		padding: 5px 10px;
		margin: 5px;
	}
</style>
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>NO</th>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회수</th>
		</tr>
	</thead>
	
	<tbody>
		<c:if test="${empty BBS_LIST}">
			<tr><td colspan="6">데이터가 없습니다.</td></tr>
		</c:if>
		<c:forEach items="${BBS_LIST}" var="vo" varStatus="i">
			<tr>
					<td>${i.count}</td>
					<td>${vo.b_date}</td>
					<td>${vo.b_time}</td>
					<td>${vo.b_writer}</td>
					<td>${vo.b_subject}</td>
					<td>${vo.b_count}</td>
			</tr>
		</c:forEach>
	</tbody>	
</table>

<div class="btn_box">
	<button id="bbs-write">글쓰기</button>
</div>