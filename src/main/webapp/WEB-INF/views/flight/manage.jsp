<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Flight data</title>
    <jsp:include page="../elements/head.jsp"/>
</head>
<body>
<jsp:include page="../elements/header.jsp"/>
<main>
    <div class="container">
        <div class="row center"><h4>Flight data:</h4>
            <div class="info">
            Departure time: ${flight.departureTime}</br>
            Arrival time: ${flight.arrivalTime}</br>
            Amount of places: ${flight.amountOfSeats}</br>
            Ticket price: ${flight.ticketPrice}</br>
            </div>
            </br>
            <td><a class="btn waves-effect waves-light red lighten-2 btn-small"
                   href="/flight/delete">Delete Flight</a></td>
            <h4>Tourists:</h4>
            <table class="striped">
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
                <c:forEach items="${flight.touristList}" var="tourist"
                           varStatus="status">
                    <tr>
                        <td>${status.index + 1}.</td>
                        <td>${tourist.firstName}</td>
                        <td>${tourist.lastName}</td>
                        <td>${tourist.country}</td>
                        <td>${tourist.birthDate}</td>
                        <td>
                            <a class="btn waves-effect waves-light red lighten-2 btn-small"
                               href="/flight/tourist/delete/${tourist.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br/>
            <c:choose>
                <c:when test="${hasFreePlace == true}">
                    <td><a href="/flight/tourist/all">
                        <button class="btn waves-effect waves-teal">
                            <i class="material-icons left">add</i>Add
                        </button>
                    </a></td>
                </c:when>
                <c:otherwise>
                    <td><a class="btn disabled">Flight is full</a></td>
                </c:otherwise>
            </c:choose>
            <h6 class="success">${deleteTouristFromFlightSuccessMsg}</h6>
            <h6 class="success">${addTouristToFlightSuccessMsg}</h6>
            <p align="right">
                <a class="btn waves-effect waves-teal"
                   href="/flight/show">Back</a></td>
            </p>
        </div>
    </div>
</main>
<jsp:include page="../elements/footer.jsp"/>
</body>
</html>