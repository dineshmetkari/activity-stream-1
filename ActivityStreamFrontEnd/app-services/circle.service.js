(function () {
    'use strict';

    angular
        .module('app')
        .factory('CircleService', CircleService);

    CircleService.$inject = ['$http'];
    function CircleService($http) {
        var service = {};

        
        service.CreateCircle=CreateCircle;
        service.GetAllCircles=GetAllCircles;
        service.JoinCircle=JoinCircle;
        service.LeaveCircle=LeaveCircle;
           
        return service;

        
        
        

        function CreateCircle(circle) {
        	
            return $http.post('http://localhost:8080/ActivityRestService/api/circle',circle).then(handleSuccess, handleError('Error creating circle'));
        }
        
        function GetAllCircles() {
        	
            return $http.get('http://localhost:8080/ActivityRestService/api/circle').then(handleSuccess, handleError('Error retrieving circle'));
        }
        
        function JoinCircle(userId,circleId) {
        	console.log('Service-->JoinCircle called');
            return $http.put('http://localhost:8080/ActivityRestService/api/circle/addToCircle/'+userId+'/'+circleId).then(handleSuccess, handleError('Error joining circle'));
        }
        
        function LeaveCircle(userId,circleId) {
        	console.log('Service-->LeaveCircle called');
            return $http.put('http://localhost:8080/ActivityRestService/api/circle/removeFromCircle/'+userId+'/'+circleId).then(handleSuccess, handleError('Error leaving circle'));
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