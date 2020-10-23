<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>
<style>

	form#write-form {
		width: 80%;
		margin: 10px auto;
		
	}
	
	form#write-form fieldset{
		border: 1px solid coral;
		border-radius: 10px;
	}
	
	form#write-form legend {
		width:10%;
		text-align:center;
		font-size: 15pt;
		color: darkblue;
		margin: 5px;
		padding: 5px;
	}
	
	form#write-form label {
		display: inline-block;
		width: 18%;
		padding: 4px;
		margin: 4px;
		color: darkblue;
		text-align: right;
		font-weight: bold;
	}
	
	form#write-form input {
		display: inline-block;
		width: 70%;
		padding: 4px;
		margin: 4px;
	}
	
	form#write-form textarea {
		padding:4px;
		margin:4px;
		width: 70%;
	}
	
	div.btn-box {
		width: 95%;
		text-align: right;
	}
	
	form#write-form .btn-box button {
		color: white;
		cursor: pointer;
		border: none;
		border-radius: 5px;
		outline: none;
		padding: 5px 10px;
		margin: 5px;	
	}
	
	form#write-form .btn-box button:hover{
		box-shadow: 2px 2px 2px rgba(0,0,0,0.5)
	}
	
	button#save {
		background-color: burlywood;
	}
	
	button#list {
		background-color: coral;
	}
</style>
<script>
	$(function(){
		var toolbar = [
			['style',['bold','italic','underline'] ],
			['fontsize',['fontsize']],
			['font Style',['fontname']],
			['color',['color']],
			['para',['ul','ol','paragraph']],
			['height',['height']],
			['table',['table']],
			['insert',['link','hr','picture']],
			['view',['fullscreen','codeview']]
			
		]
		
		$("#b_content").summernote({
				lang:"ko-KR",
				width:"80%",
				height:"200px",
				toolbar : toolbar
				})
	})
</script>
<form id="write-form" method="POST" enctype="multipart/form-data">
	<fieldset>
		<legend>글쓰기</legend>
		<div>
			<label for="b_date">작성일자</label>
			<input name="b_date">
		</div>
		<div>
			<label for="b_time">작성시각</label>
			<input name="b_time">
		</div>
		<div>
			<label for="b_writer">작성자</label>
			<input name="b_writer">
		</div>
		<div>
			<label for="b_subject">제목</label>
			<input name="b_subject">
		</div>
		
		<div style="display:flex; justify-content: center; padding: 5px;">
			<textarea id="b_content" rows="5" cols="20" name="b_content"></textarea>
		</div>
		
		<div style="margin-top: 10px;">
			<label for="file">이미지</label>
			<input name="file" type="file" accept="image/*">
		</div>
		
		<div style="margin-top: 10px;">
			<label for="files">멀티이미지</label>
			<input name="files" type="file" accept="image/*" multiple="multiple">
		</div>
		
		<div class="btn-box">
			<button type="button" id="list">리스트</button>
			<button type="submit" id="save">저장</button>
		</div>
	</fieldset>
</form>