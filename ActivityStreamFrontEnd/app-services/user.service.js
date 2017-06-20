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
        
        
        /*service.Logout=Logout;*/
        service.GetCirclesById=GetCirclesById;
        service.GetStreamByCircleId=GetStreamByCircleId;
        service.GetAllUsers=GetAllUsers;
        service.GetStreamByUserId=GetStreamByUserId;
        service.GetSubscribedTagsById=GetSubscribedTagsById;
        
        return service;

        
        
        

        function GetById(id) {
            return $http.get('http://localhost:8080/ActivityRestService/api/user/' + id).then(handleSuccess, handleError('Error getting user by id'));
        }

       

        function Create(user) {
            return $http.post('http://localhost:8080/ActivityRestService/api/user', user).then(createSuccess, handleError('Error creating user'));
        }

        
        
        /*function Logout(id) {
            return $http.put('http://localhost:8080/ActivityRestService/user/logout').then(handleSuccess, handleError('Error Logging out'));
        }*/
        
        function GetCirclesById(id) {
            return $http.get('http://localhost:8080/ActivityRestService/api/circle/searchByUser/' + id).then(handleSuccess, handleError('Error getting circles by id'));
        }
        
        function GetStreamByCircleId(id,pageNumber) {
        	console.log('service-->GetStreamByCircleId');
            return $http.get('http://localhost:8080/ActivityRestService/api/stream/getMessagesByCircle/' + id+"/"+pageNumber).then(handleSuccess, handleError('Error getting circles by id'));
        }
        
        function GetStreamByUserId(currentUserId,otherUserId,pageNumber) {
            return $http.get('http://localhost:8080/ActivityRestService/api/stream/getMessagesByUser/' + currentUserId+'/'+otherUserId+'/'+pageNumber).then(handleSuccess, handleError('Error getting circles by id'));
        }
        
        
        function GetAllUsers() {
            return $http.get('http://localhost:8080/ActivityRestService/api/user').then(handleSuccess, handleError('Error getting list of users'));
        }

        
        function GetSubscribedTagsById(id) {
        	console.log("Service-->GetSubscribedTagsById");
            return $http.get('http://localhost:8080/ActivityRestService/api/stream/tags/search/user/' + id).then(handleSuccess, handleError('Error getting tags by UserId'));
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