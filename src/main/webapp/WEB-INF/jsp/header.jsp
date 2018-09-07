<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Movie Notifier Service</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <style>
        .error {
            color: red
        }

        .table td.fit,
        .table th.fit {
            white-space: nowrap;
            width: 1%;
        }

        .pagesTable {
            table-layout: auto;
            width: 200px;
        }

        .center {
            margin: auto;
            padding: 5px;
        }

        .mytext {
            word-break:break-word;
        }
        .row {
            margin: 5px;
        }

        .panel-default{
            text-align: center;
        }


    </style>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid" style="display: inline-flex">

        <ul class="nav navbar-nav">
            <li class="active"><a href="/home"> Movie Notifier Service </a></li>
        </ul>

        <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/adminTools"> Administration tools </a></li>
            </ul>
        </c:if>

        <c:if test="${pageContext.request.isUserInRole('USER')}">
            <form method="get" action="/user/search">

                <ul class="nav navbar-nav">

                    <li class="active">
                        <a><input type="text" name="query" placeholder="Enter Film Name" class="form-control"></a>
                    </li>
                </ul>

                <ul class="nav navbar-nav">
                    <li class="active">
                        <a><input type="number" step="1" min="1980" max="3000" name="year" placeholder="Enter Year"
                                  class="form-control"></a>
                    </li>
                </ul>
                <ul class="nav navbar-nav">
                    <li>
                        <a><input type="submit" value="Find" class="btn btn-primary"></a>
                    </li>
                </ul>
            </form>
        </c:if>

        <div style=" position:absolute; right: 0px;">
            <c:choose>
                <c:when test="${not empty pageContext.request.userPrincipal}">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/userInfo">You signed in as: <c:out
                                value="${pageContext.request.userPrincipal.name}"/></a></li>
                        <li class="active"><a href="/logout">Sign out</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/login"> Sign in </a></li>
                        <li class="active"><a href="/register"> Register </a></li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>