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
<%--<form:form action="/booking/create/finish" method="POST" modelAttribute="booking">--%>
    <%--Beginning of rent: <form:input path="beginningOfRent"/> <br/>--%>
    <%--End of rent: <form:input path="endOfRent"/> <br/>--%>
<%--</form:form>--%>
<form:form action="/booking/create-car" method="GET" modelAttribute="booking">
    Beginning of rent: <form:input path="beginningOfRent"/> <br/>
    End of rent: <form:input path="endOfRent"/> <br/>
    Departments:
    <select name="department">
        <c:forEach items="${departments}" var="department">
            <option value="${department.id}">${department.name} - ${department.address} ${department.city}</option>
        </c:forEach><br/>
    </select><br/>
    <input type="submit" value="Submit"/><br/>
</form:form>

<br/><br/><br/>
<%--Cars: <select name="car">--%>
<%--<c:forEach items="${cars}" var="car">--%>
<%--<option value="${car.id}">${car.company} ${car.model}</option>--%>
<%--</c:forEach>--%>
<%--</select><br />--%>
<%--<form:form action="/booking/create" method="POST" modelAttribute="booking">--%>
<%--Date of booking: <form:input path="dateOfBooking"/> <br/>--%>
<%--Beginning of rent: <form:input path="beginningOfRent"/> <br/>--%>
<%--End of rent: <form:input path="endOfRent"/> <br/>--%>
<%--Price: <form:input path="price"/> <br/>--%>
<%--<input type="submit" value="Create"/>--%>
<%--</form:form>--%>
</body>
</html>