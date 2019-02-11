<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 10.02.2019
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Flight data</title>
    <jsp:include page="../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../elements/menu.jsp"/>

<div class="container">

    <div class="row center"><h4>Flight data:</h4>
        Departure time: ${flight.departureTime}</br>
        Arrival time: ${flight.arrivalTime}</br>
        Amount of places: ${flight.amountOfSeats}</br>
        Ticket price: ${flight.ticketPrice}</br>

        </br>
        <a href="/flight/delete">Delete from Database.</a>

        <h4>Tourists:</h4>
        <table>
            <thead>
            <tr>
                <th>Lp.</th>
                <th>First name</th>
                <th>Last Name</th>
                <th>Country</th>
                <th>Birth date</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${flight.touristList}" var="tourist" varStatus="status">
                <tr>
                    <td>${status.index + 1}.</td>
                    <td>${tourist.firstName}</td>
                    <td>${tourist.lastName}</td>
                    <td>${tourist.country}</td>
                    <td>${tourist.birthDate}</td>
                    <td><a href="/flight/tourist/delete/${tourist.id}">Delete.</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br/>
        <c:choose>
            <c:when test = "${hasFreePlace == true}">
                <a href="/flight/tourist/all">Add new tourist.</a>
            </c:when>
            <c:otherwise>
                <td>Flight is full.</td>
            </c:otherwise>
        </c:choose>
        <h6 style="color:limegreen;">${deleteTouristFromFlightSuccessMsg}</h6>
        <h6 style="color:limegreen;">${addTouristToFlightSuccessMsg}</h6>
    </div>
</div>
</body>
</html>