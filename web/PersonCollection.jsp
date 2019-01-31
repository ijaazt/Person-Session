<%@ page import="person.*" %>
<%@ page import="person.PersonCollection" %><%--
  Created by IntelliJ IDEA.
  User: ijaaztello
  Date: 2019-01-27
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    PersonCollection collection = new PersonCollection();
    collection.update(pageContext);
    pageContext.getSession().setAttribute("personCollect",collection);
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Person Collection</title>
</head>
<body class="container">
<header>
    <h1>Person Collection</h1>
    <p>My person collection page. Feel free to add, edit, delete, and delete all of the people on this form.</p>
</header>
<form action="PersonCollection.jsp">

    <div class="row">
        <div class="form-group col-sm">
        <label for="firstName-add">First name</label>
        <input type="text" class="form-control" name="firstName" id="firstName-add">
    </div>
    <div class="form-group col-sm">
        <label for="lastName-add">Last name</label>
        <input type="text" class=form-control name="lastName" id="lastName-add">
    </div>
    </div>
    <div class="row">
        <div class="form-group col-sm">
            <label for="eyeColor-add">Eye color</label>
            <input type="text" class=form-control name="eyeColor" id="eyeColor-add">
        </div>
        <div class="form-group col-sm">
            <label for="hairColor-add">Hair color</label>
            <input type="text" class=form-control name="hairColor" id="hairColor-add">
        </div>
    </div>

    <div class="row">
        <div class="form-group col-sm">
            <label for="height-add">Height</label>
            <input type="text" class=form-control name="height" id="height-add">
        </div>
        <div class="form-group col-sm">
            <label for="weight-add">Weight</label>
            <input type="text" class=form-control name="weight" id="weight-add">
        </div>
    </div>

    <input type="submit" class="btn btn-secondary" name="submit" value="add">
</form>

<table class="table table-responsive">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Eye color</th>
        <th>Hair color</th>
        <th>Height</th>
        <th>Weight</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${sessionScope.personCollect}" var="person">
        <tr>
            <form action="PersonCollection.jsp">
                <td><input type="text" name="firstName" value="${person.name.firstName}"></td>
                <td> <input type="text" name="lastName" value="${person.name.lastName}"></td>
                <td><input type="text" name="eyeColor" value="${person.eyeColor}"></td>
                <td> <input type="text" name="hairColor" value="${person.hairColor}"></td>
                <td><input type="text" name="height" value="${person.height}"></td>
                <td><input type="text" name="weight" value="${person.weight}"></td>
                <td><input type="submit" name="submit" class="btn btn-secondary" value="edit"></td>
                <td><input type="submit" class="btn btn-secondary" name="submit" value="delete"></td>
                <input type="hidden" name="hashCode" value="${person.hashCode}"/>
            </form>
        </tr>
    </c:forEach>
</table>
<form action="PersonCollection.jsp">
    <button value="deleteAll" type=submit class="btn btn-primary" name="submit">Delete all</button>
</form>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>
