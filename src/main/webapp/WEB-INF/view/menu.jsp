<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        body{
            margin: 0px;
            border: 0px;
        }
        #navbar{
            width:100%;
            height: 65px;
            position: fixed ;
            top: 0;
            background-color: black;
            position: fixed;
            display: block;
            text-align: center;
            opacity: 0.8;
        }
        #link1{
            color: white;
            text-decoration: none;
            padding: 15px;
            vertical-align: central;
            padding-right: 80px;
        }
        #link1:hover{
            color: green;
        }
        .navbar2{
            width:100%;
            height: 65px;
            position: fixed ;
            top: 0;
            background-color: black;

            display: block;
            text-align: center;
            opacity: 0.8;
        }
        .navbar2 ul{
            margin:0px;
            padding:0px;
            list-style: none;
        }
        .navbar2 ul li{
            float: left;
            width:180px;
            height:40px;
        }
        .navbar2 ul li a{
            text-decoration: none;
            display:block;
            color:white;
        }
        .navbar2 ul li a:hover{
            color:green;
        }
        .navbar2 ul li ul li{
            display:none;
        }
        .navbar2 ul li:hover ul li{
            display:block;
            background-color:grey;
            color:black;
        }
        #link{
            margin-left:710px;
        }
    </style>
</head>
<body>
<center>
    <c:if test="${sessionScope.userId ==null}">
        <div id="navbar">

            <s:url var="url_reg_form" value="/regform"/>
            <a href="${url_reg_form}" id="link1">REGISTRATION</a>

            <s:url var="url_login_form" value="/loginform"/>
            <a href="${url_login_form}" id="link1">LOGIN</a>

        </div>
    </c:if>
    <c:if test="${sessionScope.userId !=null}">
        <div class="navbar2">
            <ul>
                <s:url var="url_addTask" value="/addTask"/>
                <li> <a href="${url_addTask}">ADD NEW TASK</a></li>
                <s:url var="url_search" value="/todolist"/>
                <li><a href="${url_search}">MY TASKS</a>
                    <ul>
                        <li>
                            <s:url var="url_priority" value="/priority"/>
                            <a href="${url_priority}">ORDER BY PRIORITY</a>
                        </li>
                        <li>
                            <s:url var="url_by_time" value="/time"/>
                            <a href="${url_by_time}">ORDER BY TIME</a>
                        </li>
                        <li>
                            <s:url var="url_by_done" value="/not_done"/>
                            <a href="${url_by_done}">SHOW NOT DONE</a>
                        </li>
                        <li>
                            <s:url var="url_by_time1" value="/after_time"/>
                            <a href="${url_by_time1}">SHOW AFTER TIME</a>
                        </li>


                    </ul>

                </li>

                <s:url var="url_logout" value="/logout"/>
                <li><a href="${url_logout}" id="link">LOGOUT</a></li>

            </ul>
        </div>
    </c:if>
</center>

</body>
</html>