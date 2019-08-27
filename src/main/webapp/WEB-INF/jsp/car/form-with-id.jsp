<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create car</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Create car form</h2>
<form:form action="/car/create/${departmentId}" method="POST" modelAttribute="car">
    Company: <form:input path="company"/> <br />
    Model: <form:input path="model"/> <br />
    Category: <form:input path="category"/> <br />
    Year: <form:input path="year"/> <br />
    Color: <form:input path="color"/> <br />
    Mileage: <form:input path="mileage"/> <br />
    Status: <form:input path="status"/> <br />
    Price per day: <form:input path="pricePerDay"/> <br />
    Department: ${car.department.name} - ${car.department.address} ${car.department.city} <br />
    <input type="submit" value="Create"/>
</form:form>

</body>
</html>