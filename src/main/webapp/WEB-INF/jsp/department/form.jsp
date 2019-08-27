<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create department</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Create customer form</h2>
<form:form action="/department/create" method="POST" modelAttribute="department">
    Name: <form:input path="name"/> <br />
    Address: <form:input path="address"/> <br />
    City: <form:input path="city"/> <br />
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>