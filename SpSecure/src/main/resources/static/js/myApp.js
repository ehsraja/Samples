'use strict';

var myapp = angular
    .module('myApp', ['ngRoute','http-auth-interceptor','ngResource']);


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
           redirectTo: '/home'
       }).when('/home', {
           templateUrl: 'view/home.html',
           controller: 'mainCntrl as m'
       }).when('/users', {
            templateUrl: 'view/user.html',
            controller: 'userCtrl'	   
       });
    });


myapp.run(function ($rootScope, $location, $http , $q) {
	
	$rootScope.$on( "$routeChangeStart", function(event, next, current) {
	      if ( !$rootScope.authenticated) {
	        // no logged user, we should be going to #login
	        if ( next.templateUrl == "view/login.html" ) {
	          // already going to #login, no redirect needed
	        } else {
	          // not going to #login, we should redirect now
	          $location.path('/login');
	        }
	      }   
	});
	
	 // Call when the the client is confirmed
    $rootScope.$on('event:auth-loginConfirmed', function (event, data) {
        console.log('login confirmed start ' + data);
        $rootScope.authenticated = true;
        $location.path('/home'); 

    });
    
    // Call when the 401 response is returned by the server
    $rootScope.$on('event:auth-loginRequired', function (event, data) {
    	 $rootScope.authenticated = false;
         $location.path('/login');
    });
	
});	



