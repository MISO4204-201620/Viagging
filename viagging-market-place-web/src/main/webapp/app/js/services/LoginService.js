marketPlaceApp.service('loginService', ['$http', function($http){
	
	'use strict';
	
	var userData = {};
	
	var loginService = {
	
		isUserLoggedIn : false,
			
		loginUser : function(user, successCallback, errorCallback){
			
			return $http({
	            url: "/viagging-api/login",
	            method: "POST",
	            data: user,
	            cache: false
	        }).success(function(response){
	        	if(angular.isObject(response)){
	        		userData = response;
	        		isUserLoggedIn = true;
	        		successCallback();
	        	} else {
	        		errorCallback();
	        	}
	        	 
	        }).error(errorCallback);
		},
		
		logoutUser : function(){
			userData = null;
			isUserLoggedIn = false;
		},
		
		getUserData : function(){
			return userData;
		}
	
	
	};
	
	return loginService;
}]);