<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 10.02.2019
  Time: 14:55
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
        <h5>Please fill in this form to create a new tourist account.</h5>
        <f:form modelAttribute="tourist" method="post" action="/tourist/add">
            <p>First name:*<f:input path="firstName" type="text"/>
                <f:errors path="firstName"/> </p>
            <p>Last name:*<f:input path="lastName" type="text"/>
                <f:errors path="lastName"/> </p>
            <p>Country:* <f:input path="country" type="text"/>
                <f:errors path="country"/> </p>
            <p>Notes:* <f:input path="note" type="text"/>
                <f:errors path="note"/> </p>
            Birth date:* <input type="date" name="birthDate" required = required> </br>
            <p><input type="submit" value="Create"/></p> </f:form>
    </div>
</div>
</body>
</html>