<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit booking</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Edit booking form</h2>
<form:form action="/booking/edit/${booking.id}" method="POST" modelAttribute="booking">
    Date of booking: <form:input path="dateOfBooking"/> <br />
    Beginning of rent: <form:input path="beginningOfRent"/> <br />
    End of rent: <form:input path="endOfRent"/> <br />
    Price: <form:input path="price"/> <br />
    <form:hidden path="id" />
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
