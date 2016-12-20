myapp.service('Session', function () {
    this.create = function (data) {
        this.id = data.id;
        this.login = data.login;
        this.firstName = data.firstName;
        this.lastName = data.familyName;
        this.email = data.email;
        this.userRoles = [];
        angular.forEach(data.authorities, function (value, key) {
            this.push(value.name);
        }, this.userRoles);
    };
    this.invalidate = function () {
        this.id = null;
        this.login = null;
        this.firstName = null;
        this.lastName = null;
        this.email = null;
        this.userRoles = null;
    };    return this;
});

myapp.service('AuthSharedService', function ($rootScope, $http, authService, Session) {
    return {
        login: function (username, password) {
            
        	console.log("here in authshared service" + username + password);
        	var config = {
                ignoreAuthModule: 'ignoreAuthModule',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            };
             var details = { 'username': username, 'password': password
             }
         	console.log("here 2 in authshared service" + details);
            $http.post('authenticate', $.param({
                username: username,
                password: password
            })
            		, config)
                .success(function (data, status, headers, config) {
                	console.log("login done")
                    authService.loginConfirmed(data);
                })
                .error(function (data, status, headers, config) {
                    $rootScope.authenticationError = true;
                    Session.invalidate();
                });
        },
        isAuthorized: function (authorizedRoles) {
            if (!angular.isArray(authorizedRoles)) {
                if (authorizedRoles == '*') {
                    return true;
                }
                authorizedRoles = [authorizedRoles];
            }
            var isAuthorized = false;
            angular.forEach(authorizedRoles, function (authorizedRole) {
                var authorized = (!!Session.login &&
                Session.userRoles.indexOf(authorizedRole) !== -1);
                if (authorized || authorizedRole == '*') {
                    isAuthorized = true;
                }
            });
            return isAuthorized;
        },
        logout: function () {
            $rootScope.authenticationError = false;
            $rootScope.authenticated = false;
            $rootScope.account = null;
            $http.get('logout');
            Session.invalidate();
            authService.loginCancelled();
        }
    };
});
