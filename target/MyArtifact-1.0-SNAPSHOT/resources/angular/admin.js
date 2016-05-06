var adminModule = angular.module('admin', ['ngCookies', 'pascalprecht.translate']);
adminModule.config(['$translateProvider', function ($translateProvider) {
    $translateProvider.translations('en', {
        PROJNAME: 'Educational materials',
        SIGNUP: 'Sign up',
        LOGIN: 'Login',
        LOGOUT: 'Logout',
        WELCOMREGPAGE: 'Welcome to the registration page',
        WELCOMLOGPAGE: 'Welcome to the login page',
        USERNAME: 'Username',
        PASSWORD: 'Password',
        FIRSTNAME: 'First name',
        LASTNAME: 'Last name',
        HEADERHOME: 'All registered users of the site educational materials',
        LANGUAGE: 'Language',
        CITY: 'City',
        JOB: 'Job',
        MENU: 'Menu',
        EDIT: 'Edit',
        CREATENEWMATER: 'Create new material',
        HOME: 'Home',
        UPDATEIMAGE: 'Update image',
        EDITACCOUNT: 'Change user account',
        PHOTO: 'Upload photo',
        CONTENT: 'About me',
        UPDATECONTENT: 'Update',
        STYLE: 'Style',
        LIGHT: 'light',
        DARK: 'dark',
        MATERIALNAME: 'Material name',
        DESCRIPTION: 'Description',
        UPLOADIMAGE: 'Upload image',
        TEMPNAME: 'Creating material',
        ADDMATERIAL: 'Add material',
        RESET: 'Reset',
        ADDIMAGE: 'Add image',
        TEMPLATE: 'Template',
        TEMPLSELECT: 'Template selection',
        BAN:'Ban'

    })
        .translations('ru', {
            PROJNAME: 'Учебные материалы',
            SIGNUP: 'Регистрация',
            LOGIN: 'Войти',
            LOGOUT: 'Выйти',
            WELCOMREGPAGE: 'Добро пожаловать на страницу регистрации',
            WELCOMLOGPAGE: 'Добро пожаловать на страницу авторизации',
            USERNAME: 'Имя пользователя',
            PASSWORD: 'Пароль',
            FIRSTNAME: 'Имя',
            LASTNAME: 'Фамилия',
            HEADERHOME: 'Все зарегистрированные пользователи сайта учебные материалы',
            LANGUAGE: 'Язык',
            CITY: 'Город',
            JOB: 'Место работы',
            MENU: 'Меню',
            EDIT: 'Редактировать',
            CREATENEWMATER: 'Создать новый материал',
            HOME: 'Моя страница',
            UPDATEIMAGE: 'Обновить аву',
            EDITACCOUNT: 'Изменить учетную запись пользователя ',
            PHOTO: 'Загрузить фото',
            CONTENT: 'О себе',
            UPDATECONTENT: 'Обновить',
            STYLE: 'Стиль',
            LIGHT: 'светлый',
            DARK: 'темный',
            MATERIALNAME: 'Имя материала',
            DESCRIPTION: 'Описание',
            UPLOADIMAGE: 'Загрузите изображение',
            TEMPNAME: 'Создание материала',
            ADDMATERIAL: 'Добавить материал',
            RESET: 'Сброс',
            ADDIMAGE: 'Добавить изображение',
            TEMPLATE: 'Шаблон',
            TEMPLSELECT: 'Выбор шаблона',
            BAN:'Бан'
        });

    $translateProvider.preferredLanguage('ru');
    $translateProvider.useCookieStorage();

}]);

adminModule.controller("adminController",function($scope, $window, $http, $translate){
    $scope.changeLanguage = function (key) {
        $translate.use(key);
    };

    var user = {
        'id' : ''
    };

    $http.get('users/withoutAdmin').success(function (data) {
        $scope.users = data;
        console.log(data);
    });

    $scope.deleteUser = function (id) {
        user.id = id;
        $http.post('user/delete', user).success(function (data) {
            alert("success");
            $scope.users = data;
        })
            .error(function () {
                alert("error");
            });
    };

    $scope.banUser = function (id) {
        user.id = id;
        $http.post('user/ban', user).success(function (data) {
            alert("success");
            $scope.users = data;
        })
            .error(function () {
                alert("error");
            });
    };


});
