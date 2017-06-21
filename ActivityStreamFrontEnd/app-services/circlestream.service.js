(function () {
    'use strict';

    angular
        .module('app')
        .factory('CircleStreamService', CircleStreamService);

    CircleStreamService.$inject = ['$q','$timeout'];
    function CircleStreamService($q,$timeout) {
    	var service = {}; 
    	var listener = $q.defer(); 
    	var socket = {
    	      client: null,
    	      stomp: null
    	    };
    	var circleName=null;
    	

        
    	service.RECONNECT_TIMEOUT = 30000;
        service.SOCKET_URL = "/ActivityRestService/postToCircle";
        service.CHAT_TOPIC = "/topic/circle";
        service.CHAT_BROKER = "/app/postToCircle";
        
        
        var initialize = function() {
            socket.client = new SockJS(service.SOCKET_URL);
            socket.stomp = Stomp.over(socket.client);
            socket.stomp.connect({}, startListener);
            socket.stomp.onclose = reconnect;
          };
          
          var reconnect = function() {
              $timeout(function() {
                initialize();
              }, this.RECONNECT_TIMEOUT);
            };
          
          var startListener = function() {
          	console.log("inside startListener method");
            socket.stomp.subscribe(service.CHAT_TOPIC+"/"+circleName, function(data) {
              listener.notify(getMessage(data.body));
            });
          };   
          
          var getMessage = function(data) {
          	
              var stream = JSON.parse(data), out = {};
              out.message = stream.message;
              out.postedDate=stream.postedDate;
              //out.time = new Date(message.time);
              console.log("chat service:"+out.message);
              console.log("chat service:"+out.postedDate);
              console.log("chat service:"+out.senderID);
              return out;
            };
            
            
            service.postToCircle = function(stream,circle) {
            	circleName=circle;
            	console.log(stream.message);
            	console.log(stream.senderID);
            	console.log(stream.tag);
            	
                socket.stomp.send(service.CHAT_BROKER+"/"+circleName, {
                  priority: 9
                }, JSON.stringify({
                    streamType: "String",
                    message:stream.message,
                    senderID:stream.senderID,
                    tag:stream.tag
                }));
                
              }; 
              
              
              service.receive = function() {
                  return listener.promise;
                };
                
                service.setSelectedCircle = function(circle) {
                    circleName=circle;
                    initialize();
                  };  
                
                
                initialize();   
        
        return service;

        
    }

})();