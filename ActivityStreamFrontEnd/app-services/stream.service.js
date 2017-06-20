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
        service.SubscribeStreamWithTag=SubscribeStreamWithTag;
        service.UnsubscribeStreamWithTag=UnsubscribeStreamWithTag;
        return service;

        
        
        

        function postToCircle(stream,circleName) {
        	console.log(stream);
            return $http.post('http://localhost:8080/ActivityRestService/api/stream/sendMessageToCircle/' + circleName,stream).then(handleSuccess, handleError('Error posting message to circle'));
        }
        
        function postToUser(stream) {
        	console.log(stream);
            return $http.post('http://localhost:8080/ActivityRestService/api/stream/sendMessageToUser/',stream).then(handleSuccess, handleError('Error posting message to circle'));
        }
        
        function GetAllTags() {
        	
            return $http.get('http://localhost:8080/ActivityRestService/api/stream/listAllTags').then(handleSuccess, handleError('Error retrieving tags'));
        }
        
        function ShowMessagesWithTag(tag,pageNumber) {
        	
            return $http.get('http://localhost:8080/ActivityRestService/api/stream/showMessagesWithTag/'+tag+"/"+pageNumber).then(handleSuccess, handleError('Error retrieving messages with tag:'+tag));
        }
        
        
        function SubscribeStreamWithTag(userId,tag) {
        	console.log('Service-->SubscribeStreamWithTag called');
            return $http.put('http://localhost:8080/ActivityRestService/api/stream/subscribe/'+userId+'/'+tag).then(handleSuccess, handleError('Error subscribing to tag'));
        }
        
        function UnsubscribeStreamWithTag(userId,tag) {
        	console.log('Service-->UnsubscribeStreamWithTag called');
            return $http.put('http://localhost:8080/ActivityRestService/api/stream/unsubscribe/'+userId+'/'+tag).then(handleSuccess, handleError('Error unsubscribing to tag'));
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