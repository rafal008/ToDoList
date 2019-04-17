

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<div>
    <jsp:include page="menu.jsp"/>
</div>
<head>
    <link href="static/css/registration.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="simple_form">
    <s:url var="url_reg_form" value="/registerUser"/>
    <f:form action="${url_reg_form}" modelAttribute="command" >
        <h1  style="color:red;">Registration</h1>
        <f:input path="u.name" placeholder="Enter your name" />

        </br>
        </br>
        </br>
        <f:input path="u.surname" placeholder="Enter your surname" />
        </br>
        </br>
        </br>

        <f:input path="u.phone" placeholder="Enter your phone number" />
        </br>
        </br>
        </br>
        <f:input path="u.login" placeholder="Enter your user name" />
        </br>
        </br>
        </br>
        <f:password path="u.password" placeholder="Enter your password" />
        </br>
        </br>
        </br>
        <f:button id="butt">Register</f:button>
    </f:form>
</div>

    </body>

</html>