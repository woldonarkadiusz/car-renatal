<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create booking</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Create booking form</h2>
<form:form action="/booking/create/${bookingId}/finish" method="POST" modelAttribute="booking">
  <form:hidden path="beginningOfRent"/>
  <form:hidden path="endOfRent"/>

    <c:forEach items="${cars}" var="car">
        <form:radiobutton path="carId" value="${car.id}"/> - Price per day: ${car.pricePerDay}<br/>
        Company: ${car.company}<br/>
        Model: ${car.model} <br/>
        Category: ${car.category} <br/>
        Year: ${car.year} <br/>
        Color: ${car.color}<br/>
        Mileage: ${car.mileage} <br/>
        Status: ${car.status} <br/><br/><br/>
    </c:forEach>
    <br/>

    <input type="submit" value="Create"/>
</form:form>


<br/><br/><br/>
</body>
</html>