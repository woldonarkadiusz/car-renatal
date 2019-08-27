<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit owner</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Edit owner form</h2>
<form:form action="/customer/edit/${customer.id}" method="POST" modelAttribute="customer">
    First name: <form:input path="firstName"/> <br />
    Last name: <form:input path="lastName"/> <br />
    Phone number: <form:input path="phoneNumber"/> <br />
    Address: <form:input path="address"/> <br />
    <form:hidden path="id" />
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>