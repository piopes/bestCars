<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../style.css">
    <title>bestCars</title>
</head>
<body>
<div id="container">

    <div id="logo"><h1><i><span style="color: rgb(46, 46, 40)">B</span>est<span style="color: rgb(46, 46, 40)">C</span>ars</i></h1></div>

    <div id="square1">
        <div class="tile1" >
            <br/>
            <a href="/" class="menulink">Home</a><br/>
            <a href="/login"  class="menulink">Login</a><br/>
            <a href="/logout" class="menulink">Logout</a><br/>
            <a href="/users" class="menulink">Register</a><br/><br/><br/>
            <a href="/cars" class="menulink">Add new car</a><br/>
            <a href="/cars/delete" class="menulink">Delete car</a><br/>
            <a href="/cars/rent" class="menulink">Rent car</a><br/>
        </div>



    </div>

    <div id="square2">
        <div id="tile2"><br/>
            <c:if test="${errorMessage != null}">
                <h3 STYLE=" color: red">${errorMessage}</h3>
            </c:if>
            <form action="/users" method="post">
                <label>Name</label></br>
                <input type="text"name="name"></br>

                <label>Last name</label></br>
                <input type="text"name="lastName"></br>

                <label>Email</label></br>
                <input id="input" type="email"name="email"></br>

                <label>Password</label></br>
                <input type="password"name="password"></br>

                <label>City</label></br>
                <input type="text"name="city"></br>

                <label>Street</label></br>
                <input type="text"name="street"></br>

                <label>Number</label></br>
                <input type="text"name="number"></br></br>

                <input type="submit"class="button" value="Register"></br></br>

            </form>
        </div>
    </div>
    <div style="clear:both;"></div>

</div>

</body>
</html>