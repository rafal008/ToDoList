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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Registration</title>
    <style>
        #main{
            text-align: center;
            color:white;
            width:100%;
            height:400px;
            margin-top: 82px;

            background-color:#222;     /*#330033;*/
            opacity:0.5;

        }
    </style>
</head>
<body>

<div id="main">
    <p>ToDoList App <a href="/reg_form">register </a> </p>

</div>

</body>
</html>