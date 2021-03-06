<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<title>Register</title>
<c:import url="partial/head.jsp"/>

<body>

<div class="wrapper">

    <c:import url="partial/navbar.jsp"/>

    <h1>Register</h1>

    <hr class="my-2">
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="form-holder text-center">
                <form class="form-inline" action="/register" method="POST">
                    <fieldset>
                        <div class="control-group">
                            <label class="control-label h3 mb-2" for="username">Username</label>
                            <div class="controls">
                                <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
                            </div>
                        </div>
                        <br/>
                        <div class="control-group">
                            <label class="control-label h3 mb-2" for="password">Password</label>
                            <div class="controls">
                                <input type="password" id="password" name="password" placeholder=""
                                       class="input-xlarge">
                            </div>
                        </div>
                        <br/>
                        <div class="control-group">
                            <label class="control-label h3 mb-2" for="confirmPassword">Confirm Password</label>
                            <div class="controls">
                                <input type="password" id="confirmPassword" name="confirmPassword" placeholder=""
                                       class="input-xlarge">
                            </div>
                        </div>
                        <br/>
                        <div class="control-group">
                            <label class="control-label h3 mb-2" for="email">Email</label>
                            <div class="controls">
                                <input type="text" id="email" name="email" placeholder=""
                                       class="input-xlarge">
                            </div>
                        </div>
                        <br/>
                        <div class="control-group">
                            <div class="controls">
                                <button class="btn btn-info">Register</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

    <hr class="style1"/>

    <div class="push"></div>
</div>

<c:import url="partial/footer.jsp"/>

</body>
</html>