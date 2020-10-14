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

</style>

<body>
<section id="login-body">
	<form action="${rootPath}/login" method="POST">
		<h2 id="login-title"><i class="fas fa-cat">&nbsp;</i>로그인</h2>
		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
			<h4 id="login-fail">${SPRING_SECURITY_LAST_EXCEPTION.message}</h4>
			
		</c:if>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input name="username" placeholder="USER ID" />
        <input name="password" placeholder="PASSWORD" type="password" />
        <button>로그인</button>
	</form>
</section>
</body>
</html>