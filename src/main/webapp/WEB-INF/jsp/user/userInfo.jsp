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
        <div id="tile2">
            <c:if test="${addedUser==true}">
                <br/><h2>Registration successful! </h2>
            </c:if>
            <c:if test="${buyCarResult == true}">
                <h2>Congratulation You,ve successfully bought a nice ${boughtCar} </h2><br/>
                <a href="/cars/listofbought/">List of Your Cars</a><br/><br/>
            </c:if>
        </div>
    </div>
    <div style="clear:both;"></div>

</div>

</body>
</html>