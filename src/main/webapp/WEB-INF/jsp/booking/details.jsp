<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Details of booking</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Details of booking:</h2>
    Customer: ${booking.customer.firstName} ${booking.customer.lastName}<br />
    Car: ${booking.car.company} ${booking.car.model}<br />
    Department: ${booking.car.department.name} - ${booking.car.department.address} ${booking.car.department.city}<br />
    Date of booking: ${booking.dateOfBooking}<br />
    Beginning of rent: ${booking.beginningOfRent} <br />
    End of rent: ${booking.endOfRent} <br />
    Price: ${booking.price} <br /><br />
    <a href="edit/${booking.id}">Edit</a> |
    <a href="delete?id=${booking.id}">Delete</a>
    <br /><br /><br />
</body>
</html>