<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>

<div>
    <jsp:include page="main.jsp"/>
</div>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Registration</title>
    <style>
    body
    {
    background-color: #303030;  /* jasnoszary */
    color: #ffffff;    /*biały*/
    font-family: 'Lato', sans-serif;
    font-size: 20px;



    }
    .simple_form{
    text-align: center;
    margin-top: 100px;
    margin-left: 5px;

    }
    </style>
</head>
<body>

<div class="simple_form">
    <s:url var="url_log_form" value="/logUser"/>
    <f:form action="${url_log_form}" modelAttribute="command" >
        <h1  style="color:red;">Login</h1>

        <f:input path="login" placeholder="Enter your name" />

        </br>
        </br>

        <f:password path="password" placeholder="Enter your password" />
        </br>
        </br>
        </br>
        <f:button id="butt">Login</f:button>
        <s:url var="url_registrationform" value="/reg_form"/>

    </f:form>

</div>


</body>
</html>