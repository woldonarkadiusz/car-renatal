<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit car</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Edit car form</h2>
<form:form action="/car/edit/${car.id}" method="POST" modelAttribute="car">
    Company: <form:input path="company"/> <br />
    Model: <form:input path="model"/> <br />
    Category: <form:input path="category"/> <br />
    Year: <form:input path="year"/> <br />
    Color: <form:input path="color"/> <br />
    Mileage: <form:input path="mileage"/> <br />
    Status: <form:input path="status"/> <br />
    Price per day: <form:input path="pricePerDay"/> <br />
    Current department: ${car.department.name} - ${car.department.address} ${car.department.city} <br />
    New department:
    <select name="department">
        <c:forEach items="${departments}" var="department">
            <option value="${department.id}">${department.name}</option>
        </c:forEach><br />
    </select><br />
    <form:hidden path="id" />
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>