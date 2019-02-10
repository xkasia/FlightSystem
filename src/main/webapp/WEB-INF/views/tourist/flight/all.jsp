<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 09.02.2019
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Flights</title>
    <jsp:include page="../../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../../elements/menu.jsp"/>
<div class="container">
    <div class="row center"><h2>All Available Flights:</h2>
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
            <c:forEach items="${flights}" var="flight" varStatus="status">
                <tr>
                    <td>${status.index + 1}.</td>
                    <td>${flight.departureTime}</td>
                    <td>${flight.arrivalTime}</td>
                    <td>${flight.amountOfSeats}</td>
                    <td>${flight.ticketPrice}</td>

                    <c:choose>
                        <c:when test = "${isAlreadyBooked.get(flight.id) == true}">
                            <td>Already booked.</td>
                        </c:when>
                        <c:when test = "${hasFreePlace.get(flight.id) == true}">
                            <td><a href="/tourist/flight/add/${flight.id}">Add.</a></td>
                        </c:when>
                        <c:otherwise>
                            <td>No available seats.</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>