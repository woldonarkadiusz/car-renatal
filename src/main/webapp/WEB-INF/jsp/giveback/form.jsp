<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create giveback</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Create giveback form</h2>
<form:form action="/giveback/create" method="POST" modelAttribute="giveback">
    Giveback ID: ${giveback.id}<br />
    Booking ID: ${giveback.booking.customer.id}<br />
    Booking: ${giveback.booking.customer.firstName} ${giveback.booking.customer.lastName}<br />
    Beginning of booking rent: ${giveback.booking.beginningOfRent} <br />
    End of booking rent: ${giveback.booking.endOfRent} <br />
    Notes: ${giveback.booking.rent.notes} <br />
    Giveback date: <form:input path="givebackDate"/> <br />
    Giveback notes: <form:input path="givebackNotes"/> <br />
    Extra charge: <form:input path="extraCharge"/> <br />
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>
