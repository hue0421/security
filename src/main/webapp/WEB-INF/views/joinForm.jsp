<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div{
display: grid;
justify-content: flex-start;
}
</style>
</head>
<body>
	<h1>조인폼 페이지</h1>
	
	<form action="/joinProc" method="post">
	<div>
		<input type="text" name="username" placeholder="유저네임"/> 
		<input type="password" name="password" placeholder="비밀번호"/>
		<input type="email" name="email" placeholder="이메일"/>
		<button>회원가입</button>
		</div>
	</form>
</body>
</html>