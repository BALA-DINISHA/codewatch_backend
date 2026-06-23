<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addStudent" method="post">

    Name:
    <input type="text" name="name">

    <br><br>

    LeetCode Username:
    <input type="text" name="leetcode">

    <br><br>

    Email:
    <input type="email" name="email">

    <br><br>

    Batch:
    <input type="text" name="batch">

    <br><br>
    Password:
    <input type="password" name="password">

    <br><br>

    <button type="submit">
        Add Student
    </button>

</form>
</body>
</html>