<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

	<div class="container mt-3">
		<h2>차량 상세 정보</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>구분</th>
					<th>설명</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>ID</td>
					<td>${detail.number}</td>
				</tr>
				<tr>
					<td>브랜드</td>
					<td>${detail.brand}</td>
				</tr>
				<tr>
					<td>모델</td>
					<td>${detail.model}</td>
				</tr>
				<tr>
					<td>가격</td>
					<td>${detail.price}</td>
				</tr>
			</tbody>
		</table>
		<c:if test="${not empty detail.fileInfo}">
			<div>
				<a href="">${detail.fileInfo.originFile}</a>
			</div>
		</c:if>
		<button type="button" onclick="history.back()">목록</button>
	</div>
</body>
</html>