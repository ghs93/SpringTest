<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center;">
		<form method="post" action="login">
			<label for="id">ID: </label>
			<input type="text" id="id" name="id" placeholder="id 입력">
			<label for="pass">PW: </label>
			<input type="password" id="pass" name="pass" placeholder="pass 입력">
			<input type="submit" value="로그인">
		</form>
	</div>
</body>
</html>