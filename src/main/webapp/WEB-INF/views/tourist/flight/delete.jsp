<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete</title>
    <jsp:include page="../../elements/head.jsp"/>
</head>
<body>
<jsp:include page="../../elements/header.jsp"/>
<main>
    <div class="container">
        <div class="row center">
            <form method="post" action="/tourist/flight/delete">
                <div>
                    <p>Are you sure, that you want to delete flight from choosed
                        tourist?</p>
                    <div class="input-field s6">
                        <select class="browser-default waves-effect waves-light btn"
                                required="required" name="delete" id="delete">=
                            <option value="" disabled="" selected="">Choose
                                option
                            </option>
                            <option value="yes">Yes, delete.</option>
                            <option value="no">No.</option>
                        </select>
                    </div>
                </div>
                <fieldset>
                    <button class="btn waves-effect waves-light" type="submit"
                            name="action">Submit
                        <i class="material-icons right">send</i>
                    </button>
                </fieldset>
            </form>
        </div>
    </div>
    </div>
</main>
<jsp:include page="../../elements/footer.jsp"/>
</body>
</html>
