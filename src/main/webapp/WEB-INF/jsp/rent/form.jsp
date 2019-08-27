<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create rent</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Create rent form</h2>
<form:form action="/rent/create" method="POST" modelAttribute="rent">
    Rent ID: ${rent.id}<br />
    Customer: ${rent.booking.customer.firstName} ${rent.booking.customer.lastName}<br />
    Beginning of rent: ${rent.booking.beginningOfRent} <br />
    End of rent: ${rent.booking.endOfRent} <br />
    Notes: <form:input path="notes"/> <br />
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>
