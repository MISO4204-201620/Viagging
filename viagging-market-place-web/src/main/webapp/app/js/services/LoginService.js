marketPlaceApp.service('loginService', ['$http', '$rootScope', 'userService', 'hello',
    function($http, $rootScope, userService, hello){

	'use strict';

	hello.on("auth.login", function(r){
		console.log(r.authResponse);
		
		hello(r.network).api('/me').then(function(p) {
			var user = {
				primerNombre: p.first_name,
				primerApellido: p.last_name,
				correo: p.email
			};
			
			loginService.loginUserByEmail(user);
		});
	});
	
	var loginService = {

		loginUser : function(userLogin, successCallback, errorCallback){

			return $http({
	            url: "/viagging-market-place-web/user/login",
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
		
		loginUserByEmail : function(user){
			return $http({
	            url: "/viagging-market-place-web/user?email=" + user.correo,
	            method: "GET",
	            cache: false
	        }).success(function(response){
	        	if(angular.isObject(response)){
	        		userService.setUserData(response);
	        		$rootScope.$broadcast("USER_LOGGED_IN_BY_SOCIAL_NETWORK", response);
	        	} else {
	        		loginService.registerSocialNetworkUser(user);
	        	}

	        }).error(function(){
	        	loginService.registerSocialNetworkUser(user);
	        });
		},

		logoutUser : function(){
			if(hello.getAuthResponse('facebook')){
				hello('facebook').logout();
			} else if(hello.getAuthResponse('twitter')){
				hello('twitter').logout();
			}
			userService.removeUserData();
		},

		registerSocialNetworkUser : function(user){
			return $http({
	            url: "/viagging-market-place-web/user/register",
	            method: "POST",
	            data: user,
	            cache: false
	        }).success(function(response){
	        	if(angular.isObject(response)){
	        		userService.setUserData(response);
	        		$rootScope.$broadcast("USER_REGISTERED_IN_BY_SOCIAL_NETWORK", response);
	        	} else {
	        		$rootScope.$broadcast("ERROR_REGISTERING_SOCIAL_NETWORK_USER");
	        	}

	        }).error(function(){
	        	$rootScope.broadcast("ERROR_REGISTERING_SOCIAL_NETWORK_USER");
	        });
		},
		
		registerUser : function(user, successCallback, errorCallback){

			return $http({
	            url: "/viagging-market-place-web/user/register",
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

		loginFacebookUser : function(successCallback, errorCallback){
			hello('facebook').login();
		},

		loginTwitterUser : function(){
			hello('twitter').login();
		}

	};

	return loginService;
}]);