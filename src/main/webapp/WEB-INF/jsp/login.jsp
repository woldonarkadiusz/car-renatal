<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login form</title>
</head>
<body>
<h2>Login form</h2>
<form action="/login" method="POST">
    <input name="username" type="text">
    <input name="password" type="password">
    <input type="submit" value="Login"/>
</form>

</body>
</html>