<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/car/list">차량 목록</a>
	<a href="${pageContext.request.contextPath}/car/regist">차량 등록</a>
</body>
</html>
