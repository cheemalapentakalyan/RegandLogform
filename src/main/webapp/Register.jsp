<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Register form</h1>
<form action="regForm" method="post">

Name: <input type="text" name="name1"><br><br>
Email: <input type="text" name="email1"><br><br>
Password: <input type="password" name="pass1"><br><br>
gender: <input type="radio" name="gender1"/>Male <input type="radio" name="gender1"/>Female  <br><br>

City: <select name="city1">
          <option> select city</option>
          <option> hyderabad1</option>
          <option> bangalore1</option>
          <option> chennai1</option>   
        </select> <br><br>
        <input type ="submit" value="Register">
</form>

</body>
</html>