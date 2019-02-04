<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="partial/head.jsp"/>
</head>
<body>
<div class="wrapper">

    <h2 class="center">Create Tube!</h2>
    <hr class="style1"/>
    <div class="center">

        <%! String message; %>
        <% message = (String)request.getAttribute("msg");
           if (message != null){
               out.print("<p class=\"warning\">" + message +"</p>");
        }%>

        <form action="/tubes/create" method="post">

            <div>
                <div class="center"><label for="title">Title:</label></div>
                <input type="text" minlength="3" maxlength="30" id="title" name="title" requred>
            </div>

            <div>
                <div class="center"><label for="description">Description:</label></div>
                <textarea id="description" name="description" placeholder="Enter description" cols="30" rows="4" required></textarea>
            </div>

            <div>
                <div class="center"><label for="link">YouTubeLink:</label></div>
                <input type="text" minlength="28" maxlength="100" id="link" name="link" required>
            </div>

            <div>
                <div class="center"><label for="uploader">Uploader:</label></div>
                <input type="text" minlength="2" maxlength="100" id="uploader" name="uploader" required>
            </div>

            <div class="center">
                <input class="button" type="submit"  value="Create Tube">
            </div>
        </form>
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