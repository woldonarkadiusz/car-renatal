<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Givebacks list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Givebacks list</h2>

<c:forEach items="${givebacks}" var="giveback">
    Rent ID: ${giveback.id}<br />
    Booking ID: ${giveback.booking.customer.id}<br />
    Booking: ${giveback.booking.customer.firstName} ${giveback.booking.customer.lastName}<br />
    Beginning of booking rent: ${giveback.booking.beginningOfRent} <br />
    End of booking rent: ${giveback.booking.endOfRent} <br />
    Notes: ${giveback.booking.rent.notes} <br />
    Giveback date: ${giveback.givebackDate} <br />
    Giveback notes: ${giveback.givebackNotes} <br />
    Extra charge: ${giveback.extraCharge} <br />
    <a href="edit/${giveback.id}">Edit</a> |
    <a href="delete?id=${giveback.id}">Delete</a>
    <br /><br /><br />
</c:forEach>
</body>
</html>