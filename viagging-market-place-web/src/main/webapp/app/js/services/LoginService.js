marketPlaceApp.service('loginService', ['$http', 'userService', function($http, userService){
	
	'use strict';
	
	var loginService = {
	
		loginUser : function(user){
			return $http({
	            url: "/viagging-api/login",
	            method: "POST",
	            data: user,
	            cache: false
	        });
		}
	};
	
	return loginService;
}]);