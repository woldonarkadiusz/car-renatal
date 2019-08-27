<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create employee</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Create employee form</h2>
<form:form action="/employee/create" method="POST" modelAttribute="employee">
    First name: <form:input path="firstName"/> <br />
    Last name: <form:input path="lastName"/> <br />
    Position: <form:input path="position"/> <br />
    Department:
    <select name="department">
        <c:forEach items="${departments}" var="department">
            <option value="${department.id}">${department.name}</option>
        </c:forEach>
    </select><br />
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>