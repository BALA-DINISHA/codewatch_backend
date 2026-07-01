<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="forgetpassword.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h2>Reset Password</h2>
<form action="forgetpassword" method="post">
	<input type="email"
			name="email"
			placeholder="Enter your E-mail"
			required>
	<input type="password"
			name="newpassword"
			placeholder="Enter new Password"
			required>
	<button type="submit">
		Reset Password
	</button>
</form>
</div>
<style>
@charset "UTF-8";
*{
	margin:0;
	padding:0;
	box-sizing:border-box;
}

body{
	font-family: "Roboto Condensed", sans-serif;
	min-height: 100vh;
	display:flex;
	justify-content:center;
	align-items:center;
	background: linear-gradient(135deg,#ffe4ec,#edcedf,#ffffff);
}
.container{
    width:400px;
    padding:40px;
    background:rgba(255,255,255,0.25);
    backdrop-filter:blur(15px);
    -webkit-backdrop-filter:blur(15px);
    border-radius:25px;
    box-shadow:0 15px 35px rgba(0,0,0,.15);
    text-align:center;
}

.container h2{
    margin-bottom:25px;
    color:#333;
}

input{
    width:100%;
    padding:14px;
    margin:10px 0;
    border:1px solid palevioletred;
    border-radius:12px;
    outline:none;
    font-size:15px;
}

input:focus{
    border-color:#ff6fa0;
}

button{
    width:100%;
    padding:14px;
    margin-top:15px;
    border:none;
    border-radius:30px;
    background:palevioletred;
    color:white;
    font-size:16px;
    font-weight:600;
    cursor:pointer;
    transition:.3s;
}
@media screen and (max-width: 768px){



    body{

        padding: 15px;

    }



    .container{

        width: 100%;

        max-width: 400px;

        padding: 25px;

    }



    .container h2{

        font-size: 24px;

    }



    input{

        font-size: 16px;

        padding: 12px;

    }



    button{

        font-size: 16px;

        padding: 12px;

    }

}
</style>
</body>
</html>