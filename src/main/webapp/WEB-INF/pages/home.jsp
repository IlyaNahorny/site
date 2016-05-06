<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:url value="http://localhost:8181/logout" var="logout"/>

<html>
<title>Home page</title>
<link rel="stylesheet" href="/resources/css/bootstrap/bootstrap.min.css"/>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>

<style>
    body {
        background-color: #f8fff9;
        color: #5b5b5b;
        background: url(http://luxfon.com/pic/201203/1366x768/luxfon.com-3206.jpg) repeat;
        /*-moz-background-size: 100%; /!* Firefox 3.6+ *!/*/
        /*-webkit-background-size: 100%; /!* Safari 3.1+ и Chrome 4.0+ *!/*/
        /*-o-background-size: 100%; /!* Opera 9.6+ *!/*/
        background-size: 100%; /* Современные браузеры */
    }
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-cookies.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-sanitize.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-translate/2.8.1/angular-translate.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-translate-storage-cookie/2.8.1/angular-translate-storage-cookie.js"></script>
<script src="/resources/angular/translatePage.js"></script>
</head>
<body ng-app="translatePage" ng-controller="TranslateController1">
<nav class="navbar navbar-default" style="opacity: 0.4">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="navbar-brand">{{'PROJNAME' | translate}}</div>
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
            <sec:authorize access="isAnonymous()">
                <li><a href="/login">
                        <span class="glyphicon glyphicon-log-in">
                        </span> {{'LOGIN' | translate}}
                </a></li>
                <li><a href="/registration_page">{{'SIGNUP' | translate}} </a></li>
            </sec:authorize>
            <li>
                <sec:authorize access="isAuthenticated()">
                    <a href="${logout}">
                        <span class="glyphicon glyphicon-log-out">
                        </span> {{'LOGOUT' | translate}}
                    </a>
                </sec:authorize>
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
    <div class="row-fluid">
        <center><h1>{{'HEADERHOME' | translate}}</h1></center>
    </div>
    <div class="row" style="margin-top: 30px">
        <div class="col-md-5 col-md-offset-2">
            <div ng-repeat="user in users | filter:searchText">
                <div class="row" style="margin-top: 15px">
                    <div class="col-md-5">
                        <a href="account/{{user.username}}">
                            <img ng-src="{{user.url}}" class="img-rounded" width="160" height="150">
                        </a>
                    </div>
                    <div class="col-md-5" style="font-size: 15px">
                        <p style="font-size: x-large">
                            {{user.firstName}} {{user.lastName}}
                        </p>

                        <p>
                            {{'CITY' | translate}} : {{user.city}}
                        </p>

                        <p>
                            {{'JOB' | translate}} : {{user.job}}
                        </p>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-md-3 col-md-offset-2">
            <div class="form-group">
                <label for="search">{{'SEARCH' | translate }}:</label>
                <input type="text" class="form-control" id="search" placeholder="{{'SEARCHTEXT' | translate }}"
                       ng-model="searchText" required>
            </div>
        </div>
    </div>
</div>

</body>
</html>
