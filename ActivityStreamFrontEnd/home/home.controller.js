(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['UserService','StreamService','CircleStreamService', 'CircleService','AuthenticationService','$rootScope','$location'];
    function HomeController(UserService, StreamService,CircleStreamService, CircleService,AuthenticationService, $rootScope,$location) {
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
        vm.tagSubscriptionStatus=null;
        vm.resultLength=null;
        vm.newMessageInCircle=null;
        vm.newPageNumber=0;
        vm.circles=[];
        vm.streams=[];
        vm.tags=[];
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
        vm.subscribeStreamWithTag=subscribeStreamWithTag;
        vm.unsubscribeStreamWithTag=unsubscribeStreamWithTag;
        vm.showTagDetails=showTagDetails;
        vm.pageChanged=pageChanged;
        vm.userCircleFlag=null;
        
        initController();

        function initController() {
            loadCurrentUser();
            loadCirclesForCurrentUser();
            loadStreamByCircle(1);
            loadAllUsers();
            loadAllCircles();
            loadAllTags();
            loadSubscibedTagsForCurrentUser();
            
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

        
        function loadStreamByCircle(pageNumber) {
        	console.log('inside loadStreamByCircle function:'+vm.selectedCircle)
            UserService.GetStreamByCircleId(vm.selectedCircle,pageNumber)
                .then(function (streams) {
                	vm.resultLength=streams.length;
                	if(vm.resultLength==0) {
                		console.log("Empty");
                		
                		
                	}
                	else{
                	var arrayLength = streams.length;
                	for (var i = 0; i < arrayLength; i++) {
                	    //alert(streams[i].tag);
                		var tagArr=streams[i].tag.split(',');
                	    console.log("tagArr"+tagArr);
                	    streams[i].tag=tagArr;
                	}
                	console.log(streams);
                    vm.streams = vm.streams.concat(streams);
                    vm.newPageNumber=pageNumber+1;
                	}
                });
        }
        
        
       
        
        
        function loadStreamByUser(pageNumber) {
        	console.log('inside loadStreamByUser function:'+vm.selectedUser)
            UserService.GetStreamByUserId($rootScope.currentUser.id,vm.selectedUser,pageNumber)
                .then(function (streams) {
                	vm.resultLength=streams.length;
                	if(vm.resultLength==0) {
                		console.log("Empty");
                		
                		
                	}
                	else{
                	var arrayLength = streams.length;
                	for (var i = 0; i < arrayLength; i++) {
                	    //alert(streams[i].tag);
                		var tagArr=streams[i].tag.split(',');
                	    console.log("tagArr"+tagArr);
                	    streams[i].tag=tagArr;
                	}
                	console.log(streams);
                    vm.streams = vm.streams.concat(streams);
                    vm.newPageNumber=pageNumber+1;
                	}
                });
        }
        
        function selectCircle(id) {
        	CircleStreamService.setSelectedCircle(id);
        	console.log(id);
        	vm.userCircleFlag='circle';
        	vm.selectedCircle=id;
        	vm.streams=[];
        	loadStreamByCircle(1);
        	
        }
        
        
        function selectUser(id) {
        	console.log(id);
        	vm.selectedUser=id;
        	vm.userCircleFlag='user';
        	vm.streams=[];
        	loadStreamByUser(1);
        	
        }
        
        
        function selectTag(tag) {
        	console.log(tag);
        	vm.selectedTag=tag;
        	vm.streams=[];
        	showMessagesWithTag(1);
        	
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
        
        function showTagDetails(tag) {
        	console.log("showTagDetails method:"+tag);
        	vm.selectedTag=tag;
        	vm.streams=[];
        	
        	   
        	
        	    vm.tagSubscriptionStatus=containsAny(tag,vm.tags);
        	    console.log("Tag Subscription Status"+vm.tagSubscriptionStatus);
        	    	
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
        	
            AuthenticationService.Logout(function(response){
            	alert(response.statusMessage);
                $location.path("/login");
            });
        	
        	
        }
        
        function postToCircle(stream,circle) {
            	
        	    CircleStreamService.postToCircle(stream,circle);        
            	//loadStreamByCircle(1);
            	vm.stream.message="";
            
        }
        
        function postToUser(stream) {
            StreamService.postToUser(stream)
            .then(function () {
            	vm.streams=[];
            	loadStreamByUser(1);
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
        	if(tags!=null){
        		var arrayLength=tags.length;
        	}
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
            	loadAllCircles();
            });
        	
        }
        
        function startPrivateMessage(){
        	
        	vm.userCircleFlag='user';
        	vm.recentUsers.push(vm.selectedUser);
        	vm.streams=[];
        	loadStreamByUser(1);
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
        
        function showMessagesWithTag(pageNumber) {
        	console.log('inside showMessagesWithTag function');
            StreamService.ShowMessagesWithTag(vm.selectedTag,pageNumber)
                .then(function(streams) {
                	vm.resultLength=streams.length;
                	if(vm.resultLength==0) {
                		console.log("Empty");
                		
                		
                	}
                	else {
                		
                	var arrayLength = streams.length;
                	for (var i = 0; i < arrayLength; i++) {
                		var tagArr=streams[i].tag.split(',');
                	    console.log("tagArr"+tagArr);
                	    streams[i].tag=tagArr;
                	}
                	console.log(streams);
                    vm.streams = vm.streams.concat(streams);
                    vm.newPageNumber=pageNumber+1;
                	}
                });
        }
        
        
        /*function loadStreamByCircle(pageNumber) {
        	console.log('inside loadStreamByCircle function:'+vm.selectedCircle)
            UserService.GetStreamByCircleId(vm.selectedCircle,pageNumber)
                .then(function (streams) {
                	vm.resultLength=streams.length;
                	if(vm.resultLength==0) {
                		console.log("Empty");
                		
                		
                	}
                	else{
                	var arrayLength = streams.length;
                	for (var i = 0; i < arrayLength; i++) {
                	    //alert(streams[i].tag);
                		var tagArr=streams[i].tag.split(',');
                	    console.log("tagArr"+tagArr);
                	    streams[i].tag=tagArr;
                	}
                	console.log(streams);
                    vm.streams = vm.streams.concat(streams);
                    vm.newPageNumber=pageNumber+1;
                	}
                });
        }*/
       
        
        
        
        function subscribeStreamWithTag() {
        	console.log('inside subscribeStreamWithTag function');
            StreamService.SubscribeStreamWithTag($rootScope.currentUser.id,vm.selectedTag)
                .then(function(streams) {
                	alert('you have successfully subscribed to this tag');
                	loadSubscibedTagsForCurrentUser();
                });
        }
        
        function unsubscribeStreamWithTag() {
        	console.log('inside unsubscribeStreamWithTag function');
            StreamService.UnsubscribeStreamWithTag($rootScope.currentUser.id,vm.selectedTag)
                .then(function(streams) {
                	alert('you have successfully unsubscribed to this tag');
                	loadSubscibedTagsForCurrentUser();
                });
        }
        
        
        function loadSubscibedTagsForCurrentUser() {
        	console.log('inside loadSelectedTagsForCurrentUser function:'+$rootScope.currentUser.id)
            UserService.GetSubscribedTagsById($rootScope.currentUser.id)
                .then(function (tags) {
                    vm.tags = tags;
                    
                });
        }
        
        function pageChanged(newPage) {
        	console.log('inside pageChanged'+newPage);
        	
            //getResultsPage(newPage);
        	loadStreamByCircle(newPage);
        }
        
        
        CircleStreamService.receive().then(null, null, function(message) {
        	//alert('You have a new message');
        	
        	loadStreamByCircle(1);
          }); 
        
    }

})();