<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="container mt-3">
		<h2>회원가입</h2>
		<form action="doJoin" method="post">
			<div class="mb-3 mt-3">
				<label for="id">ID:</label> <input type="text"
					class="form-control" id="id" placeholder="Enter ID"
					name="id">
			</div>
			<div class="mb-3">
				<label for="pwd">PW:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter password"
					name="pwd">
			</div>
			<button type="submit" class="btn btn-primary">가입</button>
			<button type="button" class="btn btn-primary" onclick="goBack()">취소</button>
		</form>
	</div>
	
	<script type="text/javascript">
		function goBack() {
			window.history.back();
		}
	</script>
</body>
</html>