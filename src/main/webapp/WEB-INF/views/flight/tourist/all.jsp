<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 10.02.2019
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Tourist</title>
    <jsp:include page="../../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../../elements/menu.jsp"/>
<div class="container">
    <div class="row center"><h5>All Tourists:</h5>
        <table>
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
            <c:forEach items="${tourists}" var="tourist" varStatus="status">
                <tr>
                    <td>${status.index + 1}.</td>
                    <td>${tourist.firstName}</td>
                    <td>${tourist.lastName}</td>
                    <td>${tourist.country}</td>
                    <td>${tourist.birthDate}</td>

                    <c:choose>
                        <c:when test = "${isAlreadyBooked.get(tourist.id) == true}">
                            <td>Already booked.</td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="/flight/tourist/add/${tourist.id}">Add.</a></td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
