<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 08.02.2019
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tourist data</title>
    <jsp:include page="../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../elements/menu.jsp"/>

<div class="container">

    <div class="row center"><h4>Tourist data:</h4>
        First name: ${tourist.firstName}</br>
        Last Name: ${tourist.lastName}</br>
        Country: ${tourist.country}</br>
        Birth date: ${tourist.birthDate}</br>
        Notes: ${tourist.note}</br>
        </br>
        <a href="/tourist/delete">Delete from Database.</a>

        <h4>Flights:</h4>
        <table>
            <thead>
            <tr>
                <th>Lp.</th>
                <th>Departure time</th>
                <th>Arrival time</th>
                <th>Amount of places</th>
                <th>Ticket price</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tourist.flightsList}" var="flight" varStatus="status">
                <tr>
                    <td>${status.index + 1}.</td>
                    <td>${flight.departureTime}</td>
                    <td>${flight.arrivalTime}</td>
                    <td>${flight.amountOfSeats}</td>
                    <td>${flight.ticketPrice}</td>
                    <td><a href="/tourist/flight/delete/${flight.id}">Delete.</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br/>
        <a href="/tourist/flight/all">Add new flight.</a>
        <h6 style="color:limegreen;">${deleteFlightFromTouristSuccessMsg}</h6>
        <h6 style="color:limegreen;">${addFlightToTouristSuccessMsg}</h6>
    </div>
</div>
</body>
</html>

