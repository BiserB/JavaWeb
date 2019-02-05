<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <c:import url="partial/head.jsp"/>

<body>

<div class="wrapper">

    <hr class="style1"/>

    <c:import url="partial/navbar.jsp"/>

    <div class="jumbotron">
        <p class="h1 display-3">Welcome to MeTube&trade;!</p>
        <p class="h3">The simplest, easiest to use, most comfortable Multimedia Application.</p>
        <hr class="my-3">
        <p><a href="/login">Login</a> if you have an account or <a href="/register">Register</a> now and start tubing.</p>
    </div>

    <hr class="style1"/>

    <div class="push"></div>
</div>

<c:import url="partial/footer.jsp"/>

</body>
</html>