<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Cars</title>
    <style>
        h3{
         text-align: center;
        }

        th, td {
            border: 1px solid black;
            padding: 10px;
        }
        tr:nth-child(even)
        {background-color: gainsboro}
        table {
            border-collapse: collapse;
            margin-left: auto;
            margin-right: auto;

        }
        .xxx th {
            background-color: firebrick;
            color: white;
        }
        .container{
            width: 70%;
            margin: auto;
        }

    </style>
</head>
<body>
<h3>a list of the cars You,ve already bought:</h3>
<div class="container">
    <table class="xxx">
        <tr>
            <th>BRAND</th>
            <th>MODEL</th>
            <th>YEAR</th>
            <th>COLOR</th>
            <th>MILEAGE</th>
            <th>VIN NUMBER</th>
            <th>PRICE</th>
        </tr>
        <c:forEach var="car" items="${listOfBought}">
            <tr>
                <td> ${car.brand}</td>
                <td> ${car.model}</td>
                <td>${car.year}</td>
                <td> ${car.color}</td>
                <td> ${car.mileage}</td>
                <td> ${car.vinNumber}</td>
                <td>${car.price}</td>

            </tr>

        </c:forEach>
    </table>
</div>
</body>
</html>
