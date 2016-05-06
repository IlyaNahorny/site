var userModule = angular.module('translatePage', ['ngCookies','pascalprecht.translate']);
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
        HEADERHOME : 'All registered users of the site "Educational materials"',
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
        ADMINPAGE: 'Admin page',
        ENTERUSERNAME: 'Enter username',
        ENTERPASSWORD: 'Enter password',
        ENTERPLACEWORK: 'Enter your place work',
        ENTERCITY:'Enter your city',
        ENTERFIRSTNAME:'Enter first name',
        ENTERLASTNAME:'Enter last name',
        SEARCH:'Search',
        SEARCHTEXT:'Input text for search',
        RATING:'Article rating',
        COMMENTS:'Comments',
        READALL:'Read completely'

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
            HEADERHOME: 'Все зарегистрированные пользователи сайта "Учебные материалы"',
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
            ADMINPAGE: 'Страница админа',
            ENTERUSERNAME: 'Введите имя пользователя',
            ENTERPASSWORD: 'Введите пороль',
            ENTERPLACEWORK: 'Введите место работы',
            ENTERCITY:'Введите город',
            ENTERFIRSTNAME:'Введите имя',
            ENTERLASTNAME:'Введите фамилию',
            SEARCH:'Поиск',
            SEARCHTEXT:'Введите текст для поиска',
            RATING:'Рейтинг статьи',
            COMMENTS:'Коментариев',
            READALL:'Читать полностью'
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