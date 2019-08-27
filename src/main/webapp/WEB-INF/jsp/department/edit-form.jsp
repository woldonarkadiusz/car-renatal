<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit department</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Edit department form</h2>
<form:form action="/department/edit/${department.id}" method="POST" modelAttribute="department">
    Name: <form:input path="name"/> <br />
    Address: <form:input path="address"/> <br />
    City: <form:input path="city"/> <br />
    <form:hidden path="id" />
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>