<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Todo || Dashboard</title>
    <style>
        body{
            background-color: lightgray;


        }
        .todo_form{
            width: 600px;
            height:805px;
            background-color: lightgray;
            text-align: center;
            margin-top: 100px;
            margin-left: 100px;



        }
        #textarea{
            width:530px;
            height:100px;

        }
    </style>
</head>
<body>
<div>

    <jsp:include page="menu.jsp"/>

</div>
<div class="todo_form">

    <div class="heading"><p><h3>New ToDo</h3></div>
    <s:url var="url_add_task" value="/saveTask"/>
    <f:form action="${url_add_task}" modelAttribute="command">



        <div class="title">
            <p><h3>Give a Title</h3></p>
            <f:input path="title" placeholder="give a title" id="title"/>
        </div>
        </br>
        </br>

        <div class="textarea">
            <p><h3>Give a Description</h3></p>
            <f:textarea path="description" placeholder="Add Description" id="textarea"/>
        </div>
        </br>
        </br>
        <table cellspacing="5" cellpadding="3" class="table">

            <tr>
                <th>DAY</th>
                <th>MONTH</th>
                <th>YEAR</th>
            </tr>

            <tr>

                <td >
                    <f:input path="day" placeholder="day" id="tdtd" />
                </td>
                <td>
                    <f:input path="month" placeholder="month" id="tdtd"/>
                </td>

                <td>
                    <f:input path="year" placeholder="year" id="tdtd"/>
                </td>

            </tr>

        </table>
        <div >
            <p><h3>Done?</h3></p>
            <f:select path="done">
                <f:option value="No" />
                <f:option value="Yes" />

            </f:select>

        </div>
        </br>
        </br>
        <div >
            <p><h3>Select The Priority of Your Task</h3></p>
        </div>
        <div >
            <f:radiobutton path="priority" value="a" id="high"/>
            <label for="high">High</label>
            <f:radiobutton path="priority" value="b" id="medium"/>
            <label for="medium">Medium</label>
            <f:radiobutton path="priority" value="c" id="low"/>
            <label for="low">Low</label>
        </div>

      </br>
       </br>
        <div >
            <f:button id="button">SAVE</f:button>
        </div>

    </f:form>



</div>


</body>
</html>