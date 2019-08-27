<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Rents list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Rents list</h2>

<c:forEach items="${rents}" var="rent">
    Rent ID: ${rent.id}<br />
    Customer: ${rent.booking.customer.firstName} ${rent.booking.customer.lastName}<br />
    Beginning of rent: ${rent.booking.beginningOfRent} <br />
    End of rent: ${rent.booking.endOfRent} <br />
    Notes: ${rent.notes} <br />
    <a href="edit/${rent.id}">Edit</a> |
    <a href="delete?id=${rent.id}">Delete</a>
    <br /><br /><br />
</c:forEach>
</body>
</html>