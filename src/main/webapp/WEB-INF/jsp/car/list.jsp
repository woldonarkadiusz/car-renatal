<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cars list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Cars list</h2>
<c:forEach items="${cars}" var="car">
    Company: ${car.company}<br />
    Model: ${car.model} <br />
    Category: ${car.category} <br />
    Year: ${car.year} <br />
    Color: ${car.color}<br />
    Mileage: ${car.mileage} <br />
    Status: ${car.status} <br />
    Price per day: ${car.pricePerDay} <br />
    Department: ${car.department.name} - ${car.department.address} ${car.department.city}<br /><br />
    <a href="edit/${car.id}">Edit</a> |
    <a href="delete?id=${car.id}">Delete</a>
    <br /><br /><br />
</c:forEach>
</body>
</html>