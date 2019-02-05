<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="partial/head.jsp"/>
</head>
<body>
<div class="wrapper">

    <h2 class="center">All Tubes</h2>
    <hr class="style1"/>
    <p class="center medium">Check our tubes bellow</p>
    <hr class="style1"/>

    <div class="center">

        <ul>

        <% List<String> titles = (List<String>)request.getAttribute("tubes");

            if(titles.size() == 0){
                out.println("No tubes – <a href=\"/tubes/create\">Create some!</a>");
            }

            for (String title: titles) {

                out.println("<li><a href=\"/tubes/details?title=" + title + "\">" + title + " </a></li><br/>");
            }
        %>

        </ul>

    </div>


    <hr class="style1"/>

    <div class="center distance">
        <a href="/">Back to home page</a>
    </div>

    <div class="push"></div>
</div>
<c:import url="partial/footer.jsp"/>
</body>
</html>