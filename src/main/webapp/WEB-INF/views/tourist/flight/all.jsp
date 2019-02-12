<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Flights</title>
    <jsp:include page="../../elements/head.jsp"/>
</head>
<body>
<jsp:include page="../../elements/header.jsp"/>
<main>
    <div class="container">
        <div class="row center"><h5>All Flights:</h5>
            <table class="striped">
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
                            <c:when test="${isAlreadyBooked.get(flight.id) == true}">
                                <td><a class="btn disabled">Booked</a></td>
                            </c:when>
                            <c:when test="${hasFreePlace.get(flight.id) == true}">
                                <td><a href="/tourist/flight/add/${flight.id}">
                                    <button class="btn waves-effect waves-teal">
                                        Add
                                    </button>
                                </a></td>
                            </c:when>
                            <c:otherwise>
                                <td><a class="btn disabled">No seats</a></td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <p align="right">
                <a class="btn waves-effect waves-teal"
                   href="/tourist/manage/${tourist.id}">Back</a></td>
            </p>
        </div>
    </div>
</main>
<jsp:include page="../../elements/footer.jsp"/>
</body>
</html>