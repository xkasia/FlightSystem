<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tourist data</title>
    <jsp:include page="../elements/head.jsp"/>
</head>
<body>
<jsp:include page="../elements/header.jsp"/>
<main>
    <div class="container">
        <div class="row center"><h4>Tourist data:</h4>
            <div class="info">
                First name: ${tourist.firstName}</br>
                Last Name: ${tourist.lastName}</br>
                <c:choose>
                    <c:when test = "${tourist.isMale().equals(true)}">
                        Gender: Male</br>
                    </c:when>
                    <c:otherwise>
                        Gender: Female</br>
                    </c:otherwise>
                </c:choose>
                Gender: ${tourist.lastName}</br>
                Country: ${tourist.country}</br>
                Birth date: ${tourist.birthDate}</br>
                Notes: ${tourist.note}</br>
            </div>
            </br>
            <td><a class="btn waves-effect waves-light red lighten-2 btn-small"
                   href="/tourist/delete">Delete Tourist</a></td>

            <h4>Flights:</h4>
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
                <c:forEach items="${tourist.flightsList}" var="flight"
                           varStatus="status">
                    <tr>
                        <td>${status.index + 1}.</td>
                        <td>${flight.departureTime}</td>
                        <td>${flight.arrivalTime}</td>
                        <td>${flight.amountOfSeats}</td>
                        <td>${flight.ticketPrice}</td>
                        <td>
                            <a class="btn waves-effect waves-light red lighten-2 btn-small"
                               href="/tourist/flight/delete/${flight.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br/>
            <td><a href="/tourist/flight/all">
                <button class="btn waves-effect waves-teal">
                    <i class="material-icons left">add</i>Add
                </button>
            </a></td>
            <h6 class="success">${deleteFlightFromTouristSuccessMsg}</h6>
            <h6 class="success">${addFlightToTouristSuccessMsg}</h6>
            <p align="right">
                <a class="btn waves-effect waves-teal"
                   href="/tourist/show">Back</a></td>
            </p>
        </div>
    </div>
</main>
<jsp:include page="../elements/footer.jsp"/>
</body>
</html>

