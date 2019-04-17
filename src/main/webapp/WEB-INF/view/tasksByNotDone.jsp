<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User To do List</title>
    <style>
        body {
            font-family: 'Open Sans', sans-serif;
            font-weight: 300;
            line-height: 1.42em;
            color: black;
            background-color:lightgray;

        }
        h1,h2 {
            padding: 5px;
        }
        .container {

            width: 100%;
            display:table;


            padding: 0 0 8em 0;
            text-align: left;
        }
        .search{
            margin-top:10px;
            margin-left:259px;
            padding: 2px;
            font-size:20px;
        }
        .heading{

            height:40px;

            text-align: center;
            font-size: 30px;
            font-weight: bolder;
        }
        #textarea{
            width:100%;
            height:100px;

        }
        td
        {
            border:1px solid black;
            font-weight: 300;
            font-size: 20px;


        }
        #t
        {
            font-size: 15px;
        }
    </style>

</head>
<body>


<div>
    <jsp:include page="menu.jsp"/>
</div>
</br>
</br>

<div class="heading">
    <p><h2>ToDoList</h2></p>
</div>
<div class="search">
    Find task
    <form action="<s:url value="/search"/>">
        <input type="text" name="freetext" placeholder="search">
        <button>Find</button>
    </form>
</div>



<table class="container">
    <thead>
    <tr>
        <th><h1>Due Date</h1></th>

        <th><h1>Title</h1></th>
        <th><h1>Description</h1></th>
        <th><h1>Priority</h1></th>
        <th><h1>Done</h1></th>
        <th><h1>Action</h1></th>

    </tr>
    </thead>
    <tbody>

    <c:forEach var="t" items="${todolists}" varStatus = "status">
        <tr>


            <td>${t.day}/${t.month}/${t.year}</td>
            <td>${t.title}</td>

            <td><textarea name="" id="t" cols="30" rows="5" id="textarea">${t.description}</textarea></td>
            <c:if test="${t.priority == 'a'}">
                <td>High</td>
            </c:if>
            <c:if test="${t.priority == 'b'}">
                <td>Medium</td>
            </c:if>
            <c:if test="${t.priority == 'c'}">
                <td>Low</td>
            </c:if>
            <td>${t.done}</td>
            <s:url var="url_delete" value="/del_todo">
                <s:param name="toDoId" value="${t.toDoId}"/>
            </s:url>
            <s:url var="url_edit" value="/edit_todo">
                <s:param name="toDoId" value="${t.toDoId}"/>
            </s:url>


            <td><a href="${url_edit}" id="a1">Edit</a>| <a href="${url_delete}" id="a2">Delete</a></td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>