<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add</title>
    <jsp:include page="../elements/head.jsp"/>
</head>
<body>
<jsp:include page="../elements/header.jsp"/>
<main>
    <div class="container">
        <div class="row center">
            <h5>Please fill in this form to create a new flight.</h5>
            <f:form modelAttribute="flight" method="post" action="/flight/add">
                <p>Departure time:*<f:input path="departureTime"
                                            type="datetime-local"/>
                    <f:errors path="departureTime"/></p>
                <p>Arrival time:*<f:input path="arrivalTime"
                                          type="datetime-local"/>
                    <f:errors path="arrivalTime"/></p>
                <p>Amount of seats:*<f:input path="amountOfSeats"
                                             type="number" placeholder="Amount of seats"/>
                    <f:errors path="amountOfSeats"/></p>
                <p>Ticket price:*<f:input path="ticketPrice" type="number"
                                          step="0.01" placeholder="Ticket price"/>
                    <f:errors path="ticketPrice"/></p>
                <button class="btn waves-effect waves-light" type="submit"
                        name="action">Submit
                    <i class="material-icons right">send</i>
                </button>
            </f:form>
            <h6 class="failure">${wrongDataMsg}</h6>
        </div>
    </div>
</main>
<jsp:include page="../elements/footer.jsp"/>
</body>
</html>