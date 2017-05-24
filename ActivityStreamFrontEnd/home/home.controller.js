(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['UserService', '$rootScope','$location'];
    function HomeController(UserService, $rootScope,$location) {
        var vm = this;
        console.log('username in HomeController:'+$rootScope.currentUser);
        vm.user = null;
        vm.selectedCircle=null;
        vm.circles=[];
        vm.streams=[];
        vm.allUsers = [];
        vm.logout=logout;
        vm.selectCircle=selectCircle;
        
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

        
        function logout(id) {
            UserService.Logout(id)
            .then(function () {
                $location.path("/login");
            });
        }
    }

})();