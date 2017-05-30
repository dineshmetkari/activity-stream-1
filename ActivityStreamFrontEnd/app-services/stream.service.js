(function () {
    'use strict';

    angular
        .module('app')
        .factory('StreamService', StreamService);

    StreamService.$inject = ['$http'];
    function StreamService($http) {
        var service = {};

        
        service.postToCircle = postToCircle;
           
        return service;

        
        
        

        function postToCircle(stream,circleName) {
        	console.log(stream);
            return $http.post('http://localhost:8080/ActivityRestService/stream/sendMessageToCircle/' + circleName,stream).then(handleSuccess, handleError('Error posting message to circle'));
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