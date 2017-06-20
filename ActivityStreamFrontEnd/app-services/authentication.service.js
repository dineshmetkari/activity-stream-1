(function () {
    'use strict';
    console.log('inside authentication service')
    angular
        .module('app')
        .factory('AuthenticationService', AuthenticationService);

    AuthenticationService.$inject = ['$http', '$cookies', '$rootScope', '$timeout'];
    function AuthenticationService($http, $cookies, $rootScope, $timeout) {
        var service = {};

        service.Login = Login;
        service.Logout=Logout;
        service.SetCredentials = SetCredentials;
        service.ClearCredentials = ClearCredentials;

        return service;

        function Login(username, password, callback) {

           console.log('inside Login method inside service')
            $http.post('http://localhost:8080/ActivityRestService/api/authenticate', { id: username, password: password })
                .then(function (res) {
                	console.log(res.data);
                	$rootScope.currentUser={ id: res.data.id,
          				  name: res.data.name,
          				  password: res.data.password};
                	var response={success:true};
                    callback(response);
                });

        }
        
        
        function Logout(callback) {

            console.log('inside Logout method inside service')
             $http.put('http://localhost:8080/ActivityRestService/api/logout')
                 .then(function (res) {
                 	console.log(res.data);
                 	var response=res.data;
                     callback(response);
                 },function(obj){
                	 console.log(obj.toString());
                 });
                 

         }

        function SetCredentials(username, password) {
            
        	console.log('inside setcredentials method');
        	

            // set default auth header for http requests
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.currentUser;
            console.log($rootScope.currentUser.id);
            console.log('1');
            // store user details in globals cookie that keeps user logged in for 1 week (or until they logout)
            var cookieExp = new Date();
            console.log('2');
            cookieExp.setDate(cookieExp.getDate() + 7);
            console.log('3');
            $cookies.putObject('currentUser', $rootScope.currentUser, { expires: cookieExp });
            console.log('4');
        }

        function ClearCredentials() {
            $rootScope.currentUser = {};
            $cookies.remove('currentUser');
            $http.defaults.headers.common.Authorization = 'Basic';
        }
    }


})();