<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

  <h2>차량 등록</h2>
  <form action="${pageContext.request.contextPath}/car/doRegist"
  	method="post" enctype="multipart/form-data">
    <div class="mb-3 mt-3">
      <label for="number">등록번호:</label>
      <input type="text" class="form-control" id="number" placeholder="차량 등록번호" name="number">
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
    <!-- 파일 업로드 start -->
	<div class="form-group">
		<label for="file">파일: </label> <input type="file"
			class="form-control-file" name="file" id="file">
	</div>
    <button type="submit" class="btn btn-primary">등록</button>
  </form>
</body>
</html>