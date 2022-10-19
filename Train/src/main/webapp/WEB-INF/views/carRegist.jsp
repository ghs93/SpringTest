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
<title>차량 등록</title>
</head>
<body>
  <h2>차량 등록</h2>
  <form action="${pageContext.request.contextPath}/car/doRegist">
    <div class="mb-3 mt-3">
      <label for="num">등록번호:</label>
      <input type="text" class="form-control" id="num" placeholder="차량 등록번호" name="num">
    </div> <div class="mb-3 mt-3">
      <label for="brand">브랜드:</label>
      <input type="text" class="form-control" id="brand" placeholder="차량 브랜드" name="brand">
    </div>
    <div class="mb-3">
      <label for="model">모델:</label>
      <input type="text" class="form-control" id="model" placeholder="차량 모델" name="model">
    </div>
    <div class="mb-3">
      <label for="price">가격:</label>
      <input type="number" class="form-control" id="price" placeholder="단위: 만" name="price" min=0>
    </div>
    <button type="submit" class="btn btn-primary">등록</button>
  </form>
</body>
</html>