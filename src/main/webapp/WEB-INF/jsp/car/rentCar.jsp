<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../style.css">
    <title>bestCars</title>
    <style>
        th, td {
            border: 1px solid white;
            padding: 10px;
        }
        tr:nth-child(even)
        {background-color: rgba(53, 52, 51, 0.664)}
        tr:nth-child(odd)
        {background-color: rgba(26, 25, 24, 0.719)}
        table {
            border-collapse: collapse;
            margin-left: auto;
            margin-right: auto;
            font-family: "EngraversGothic BT";
            color: yellow;

        }
        .xxx th {
            background-color:rgba(235, 202, 15, 0.904);
            color: white;
        }

    </style>
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
            <table class="xxx">
                <tr>
                    <th>BRAND</th>
                    <th>MODEL</th>
                    <th>YEAR</th>
                    <th>COLOR</th>
                    <th>MILEAGE</th>
                    <th>CAR STATUS</th>
                    <th>PRICE</th>
                    <th></th>
                </tr>
                <c:forEach var="car" items="${allMyCars}">
                    <tr>
                        <td> ${car.brand}</td>
                        <td> ${car.model}</td>
                        <td>${car.year}</td>
                        <td> ${car.color}</td>
                        <td> ${car.mileage} km</td>
                        <td> ${car.carStatus}</td>
                        <td>${car.price} $</td>
                        <td><a href="/reservation?carId=${car.id}"><button class="button">rent this car</button></a></td>
                    </tr>

                </c:forEach>
            </table>
        </div>
    </div>
    <div style="clear:both;"></div>

</div>

</body>
</html>