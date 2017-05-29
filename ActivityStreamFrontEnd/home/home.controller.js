(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['UserService','StreamService', '$rootScope','$location'];
    function HomeController(UserService, StreamService, $rootScope,$location) {
        var vm = this;
        console.log('username in HomeController:'+$rootScope.currentUser);
        vm.user = null;
        vm.selectedCircle=null;
        vm.stream=null;
        vm.circles=[];
        vm.streams=[];
        vm.allUsers = [];
        vm.logout=logout;
        vm.selectCircle=selectCircle;
        vm.send=send;
        
        initController();

        function initController() {
            loadCurrentUser();
            loadCirclesForCurrentUser();
            loadStreamByCircle();
            
        }

        function loadCurrentUser() {
        	console.log('inside loadCurrentUser function:'+$rootScope.currentUser.id)
            UserService.GetById($rootScope.currentUser.id)
                .then(function (user) {
                    vm.user = user;
                });
        }
        
        function loadCirclesForCurrentUser() {
        	console.log('inside loadCirclesForCurrentUser function:'+$rootScope.currentUser.id)
            UserService.GetCirclesById($rootScope.currentUser.id)
                .then(function (circles) {
                    vm.circles = circles;
                    
                });
        }

        
        function loadStreamByCircle() {
        	console.log('inside loadStreamByCircle function:'+vm.selectedCircle)
            UserService.GetStreamByCircleId(vm.selectedCircle)
                .then(function (streams) {
                	console.log(streams);
                    vm.streams = streams;
                    
                });
        }
        
        
        function selectCircle(id) {
        	console.log(id);
        	vm.selectedCircle=id;
        	loadStreamByCircle();
        	
        }
        
        function loadAllUsers() {
            UserService.GetAll()
                .then(function (users) {
                    vm.allUsers = users;
                });
        }

        
        function logout() {
            UserService.Logout()
            .then(function () {
            	alert('you have successfully logged out');
                $location.path("/login");
            });
        }
        
        function postToCircle(stream,circle) {
            StreamService.postToCircle(stream,circle)
            .then(function () {
            	loadStreamByCircle();
            	vm.stream.message="";
            });
        }
        
        function send() {
        	console.log($rootScope.currentUser.id);
        	vm.stream.senderID=$rootScope.currentUser.id;
        	vm.stream.streamType='String';
        	vm.stream.tag=vm.selectedCircle;
        	postToCircle(vm.stream,vm.selectedCircle);
        	
        }
    }

})();