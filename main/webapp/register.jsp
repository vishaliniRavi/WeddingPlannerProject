<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="signup-box">
        <h1>Sign Up</h1>
        <form action="Register" method="post">
            <label>Name</label>
            <input type="text" id="name"  name="username" placeholder="" pattern="[A-Za-z]{3,}" required>
            <label>Mobile number</label>
            <input type="phone" id="number" name="phonenumber" placeholder="" pattern="[6-9][0-9]{9}" required>
            <label>city</label>
            <input type="text" id="city" name="city" placeholder="" pattern="[A-Za-z0]{4,25}" required>
            <label>Email</label>
            <input type="email" id="email" name="email" placeholder="" pattern="[a-z]+[a-z0-9]+[@][a-z]+[.][a-z]+" required>
            <label>Password</label>
            <input type="password" id="password" name="password" placeholder="" pattern="[A-Z]+[a-z]+[@#$]+[0-9]+{8,20}" required>
            <input type="submit" value="submit">
        </form>
    </div>
    <p>Already have an account?<a href="login.jsp">Login here</a></p>
</body>
</html>