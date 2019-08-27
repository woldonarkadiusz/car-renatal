<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employees list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Employees list</h2>

<c:forEach items="${employees}" var="employee">
    First name: ${employee.firstName}<br />
    Last name: ${employee.lastName} <br />
    Position: ${employee.position} <br />
    Department: ${employee.department.name} <br />
    <a href="edit/${employee.id}">Edit</a> |
    <a href="delete?id=${employee.id}">Delete</a>
    <br /><br /><br />
</c:forEach>
</body>
</html>