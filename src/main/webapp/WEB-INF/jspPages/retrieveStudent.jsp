<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: dz-gg-03
  Date: 29/10/18
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Retrieve Student</title>

</head>
</head>
<body><center>
    <br>
    <strong>Student Details</strong>


<c:if test="${check==0}">
<table cellspacing="20%">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${requestScope.list}" var="student">
        <tr>
            <td><c:out value="${student.id}"/></td>
            <td contenteditable="true"><c:out value="${student.stdname}"/></td>
            <td contenteditable="true"><c:out value="${student.age}"/></td>
            <td><a href="<c:url value="DeleteStudent?id="/><c:out value="${student.id}"/>">Delete</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="<c:url value="UpdateStudent?id="/><c:out value="${student.id}"/>">Update</a></td>
        </tr>
    </c:forEach>
    <br>
    <br>

</table>

</c:if>

    <form method="get" action="<c:out value="SelectTask "></c:out> ">
     <input type="submit" value="add">

    </form>

</center>
</body>
</html>
