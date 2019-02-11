<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 10.02.2019
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete</title>
    <jsp:include page="../../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../../elements/menu.jsp"/>
<div>
    <form method="post" action="/flight/tourist/delete">
        <div>
            <p>Are you sure, that you want to delete tourist from choosed flight?</p>
            <div class="input-field s6">
                <select class="browser-default waves-effect waves-light btn"
                        required="required" name="delete" id="delete">=
                    <option value="" disabled="" selected="">Choose option
                    </option>
                    <option value="yes">Yes, delete.</option>
                    <option value="no">No.</option>
                </select>
            </div>
        </div>
        <fieldset>
            <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                <i class="material-icons right">send</i>
            </button>
        </fieldset>
    </form>
</div>
</div>
</body>
</html>

