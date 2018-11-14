<%--
  Created by IntelliJ IDEA.
  User: dz-gg-03
  Date: 29/10/18
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
<center>
<form method="post" action="<c:out value="AddStudent"></c:out> ">
    <strong>Add Student Details</strong><br><br>
Student Name  <input type="text" name="name" pattern="[a-zA-Z\s]+" required ><br><br>
Student Age   <input type="text" name="age" pattern="[0-9][0-9]" required >
    <br>
    <br>
    <input type="submit">
    </form >
</center>
</body>
</html>
