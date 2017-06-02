(function () {
    'use strict';

    angular
        .module('app')
        .factory('StreamService', StreamService);

    StreamService.$inject = ['$http'];
    function StreamService($http) {
        var service = {};

        
        service.postToCircle = postToCircle;
        service.postToUser = postToUser;   
        service.GetAllTags=GetAllTags;
        service.ShowMessagesWithTag=ShowMessagesWithTag;
        return service;

        
        
        

        function postToCircle(stream,circleName) {
        	console.log(stream);
            return $http.post('http://localhost:8080/ActivityRestService/stream/sendMessageToCircle/' + circleName,stream).then(handleSuccess, handleError('Error posting message to circle'));
        }
        
        function postToUser(stream) {
        	console.log(stream);
            return $http.post('http://localhost:8080/ActivityRestService/stream/sendMessageToUser/',stream).then(handleSuccess, handleError('Error posting message to circle'));
        }
        
        function GetAllTags() {
        	
            return $http.get('http://localhost:8080/ActivityRestService/stream/getAllTags').then(handleSuccess, handleError('Error retrieving tags'));
        }
        
        function ShowMessagesWithTag(tag) {
        	
            return $http.get('http://localhost:8080/ActivityRestService/stream/showMessagesWithTag/'+tag).then(handleSuccess, handleError('Error retrieving messages with tag:'+tag));
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