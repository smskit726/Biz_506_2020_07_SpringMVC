<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>

<style> 
section#login-body {
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}

h2 i.fas.fa-cat {
	color: tomato;
}

h2#login-title {
	text-align: center;
}

form {
	display: flex;
	border-radius:10px;
	width: 50%;
	height:80%;
	flex-flow: column;
	align-items: center;
	justify-content: center;
	border: 1px solid #ccc;
	background-color: blanchedalmond;
}

form input {
	width: inherit;
	margin: 5px;
	padding: 5px;
	text-align: center;
}

form button {
	width: inherit;
	border: none;
	border-radius:5px;
	background-color: green;
	color: white;
	margin: 5px;
	padding: 0.3rem;
	cursor: pointer;
	outline: 0;
	font-size: 15px;
}

form button:hover {
	background-color: #ddd;
	color: black;
}

form h4 {
	color: red;
	margin: 1rem;
}
</style>
<section id="login-body">
	<form action="${rootPath}/login" method="POST">
		<h2 id="login-title"><i class="fas fa-cat">&nbsp;</i>로그인</h2>
		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
			<h4 id="login-fail">${SPRING_SECURITY_LAST_EXCEPTION.message}</h4>
			
		</c:if>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <label for="username">아이디</label><input name="username" placeholder="USER ID" />
        <label for="password">비밀번호</label><input name="password" placeholder="PASSWORD" type="password" />
        <button>로그인</button>
	</form>
</section>
</html>