﻿var userModule = angular.module('translatePage', ['ngCookies','pascalprecht.translate']);
userModule.config(['$translateProvider', function ($translateProvider) {
    $translateProvider.translations('en', {
        PROJNAME: 'Educational materials',
        SIGNUP: 'Sign up',
        LOGIN: 'Login',
        LOGOUT: 'Logout',
        WELCOMREGPAGE: 'Welcome to the registration page',
        WELCOMLOGPAGE:'Welcome to the login page',
        USERNAME: 'Username',
        PASSWORD: 'Password',
        FIRSTNAME: 'First name',
        LASTNAME: 'Last name',
        HEADERHOME : 'All registered users of the site educational materials',
        LANGUAGE: 'Language',
        CITY: 'City',
        JOB: 'Job',
        MENU:'Menu',
        EDIT:'Edit',
        CREATENEWMATER:'Create new material',
        HOME:'Home',
        UPDATEIMAGE: 'Update image',
        EDITACCOUNT: 'Change user account',
        PHOTO:'Upload photo',
        CONTENT: 'About me',
        UPDATECONTENT:'Update',
        STYLE:'Style',
        LIGHT: 'light',
        DARK:'dark',
        ADMINPAGE: 'Admin page'

    })
        .translations('ru', {
            PROJNAME: 'Учебные материалы',
            SIGNUP: 'Регистрация',
            LOGIN: 'Войти',
            LOGOUT: 'Выйти',
            WELCOMREGPAGE: 'Добро пожаловать на страницу регистрации',
            WELCOMLOGPAGE:'Добро пожаловать на страницу авторизации',
            USERNAME: 'Имя пользователя',
            PASSWORD: 'Пароль',
            FIRSTNAME: 'Имя',
            LASTNAME: 'Фамилия',
            HEADERHOME: 'Все зарегистрированные пользователи сайта учебные материалы',
            LANGUAGE:'Язык',
            CITY: 'Город',
            JOB: 'Место работы',
            MENU:'Меню',
            EDIT:'Редактировать',
            CREATENEWMATER:'Создать новый материал',
            HOME:'Моя страница',
            UPDATEIMAGE:'Обновить аву',
            EDITACCOUNT: 'Изменить учетную запись пользователя ',
            PHOTO:'Загрузить фото',
            CONTENT: 'О себе',
            UPDATECONTENT: 'Обновить',
            STYLE:'Стиль',
            LIGHT: 'светлый',
            DARK:'темный',
            ADMINPAGE: 'Страница админа'
        });

    $translateProvider.preferredLanguage('ru');
    $translateProvider.useCookieStorage();

}]);


userModule.controller('TranslateController',function ($scope,$http,$translate) {
    $scope.changeLanguage = function (key) {
        $translate.use(key);
    };
 });

userModule.controller('TranslateController1',function ($scope,$http,$translate) {
    $scope.changeLanguage = function (key) {
        $translate.use(key);
    };

    $scope.users = {};

    $http.get('get/users').success(function (data) {
        $scope.users = data;
    });

});