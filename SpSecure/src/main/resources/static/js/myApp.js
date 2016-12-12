'use strict';

var myapp = angular
    .module('myApp', ['ngRoute']);


myapp.constant('USER_ROLES', {
    all: '*',
    admin: 'admin',
    user: 'user'
});

myapp.config(function ($routeProvider, USER_ROLES) {

    $routeProvider
    .when("/login", {
        templateUrl: "view/login.html",
        controller: 'loginCntrl'
    }).when('/', {
           redirectTo: '/login'
       }).when('/home', {
           templateUrl: 'view/home.html',
           controller: 'mainCntrl as m'
       }).when('/users', {
            templateUrl: 'view/user.html',
            controller: 'userCtrl'	   
       });
    });


