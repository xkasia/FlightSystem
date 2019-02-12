<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Flights</title>
    <jsp:include page="../elements/head.jsp"/>
</head>
<body>
<jsp:include page="../elements/header.jsp"/>
<main>
    <div class="container">
        <div class="row center"><h4>All Flights</h4>
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
                        <td><a class="waves-effect waves-light btn-small"
                               href="/flight/manage/${flight.id}">More</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </br>
            <td><a href="/flight/add">
                <button class="btn waves-effect waves-teal">
                    <i class="material-icons left">add</i>Add
                </button>
            </a></td>
            <h6 class="success">${addFlightSuccessMsg}</h6>
            <h6 class="success">${deleteFlightSuccessMsg}</h6>
        </div>
    </div>
</main>
<jsp:include page="../elements/footer.jsp"/>
</body>
</html>