(function () {
    'use strict';

    angular
        .module('app')
        .factory('CircleService', CircleService);

    CircleService.$inject = ['$http'];
    function CircleService($http) {
        var service = {};

        
        service.CreateCircle=CreateCircle;
           
        return service;

        
        
        

        function CreateCircle(circle) {
        	
            return $http.post('http://localhost:8080/ActivityRestService/circle/create',circle).then(handleSuccess, handleError('Error creating circle'));
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