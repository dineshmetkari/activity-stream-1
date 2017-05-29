(function () {
    'use strict';

    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {};

        
        service.GetById = GetById;
        
        service.Create = Create;
        
        
        service.Logout=Logout;
        service.GetCirclesById=GetCirclesById;
        service.GetStreamByCircleId=GetStreamByCircleId;
        
        return service;

        
        
        

        function GetById(id) {
            return $http.get('http://localhost:8080/ActivityRestService/user/id/' + id).then(handleSuccess, handleError('Error getting user by id'));
        }

       

        function Create(user) {
            return $http.post('http://localhost:8080/ActivityRestService/user/', user).then(createSuccess, handleError('Error creating user'));
        }

        
        
        function Logout(id) {
            return $http.put('http://localhost:8080/ActivityRestService/user/logout').then(handleSuccess, handleError('Error Logging out'));
        }
        
        function GetCirclesById(id) {
            return $http.get('http://localhost:8080/ActivityRestService/circle/search/user/' + id).then(handleSuccess, handleError('Error getting circles by id'));
        }
        
        function GetStreamByCircleId(id) {
            return $http.get('http://localhost:8080/ActivityRestService/stream/getMessagesByCircle/' + id).then(handleSuccess, handleError('Error getting circles by id'));
        }

        // private functions

        function handleSuccess(res) {
            return res.data;
        }
        
        function createSuccess(res) {
        	
            return res.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();