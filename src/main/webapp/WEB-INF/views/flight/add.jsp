<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 10.02.2019
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add</title>
    <jsp:include page="../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../elements/menu.jsp"/>
<div class="container">
    <div class="row center">
        <h5>Please fill in this form to create a new flight.</h5>
        <f:form modelAttribute="flight" method="post" action="/flight/add">
            Departure time:* <input type="datetime-local" name="departureTime" required = required> </br>
            Arrival time:* <input type="datetime-local" name="arrivalTime" required = required> </br>
            <p>Amount of seats:*<f:input path="amountOfSeats" type="number" min="0"/>
                <f:errors path="amountOfSeats"/> </p>
            <p>Ticket price:*<f:input path="ticketPrice" type="number" step="0.01" min="0"/>
                <f:errors path="ticketPrice"/> </p>
            <p><input type="submit" value="Create"/></p> </f:form>
    </div>
</div>
</body>
</html>