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
            position: fixed;
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
            float:left;
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
            background-color:#4b0d2b;
            color:black;
        }
        #link{
            margin-left:710px;
        }
    </style>
</head>

<body>

<s:url var="url_reg_form" value="/reg_form"/>
<a href="${url_reg_form}" id="link1">REGISTRATION</a>
</body>

</html>