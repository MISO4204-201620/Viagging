marketPlaceApp.service('loginService', ['$http', 'userService', 'hello', function($http, userService, hello){

	'use strict';

	hello.on("auth.login", function(r){
		console.log(r.authresponse);
	});

	var loginService = {

		loginUser : function(userLogin, successCallback, errorCallback){

			return $http({
	            url: "/viagging-market-place-web/login",
	            method: "POST",
	            data: userLogin,
	            cache: false
	        }).success(function(response){
	        	if(angular.isObject(response)){
	        		userService.setUserData(response);
	        		successCallback(response);
	        	} else {
	        		errorCallback(response);
	        	}

	        }).error(errorCallback);
		},

		logoutUser : function(){
			userService.removeUserData();
		},

		registerUser : function(user, successCallback, errorCallback){

			return $http({
	            url: "/viagging-market-place-web/register",
	            method: "POST",
	            data: user,
	            cache: false
	        }).success(function(response){
	        	if(angular.isObject(response)){
	        		userService.setUserData(response);
	        		successCallback(response);
	        	} else {
	        		errorCallback(response);
	        	}

	        }).error(errorCallback);
		},

		loginFacebookUser : function(){
			hello('facebook').login();
		},

		loginTwitterUser : function(){
			hello('twitter').login();
		}

	};

	return loginService;
}]);