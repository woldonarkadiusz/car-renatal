<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Departmens list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Departments list</h2>
SELECT:


<form:form action="/department/list" method="POST" modelAttribute="department">
    <select name="department">
        <c:forEach items="${departments}" var="department">
            <option value="${department.id}">${department.name}</option>
        </c:forEach><br/>
        <input type="submit" value="Submit"/><br/>
    </select>
</form:form>
<c:forEach items="${department.cars}" var="car">
    Company: ${car.company}<br/>
    Model: ${car.model} <br/>
    Category: ${car.category} <br/>
    Year: ${car.year} <br/>
    Color: ${car.color}<br/>
    Mileage: ${car.mileage} <br/>
    Status: ${car.status} <br/>
    Price per day: ${car.pricePerDay} <br/><br/>
    <a href="edit/${car.id}">Edit</a> |
    <a href="delete?id=${car.id}">Delete</a>
    <br/><br/><br/>
</c:forEach>
<br/><br/><br/>

<table>
    <tr>
        <th>Deparment</th>
        <th>Cars</th>
    </tr>
<c:forEach items="${departments}" var="department">
        <tr>
            <td>
                Name: ${department.name}<br/>
                Address: ${department.address} <br/>
                City: ${department.city} <br/><br/>
                <a href="edit/${department.id}">Edit</a> |
                <a href="delete?id=${department.id}">Delete</a> |
                <a href="../car/create/${department.id}">Add car</a>
                <br/><br/><br/>
            </td>
            <c:forEach items="${department.cars}" var="car">
                <td>
                    Company: ${car.company}<br/>
                    Model: ${car.model} <br/>
                    Category: ${car.category} <br/>
                    Year: ${car.year} <br/>
                    Color: ${car.color}<br/>
                    Mileage: ${car.mileage} <br/>
                    Status: ${car.status} <br/>
                    Price per day: ${car.pricePerDay} <br/><br/>
                    <a href="../car/edit/${car.id}">Edit</a> |
                    <a href="../car/delete?id=${car.id}">Delete</a>
                    <br/><br/><br/>
                </td>
            </c:forEach>
        </tr>
</c:forEach>
</table>
</body>
</html>