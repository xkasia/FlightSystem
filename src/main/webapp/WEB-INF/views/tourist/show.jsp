<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 08.02.2019
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Users</title>
    <jsp:include page="../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../elements/menu.jsp"/>
<div class="container">
    <div class="row center"><h2>All Tourists</h2>
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
            <c:forEach items="${tourist}" var="tourist" varStatus="status">
                <tr>
                    <td>${status.index + 1}.</td>
                    <td>${tourist.firstName}</td>
                    <td>${tourist.lastName}</td>
                    <td>${tourist.country}</td>
                    <td>${tourist.birthDate}</td>
                    <td><a href="/tourist/manage/${tourist.id}">More.</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </br>
        <td><a href="/tourist/add">Add new tourist.</a>
    </div>
</div>
</body>
</html>
