<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Tourist</title>
    <jsp:include page="../../elements/head.jsp"/>
</head>
<body>
<jsp:include page="../../elements/header.jsp"/>
<main>
    <div class="container">
        <div class="row center"><h5>All Tourists:</h5>
            <table class="striped">
                <thead>
                <tr>
                    <th>Lp.</th>
                    <th>First name</th>
                    <th>Last Name</th>
                    <th>Gender</th>
                    <th>Country</th>
                    <th>Birth date</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${tourists}" var="tourist" varStatus="status">
                    <tr>
                        <td>${status.index + 1}.</td>
                        <td>${tourist.firstName}</td>
                        <td>${tourist.lastName}</td>
                        <c:choose>
                            <c:when test = "${tourist.isMale().equals(true)}">
                                <td>Male</td>
                            </c:when>
                            <c:otherwise>
                                <td>Female</td>
                            </c:otherwise>
                        </c:choose>
                        <td>${tourist.country}</td>
                        <td>${tourist.birthDate}</td>
                        <c:choose>
                            <c:when test="${isAlreadyBooked.get(tourist.id) == true}">
                                <td><a class="btn disabled">Booked</a></td>
                            </c:when>
                            <c:otherwise>
                                <td><a href="/flight/tourist/add/${tourist.id}">
                                    <button class="btn waves-effect waves-teal">
                                        Add
                                    </button>
                                </a></td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <p align="right">
                <a class="btn waves-effect waves-teal"
                   href="/flight/manage/${flight.id}">Back</a></td>
            </p>
        </div>
    </div>
</main>
<jsp:include page="../../elements/footer.jsp"/>
</body>
</html>
