<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Tourists</title>
    <jsp:include page="../elements/head.jsp"/>
</head>
<body>
<jsp:include page="../elements/header.jsp"/>
<main>
    <div class="container">
        <div class="row center"><h4>All Tourists</h4>
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
                        <td><a class="waves-effect waves-light btn-small"
                               href="/tourist/manage/${tourist.id}">More</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </br>
            <td><a href="/tourist/add">
                <button class="btn waves-effect waves-teal">
                    <i class="material-icons left">add</i>Add
                </button>
            </a></td>
            <h6 class="success">${addTouristSuccessMsg}</h6>
            <h6 class="success">${deleteTouristSuccessMsg}</h6>
        </div>
    </div>
</main>
<jsp:include page="../elements/footer.jsp"/>
</body>
</html>
