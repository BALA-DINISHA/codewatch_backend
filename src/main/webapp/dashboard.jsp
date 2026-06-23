<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.util.*" %>
	<%@ page import="codewatch.model.*" %>
	<%
	List<Student> students=(List<Student>)request.getAttribute("students");
	%>
	<table  border="1">
	
	<tr>
		<th>Name</th>
		<th>Username</th> 
		<th>Easy</th> 
		<th>Medium</th> 
		<th>Hard</th>
		<th>Total</th>   
	</tr>
	
		<%
		for(Student s:students)
		{
		%>
		<tr>
		<td><%= s.getName() %></td> 
		<td><%= s.getLeetcodeUsername() %></td> 
		<td><%= s.getEasySolved() %></td> 
		<td><%= s.getMediumSolved() %></td> 
		<td><%= s.getHardSolved() %></td> 
		<td><%= s.getTotalSolved() %></td>
		</tr>
		<%
		}
		%>
	
	</table>
</body>
</html>