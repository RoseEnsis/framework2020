<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<h1>INSERT PAGE</h1>
	<form action="insert" method="post">
		<div>
			<label for="name">name</label>
			<input type="text" name="name" id="name"/>
		</div>
		<div>
			<label for="pay">pay</label>
			<input type="text" name="pay" id="pay"/>
		</div>
		<div>
			<button>입력</button>
		</div>
	</form>
</body>
</html>