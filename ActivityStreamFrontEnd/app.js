(function () {
    'use strict';
console.log('inside app.js')
    angular
        .module('app', ['ngRoute', 'ngCookies'])
        .config(config)
        .run(run);

    config.$inject = ['$routeProvider', '$locationProvider'];
    function config($routeProvider, $locationProvider) {
        $routeProvider

            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'login/login.view.html',
                controllerAs: 'vm'
            })
            .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'register/register.view.html',
                controllerAs: 'vm'
            })
            .when('/home', {
                controller: 'HomeController',
                templateUrl: 'home/home.view.html',
                controllerAs: 'vm'
            })

            .otherwise({ redirectTo: '/login' });
    }

    run.$inject = ['$rootScope', '$location', '$cookies', '$http'];
    function run($rootScope, $location, $cookies, $http) {
        // keep user logged in after page refresh
        $rootScope.currentUser = $cookies.getObject('currentUser') || {};
        console.log('7'+$rootScope.currentUser.username);
        if ($rootScope.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.currentUser.username;
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register','/home']) === -1;
            //var adminPage = $.inArray($location.path(), ['/postjob','/newblog']) != -1;
            console.log('Restricted Page:'+restrictedPage);
            
            var loggedIn = $rootScope.currentUser.username;
            var role=$rootScope.currentUser.role;
            console.log('logged In:'+loggedIn);
            console.log('role:'+role);
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
            else
            {
            	
            	if (adminPage && role!='admin') {
                    alert('This action is restricted to the admin role only');
                    $location.path("/");
                }
            }
            
            
        });
    }

})();