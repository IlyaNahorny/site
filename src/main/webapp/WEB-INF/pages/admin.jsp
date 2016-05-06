<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:url value="http://localhost:8181/logout" var="logout"/>

<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="/resources/css/bootstrap/bootstrap.css"/>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <style>
        body {
            background-color: #f9fffa;
            color: #5b5b5b;
            background: url(http://luxfon.com/pic/201203/1366x768/luxfon.com-3206.jpg) repeat;
            background-size: 100%; /* Современные браузеры */
        }
    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/danialfarid-angular-file-upload/2.2.2/angular-file-upload-all.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-route.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-cookies.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-sanitize.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-translate/2.8.1/angular-translate.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-translate-storage-cookie/2.8.1/angular-translate-storage-cookie.js"></script>
    <script src="/resources/angular/admin.js"></script>
</head>
<body ng-app="admin" ng-controller="adminController">
<nav class="navbar navbar-default" style="opacity: 0.4">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home">{{'PROJNAME' | translate}}</a>
        </div>
        <sec:authorize access="isAuthenticated()">
            <sec:authentication var="name" property="principal.username"/>
            <ul class="nav navbar-nav">
                <li>
                    <a href="/account/${name}">{{'HOME' | translate}}</a>
                </li>
            </ul>
        </sec:authorize>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="${logout}">
                        <span class="glyphicon glyphicon-log-out">
                        </span> {{'LOGOUT' | translate}}
                </a>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false">
                    {{ 'LANGUAGE' | translate }}<span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href ng-click="changeLanguage('ru')">RU</a></li>
                    <li><a href ng-click="changeLanguage('en')">EN</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="text-center" style="font-size: xx-large">Administrator page</div>
    </div>
    <div class="row" style="margin-top: 30px">
        <div class="col-md-8 col-md-offset-1">
            <div ng-repeat="user in users | filter:searchText">
                <div class="row" style="margin-top: 15px">
                    <div class="col-md-3">
                        <a href="account/{{user.username}}">
                            <img ng-src="{{user.url}}" class="img-rounded" width="160" height="150">
                        </a>
                    </div>
                    <div class="col-md-4 " style="font-size: 15px">
                        <p style="font-size: x-large">
                            {{user.firstName}} {{user.lastName}}
                        </p>
                        <p>
                            {{'CITY' | translate}} : {{user.city}}
                        </p>
                        <p>
                            {{'JOB' | translate}} : {{user.job}}
                        </p>
                        <p>
                            {{'BAN' | translate}} : {{user.enabled}}
                        </p>
                    </div>
                    <div class="col-md-1" style="margin-top: 30px">
                        <div class="row">
                            <button class="btn btn-default" ng-click="deleteUser(user.id)">Delete</button>
                        </div>
                        <div class="row" style="margin-top: 8px">
                            <button class="btn btn-default" ng-click="banUser(user.id)">Ban</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-group">
                <label for="search">Search:</label>
                <input type="text" class="form-control" id="search" placeholder="Input text for search"
                       ng-model="searchText" required>
            </div>
        </div>
    </div>
</div>

</body>
</html>
