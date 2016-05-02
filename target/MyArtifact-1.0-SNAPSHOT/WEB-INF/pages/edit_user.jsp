<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:url value="http://localhost:8181/logout" var="logout"/>

<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" href="/resources/css/bootstrap/bootstrap.css"/>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/style/upload.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/danialfarid-angular-file-upload/2.2.2/angular-file-upload-all.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-route.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-cookies.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-sanitize.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-translate/2.8.1/angular-translate.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-translate-storage-cookie/2.8.1/angular-translate-storage-cookie.js"></script>


    <script src="/resources/angular/updateImage.js"></script>

</head>
<body ng-app="uplImage" ng-controller="UploadImageController">
<nav class="navbar navbar-default">
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
    <center><h1>{{'EDITACCOUNT' | translate}}</h1></center>
    <div class="row">
        <div class="col-md-7">
            <center><h2>{{'CONTENT' | translate}}</h2></center>
            <form:form class="form-horizontal" method="post" commandName="user" action="/account/${user.username}/edit">
                <div class="form-group">
                    <label class="control-label col-sm-4" for="firstName">{{'FIRSTNAME' | translate}}:</label>

                    <div class="col-sm-8">
                        <form:input path="firstName" type="text" value="${user.firstName}" class="form-control"
                                    placeholder="Enter first name"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-4" for="lastName">{{'LASTNAME' | translate}}:</label>

                    <div class="col-sm-8">
                        <form:input path="lastName" type="text" value="${user.lastName}" class="form-control"
                                    placeholder="Enter last name"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4" for="city">{{'CITY' | translate}}:</label>

                    <div class="col-sm-8">
                        <form:input path="city" type="text" value="${user.city}" class="form-control"
                                    placeholder="Enter your city"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4" for="job">{{'JOB' | translate}}:</label>

                    <div class="col-sm-8">
                        <form:input path="job" type="text" value="${user.job}" class="form-control"
                                    placeholder="Enter your place work"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4" for="style">{{ 'STYLE' | translate }}</label>

                    <div class="col-sm-8">
                        <form:select path="style" class="form-control">
                            <option value="default" selected>{{ 'LIGHT' | translate }}</option>
                            <option value="dark">{{ 'DARK' | translate }}</option>
                        </form:select>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-4">
                        <button type="submit" class="btn btn-default">{{'UPDATECONTENT' | translate}}</button>
                    </div>
                </div>
            </form:form>
        </div>
        <div class="col-md-offset-8">
            <center><h2>{{'UPLOADIMAGE' | translate}}</h2></center>
            <%--<button onclick="upload()" class="btn btn-default">{{'UPDATEIMAGE' | translate}}</button>--%>
            <div class="form-group">
                <label for="imageUpload">{{'PHOTO' | translate}}</label>
                <button class="btn-default btn glyphicon glyphicon-picture" id="imageUpload"
                        title="{{ 'ADDIMAGE' | translate }}" data-toggle="tooltip"
                        ng-file-select ng-model="file_image">
                </button>
            </div>

            <div class="form-group">
                <div class="file">
                    <div class="progress" id="progress">
                        <div class="progress-bar progress-bar-success progress-bar-striped active"
                             role="progressbar"
                             aria-valuemin="0" aria-valuemax="100" ng-style="fileStatus">{{file.progress}}
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <img ng-src="{{urlUser}}" ng-show="showPicture" class="img-rounded" width="370" height="250">
            </div>
            <div class="form-group">
                <button class="btn btn-default" ng-click="updateImage()">{{ 'PHOTO' | translate }}</button>
                <button class="btn btn-default" ng-click="reset()">{{ 'RESET' | translate }}</button>
            </div>
        </div>
    </div>

</div>


</body>
</html>
