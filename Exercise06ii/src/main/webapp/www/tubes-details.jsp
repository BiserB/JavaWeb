<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="metube.models.view.TubeFullViewModel" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="partial/head.jsp"/>
</head>
<body>
<div class="wrapper">

    <%! TubeFullViewModel model;%>

    <% model = (TubeFullViewModel)request.getAttribute("model"); %>

    <h2 class="center"><%= model.getTitle() %></h2>

    <hr class="style1">
    <p class="center"><%= model.getDescription() %></p>

    <hr class="style1">
    <div>
        <p class="left"><a href="<%= model.getLink() %>"> Link to video</a>  </p>
        <p class="right"><%= model.getUploader() %></p>
    </div>

    <hr class="style1" style="margin: 30px 0; clear: both;">
    <div class="center distance">
        <a href="/">Back to home page</a>
    </div>

    <div class="push"></div>
</div>
<c:import url="partial/footer.jsp"/>
</body>
</html>