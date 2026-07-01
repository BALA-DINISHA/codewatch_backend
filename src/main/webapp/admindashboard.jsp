<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
if(session.getAttribute("name") == null){
    response.sendRedirect("index.html");
    return;
}
int displayRank=1;

%>
<%@ page import="java.util.*" %>
<%@ page import="codewatch.model.Student" %>
<%
List<Student> students =
    (List<Student>) request.getAttribute("students");

%>
<%
Student top1 = (Student)request.getAttribute("top1");
Student top2 = (Student)request.getAttribute("top2");
Student top3 = (Student)request.getAttribute("top3");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="admindashboard.css">
</head>
<body>
<%
String success = request.getParameter("success");
String action = request.getParameter("action");


if("true".equals(success)&& "add".equals(action)){
%>

<div class="success-msg">
    🎉 Student Registered Successfully!
</div>

<%
}

if("true".equals(success) && "delete".equals(action)){
%>
<div class="success-msg">
    🗑️ Student Deleted Successfully!
</div>
<%
}
%>
<% 
if("false".equals(success)&& "add".equals(action)){

%>

<div class="error-msg">
    ❌ Failed to Register Student!
</div>

<%
}
%>
<% 
if("false".equals(success)&& "delete".equals(action)){

%>

<div class="error-msg">
    ❌ Failed to delete Student!
</div>

<%
}
%>
	<div class="sidebar">

    <%
    //<img src="images/profile.jpg"

    // alt="Profile"

    // class="profile-pic">
    
    
    %>
	<div class="profile-pic default-avatar">
    <i class="fa-solid fa-user"></i>
</div>
    <h2>
        <%= session.getAttribute("name") %>
    </h2>

    <p>
        <%= session.getAttribute("email") %>
    </p>
	<a href="<%= request.getContextPath() %>/logout" class="logout-Btn">
	<i class="fa-solid fa-right-from-bracket"></i>Logout
	</a>
</div>
    <div class="header">
        <h1>Student Dashboard</h1>
    </div>
    <div>
    <% 
    		// ADD STUDENT
    %>

        <button id="addStudentBtn" class="add-btn">
             <i class="fa-solid fa-plus"></i> Add Student
        </button>
        
        
    <div class="cards">
        <div class="card">
            <h3>Total Students</h3>
            <p><%= students.size()%></p>
        </div>
        <div class="card">
            <h3>Problem's Solved</h3>
            <p><%= top1 != null ? top1.getTotalSolved() : "-" %></p>
        </div>
        <div class="card">
            <h3>Top Student</h3>
            <p>
<%= top1 != null ? top1.getName() : "-" %>
</p>
        </div>
    </div>
    <div class="top3">
       <div class="winner first">
    <i class="fa-solid fa-medal"></i>
    <%= top1 != null ? top1.getName() : "-" %>
</div>

<div class="winner second">
    <i class="fa-solid fa-medal"></i>
    <%= top2 != null ? top2.getName() : "-" %>
</div>

<div class="winner third">
    <i class="fa-solid fa-medal"></i>
    <%= top3 != null ? top3.getName() : "-" %>
</div>
    </div>
    <div class="search-box">
    <span class="search-icon">
        <i class="fa-solid fa-magnifying-glass"></i>
    </span>
    <input type="text" id="searchinput" placeholder="Search Student">
</div>
    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>Rank</th>
                    <th>Name</th>
                    <th>Batch</th>
                    <th>Easy</th>
                    <th>Medium</th>
                    <th>Hard</th>
                   
                    
                    <th>Total Solved</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>

<%
displayRank = 1;

if(students != null){
    for(Student s : students){
%>

<tr>
    <td><%= displayRank++ %></td>

    <td>
    <a class="student-link"
       href="StudentProfileServlet?id=<%= s.getId() %>">
       <%= s.getName() %>
    </a>
   </td>

    <td><%= s.getBatch() %></td>
    <td><%= s.getEasySolved() %></td>
    <td><%= s.getMediumSolved() %></td>
    <td><%= s.getHardSolved() %></td>

   

    

    <td><%= s.getTotalSolved() %></td>
    <td>
    <a class="student-link"
       href="DeleteServelt?id=<%= s.getId() %>">
       
        <i class="fa-solid fa-remove"></i>
    </a>
       
    </td>
</tr>

<%
    }
}
%>

</tbody>
        </table>
    </div>
   <div class="modal" id="studentmodal">
    <div class="modal-content">

        <span class="close-btn" id="closeModal">
            &times;
        </span>

        <h2>Register Student</h2>

        <form action="addStudent" method="post">

            <input
                type="text"
                name="name"
                placeholder="Student Name"
                required>

            <input
                type="email"
                name="email"
                placeholder="E-mail"
                required>

            <input
                type="text"
                name="leetcode"
                placeholder="Leetcode Username"
                required>

            <input
                type="text"
                name="batch"
                placeholder="Batch"
                required>

            <button
                type="submit"
                class="register-btn">
                Register
            </button>

        </form>

    </div>
</div>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="admindashboard.js"></script>
</body>
</html>