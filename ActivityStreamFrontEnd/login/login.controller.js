(function () {
    'use strict';
    console.log('inside login controller')
    angular
        .module('app')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthenticationService'];
    function LoginController($location, AuthenticationService) {
        var vm = this;

        vm.login = login;

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function login() {
        	console.log('inside login controller')
            vm.dataLoading = true;
            AuthenticationService.Login(vm.id, vm.password, function (response) {
            	console.log(response.success)
                if (response.success) {
                	console.log(vm.id+'  '+vm.password);
                    AuthenticationService.SetCredentials(vm.id, vm.password);
                    console.log('5');
                    $location.path('/home');
                    console.log('6');
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        };
    }

})();