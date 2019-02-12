<html>
<head>
    <title>About system</title>
    <jsp:include page="elements/head.jsp"/>
</head>
<body>
<jsp:include page="elements/header.jsp"/>
<main>
    <div class="container">
        <div class="row center">
            <div class="about">
                <h4>About system</h4>
                This is application for managing space tourist flights.
                <br/><br/>
                <p>
                <h6>Flights management section provides functionalities as:</h6>

                <li>getting the list of tourists</li>
                <li>adding a tourist</li>
                <li>removing a tourist</li>
                <li>editing a tourist:adding a flight to tourist, removing a
                    flight
                    from tourist
                </li>

                </p>
                <p>
                <h6>Tourists management section provides functionalities
                    as:</h6>
                <li>getting the list of flights</li>
                <li>adding a flight</li>
                <li>removing a flight</li>
                <li>editing a flight: adding a tourist to the flight, removing
                    of a
                    tourist from the flight
                </li>
                </p>
            </div>
        </div>
    </div>
</main>
<jsp:include page="elements/footer.jsp"/>
</body>
</html>
