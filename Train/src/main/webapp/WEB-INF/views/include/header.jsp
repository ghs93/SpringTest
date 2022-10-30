<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Train</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div style="text-align: right;">
		<c:choose>
			<c:when test="${empty userInfo}">
				<a href="${pageContext.request.contextPath}/user/moveLogin">로그인</a>
				<a href="${pageContext.request.contextPath}/user/moveJoin">회원가입</a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
			</c:otherwise>
		</c:choose>
	</div>