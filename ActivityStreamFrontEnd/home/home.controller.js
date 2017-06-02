(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['UserService','StreamService', 'CircleService','$rootScope','$location'];
    function HomeController(UserService, StreamService, CircleService, $rootScope,$location) {
        var vm = this;
        console.log('username in HomeController:'+$rootScope.currentUser);
        vm.user = null;
        vm.selectedUser=null;
        vm.selectedCircle=null;
        vm.selectedTag=null;
        vm.stream=null;
        vm.circle=null;
        vm.currentCircle=null;
        vm.circleJoinStatus=null;
        vm.circles=[];
        vm.streams=[];
        vm.allUsers = [];
        vm.allCircles=[];
        vm.allTags=[];
        vm.recentUsers=[];
        vm.logout=logout;
        vm.selectCircle=selectCircle;
        vm.selectUser=selectUser;
        vm.selectTag=selectTag;
        vm.send=send;
        vm.createCircle=createCircle;
        vm.showCircleDetails=showCircleDetails;
        vm.joinCircle=joinCircle;
        vm.leaveCircle=leaveCircle;
        vm.startPrivateMessage=startPrivateMessage;
        vm.showUserDetails=showUserDetails;
        vm.showMessagesWithTag=showMessagesWithTag;
        vm.userCircleFlag=null;
        
        initController();

        function initController() {
            loadCurrentUser();
            loadCirclesForCurrentUser();
            loadStreamByCircle();
            loadAllUsers();
            loadAllCircles();
            loadAllTags();
            
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
        
        
        function loadAllUsers() {
        	console.log('inside loadAllUsers function')
            UserService.GetAllUsers()
                .then(function (users) {
                    vm.allUsers = users;
                    
                });
        }
        
        function loadAllCircles() {
        	console.log('inside loadAllCircles function')
            CircleService.GetAllCircles()
                .then(function (circles) {
                    vm.allCircles = circles;
                    
                });
        }

        
        function loadStreamByCircle() {
        	console.log('inside loadStreamByCircle function:'+vm.selectedCircle)
            UserService.GetStreamByCircleId(vm.selectedCircle)
                .then(function (streams) {
                	var arrayLength = streams.length;
                	for (var i = 0; i < arrayLength; i++) {
                	    //alert(streams[i].tag);
                		var tagArr=streams[i].tag.split(',');
                	    console.log("tagArr"+tagArr);
                	    streams[i].tag=tagArr;
                	}
                	console.log(streams);
                    vm.streams = streams;
                    
                });
        }
        
        
        function loadStreamByUser() {
        	console.log('inside loadStreamByUser function:'+vm.selectedUser)
            UserService.GetStreamByUserId($rootScope.currentUser.id,vm.selectedUser)
                .then(function (streams) {
                	var arrayLength = streams.length;
                	for (var i = 0; i < arrayLength; i++) {
                	    //alert(streams[i].tag);
                		var tagArr=streams[i].tag.split(',');
                	    console.log("tagArr"+tagArr);
                	    streams[i].tag=tagArr;
                	}
                	console.log(streams);
                    vm.streams = streams;
                    
                });
        }
        
        function selectCircle(id) {
        	console.log(id);
        	vm.userCircleFlag='circle';
        	vm.selectedCircle=id;
        	loadStreamByCircle();
        	
        }
        
        
        function selectUser(id) {
        	console.log(id);
        	vm.selectedUser=id;
        	vm.userCircleFlag='user';
        	loadStreamByUser();
        	
        }
        
        
        function selectTag(tag) {
        	console.log(tag);
        	vm.selectedTag=tag;
        	
        	
        }
        function showCircleDetails(circle) {
        	console.log("showcircle method:"+circle.id);
        	vm.currentCircle=circle;
        	var circleId=circle.id;
        	    /*for (var i = 0; i != vm.circles.length; i++) {
        	       var substring = vm.circles[i];
        	       if (circleId.indexOf(substring) != - 1) {
        	         vm.circleJoinStatus=true;
        	       }
        	      
        	    }*/
        	
        	    vm.circleJoinStatus=containsAny(circle.id,vm.circles);
        	    console.log("Circle Join Status"+vm.circleJoinStatus);
        	    
        	

        	
        }
        
        function showUserDetails(user) {
        	console.log("showUser method:"+user.id);
        	vm.selectedUser=user.id;
        	   
        	
        	   
        	    
        	

        	
        }
        
        
        function containsAny(str, substrings) {
            for (var i = 0; i != substrings.length; i++) {
               var substring = substrings[i];
               if (str.indexOf(substring) != - 1) {
                 return substring;
               }
            }
            return null; 
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
        
        function postToUser(stream) {
            StreamService.postToUser(stream)
            .then(function () {
            	loadStreamByUser();
            	vm.stream.message="";
            });
        }
        
        function joinCircle() {
        	console.log('join circle function called');
            CircleService.JoinCircle($rootScope.currentUser.id,vm.currentCircle.id)
            .then(function () {
            	alert('you have successfully joined this circle');
            	loadCirclesForCurrentUser();
            });
        }
        
        function leaveCircle() {
        	console.log('leave circle function called');
            CircleService.LeaveCircle($rootScope.currentUser.id,vm.currentCircle.id)
            .then(function () {
            	alert('you have successfully left the circle');
            	loadCirclesForCurrentUser();
            });
        }
        
        function send() {
        	var message=vm.stream.message;
        	var tags=(message.match(/#\w+/g));
        	var arrayLength=tags.length;
        	for (var i = 0; i < arrayLength; i++) {
        	    
        		tags[i]=tags[i].slice(1);
        	    
        	    
        	}
        	console.log('tags found-->'+tags);
        	console.log($rootScope.currentUser.id);
        	vm.stream.senderID=$rootScope.currentUser.id;
        	vm.stream.streamType='String';
        	vm.stream.tag=( typeof tags != 'undefined' && tags instanceof Array ) ? tags.toString().toLowerCase() : 'No Tags';
        	if(vm.userCircleFlag=='circle'){
        		
        		vm.stream.receiverID=null;
        		postToCircle(vm.stream,vm.selectedCircle);
        	}
        	else
        	{
        		
        		vm.stream.receiverID=vm.selectedUser;
        		postToUser(vm.stream);	
        	}
        	loadAllTags();
        	
        }
        
        function createCircle() {
        	vm.circle.name=vm.circle.id;
        	vm.circle.adminID=$rootScope.currentUser.id;
        	CircleService.CreateCircle(vm.circle)
            .then(function () {
            	alert('New Circle created with name:'+vm.circle.name);
                
            });
        }
        
        function startPrivateMessage(){
        	
        	vm.userCircleFlag='user';
        	vm.recentUsers.push(vm.selectedUser);
        	loadStreamByUser();
        }
        
        function loadAllTags() {
        	console.log('inside loadAllTags function:')
            StreamService.GetAllTags()
                .then(function (tags) {
                	var arrayLength = tags.length;
                	for (var i = 0; i < arrayLength; i++) {
                	    
                		var tagArr=tags[i].split(',');
                	    var allTagValues=vm.allTags.concat(tagArr);
                	    //vm.allTags=findUnique(allTagValues);
                	    
                	    vm.allTags= jQuery.unique(allTagValues);
                	    
                	}
                	console.log(vm.allTags);
                	
                    
                });
        }
        
        /*function findUnique(arr) {
            var result = [];
            arr.forEach(function (d) {
                if (result.indexOf(d) === -1)
                    result.push(d);
            });
            return result;
        }*/
        
        function showMessagesWithTag() {
        	console.log('inside showMessagesWithTag function');
            StreamService.ShowMessagesWithTag(vm.selectedTag)
                .then(function(streams) {
                	console.log('1');
                	var arrayLength = streams.length;
                	for (var i = 0; i < arrayLength; i++) {
                		var tagArr=streams[i].tag.split(',');
                	    console.log("tagArr"+tagArr);
                	    streams[i].tag=tagArr;
                	}
                	console.log(streams);
                    vm.streams = streams;
                });
        }
        
    }

})();