<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

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
							<td><a href="${pageContext.request.contextPath}/car/detail?number=${list.number}">${list.brand}</a></td>
							<td>${list.model}</td>
							<td>${list.price}</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>