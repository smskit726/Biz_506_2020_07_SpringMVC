<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link href="${rootPath}/resources/css/layout.css?ver=001" rel="stylesheet" />
<script src="https://kit.fontawesome.com/4f95742a0c.js" crossorigin="anonymous"></script>
<title>Tiles</title>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="menu"/>
	<section id="content">
		<tiles:insertAttribute name="content"/>
	</section>
	<tiles:insertAttribute name="footer"/>
</body>
</html>