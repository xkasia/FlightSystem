<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 10.02.2019
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Flights</title>
    <jsp:include page="../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../elements/menu.jsp"/>
<div class="container">
    <div class="row center"><h4>All Flights</h4>
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
                    <td><a href="/flight/manage/${flight.id}">More.</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </br>
        <td><a href="/flight/add">Add new flight.</a>
            <h6 style="color:limegreen;">${addFlightSuccessMsg}</h6>
            <h6 style="color:limegreen;">${deleteFlightSuccessMsg}</h6>
    </div>
</div>
</body>
</html>