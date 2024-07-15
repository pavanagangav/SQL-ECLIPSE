<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="bootstrap.jsp" %>
<body>
<form action="register" method="post">
<input type="text" placeholder="enter roll number" class="form-control" name="rollnumber">
<input type="text" placeholder="enter full name" class="form-control" name="name">
<input type="text" placeholder="enter branch" class="form-control" name="branch">
<input type="email" placeholder="enter email" class="form-control" name="email">
<input type="text" placeholder="enter section" class="form-control" name="section">
<button class="btn btn-primary">Register</button>
</form>
</body>
</html>