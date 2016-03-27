providersApp.service('loginService', ['$http', 'userService', function($http, userService){
	
	'use strict';
	
	var loginService = {
	
		loginUser : function(user, successCallback, errorCallback){
			
			return $http({
	            url: "/viagging-api/login",
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
		
		logoutUser : function(){
			userService.removeUserData();
		}
	
	};
	
	return loginService;
}]);