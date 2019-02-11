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
            <p>Departure time:*<f:input path="departureTime" type="datetime-local"/>
                <f:errors path="departureTime"/> </p>
            <p>Arrival time:*<f:input path="arrivalTime" type="datetime-local"/>
                <f:errors path="arrivalTime"/> </p>
            <p>Amount of seats:*<f:input path="amountOfSeats" type="number"/>
                <f:errors path="amountOfSeats"/> </p>
            <p>Ticket price:*<f:input path="ticketPrice" type="number" step="0.01"/>
                <f:errors path="ticketPrice"/> </p>
            <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                <i class="material-icons right">send</i>
            </button>
            </f:form>
        <h6 style="color:red;">${wrongDataMsg}</h6>
    </div>
</div>
</body>
</html>