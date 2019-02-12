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
            <h5>Please fill in this form to create a new tourist account.</h5>
            <f:form modelAttribute="tourist" method="post"
                    action="/tourist/add">
            <p>First name:*<f:input path="firstName" type="text"
                                    placeholder="First name"/>
                <f:errors path="firstName"/></p>
            <p>Last name:*<f:input path="lastName" type="text"
                                   placeholder="Last name"/>
                <f:errors path="lastName"/></p>
            <p>Please choose gender:</p>
            <div class="input-field s6">
                <select class="browser-default waves-effect waves-light btn"
                        name="gender" id="gender"  <f:input path="gender"/>  <f:errors path="gender"/>>
                    <option value="" disabled="" selected="">Choose option
                    </option>
                    <option value="yes">Male</option>
                    <option value="no">Female</option>
                </select>
            </div>
            <p>Country:* <f:input path="country" type="text"
                                  placeholder="Country"/>
                <f:errors path="country"/></p>
            <p>Notes: <f:input path="note" type="text" placeholder="Notes"/>
                <f:errors path="note"/></p>
            <p>Birth date:* <f:input path="birthDate" type="date"/>
                <f:errors path="birthDate"/></p>
            <button class="btn waves-effect waves-light" type="submit"
                    name="action">Submit
                <i class="material-icons right">send</i>
            </button>
            </f:form>
            <div>
            </div>
</main>
<jsp:include page="../elements/footer.jsp"/>
</body>
</html>