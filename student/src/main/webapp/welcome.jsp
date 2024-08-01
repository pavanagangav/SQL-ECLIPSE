<%@page import="model.login"%>
<%@page import="java.util.List"%>
<%@page import="dbconnection.loginconnection"%>
<%@page import="services.loginservice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>welcome</h1>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>email</th>
				<th>password</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
            loginservice ls=new loginservice(loginconnection.getconnection());
			List<login> ll=ls.fetchall();
			for(login lo:ll){
			%>
			<tr>
				<td><%=lo.getId() %></td>
				<td><%=lo.getName() %></td>
				<td><%=lo.getEmail() %></td>
				<td><%=lo.getPassword() %></td>
				<td>
				<button>update</button>
				<a href="deletebyid?id=<%=lo.getId()%>"><button>deletebyid</button></a>
				<a href="deletebyemail?email=<%=lo.getEmail()%>"><button>deletebyemail</button></a>
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>