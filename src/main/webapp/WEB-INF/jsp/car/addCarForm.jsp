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
            <form action="/cars" method="post">
                <label>Brand</label></br>
                <input type="text"name="brand"></br>
                <label>Model</label></br>
                <input type="text"name="model"></br>
                <label>Year</label></br>
                <input type="text"name="year"></br>
                <label>Color</label></br>
                <input type="text"name="color"></br>
                <label>Mileage</label></br>
                <input type="text"name="mileage"></br>
                <label>VIN number</label></br>
                <input type="text"name="vinNumber"></br>
                <label>Price per day</label></br>
                <input type="text"name="price"></br></br>
                <input type="submit" class="button" value="add car"></br></br>

            </form>
        </div>
    </div>
    <div style="clear:both;"></div>

</div>

</body>
</html>