<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="partial/head.jsp"/>
</head>
<body>

<div class="wrapper">

    <h1>Welcome to MeTube!</h1>
    <hr class="style1">
    <h2 class="center distance">Cool app in beta version</h2>
    <hr class="style1 distance">
    <div>
        <p class="left distance"><a class="button" href="/tubes/create">Create Tube</a></p>
        <p class="right distance"><a class="button" href="/tubes/all">All Tubes</a></p>
    </div>

    <div class="push"></div>
</div>

<c:import url="partial/footer.jsp"/>

</body>
</html>