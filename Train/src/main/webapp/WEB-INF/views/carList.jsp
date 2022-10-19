<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<title>차량 조회</title>
</head>
<body>
	<div class="container mt-3">
		<h2>차량 목록</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>브랜드</th>
					<th>모델</th>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${carList}">
					<tr>
						<td>${list.number}</td>
						<td>${list.brand}</td>
						<td>${list.model}</td>
						<td>${list.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>