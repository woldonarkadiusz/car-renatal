<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create customer</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Create customer form</h2>
<form:form action="/customer/create" method="POST" modelAttribute="customer">
    First name: <form:input path="firstName"/> <br />
    Last name: <form:input path="lastName"/> <br />
    Phone number: <form:input path="phoneNumber"/> <br />
    Address: <form:input path="address"/> <br />
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>