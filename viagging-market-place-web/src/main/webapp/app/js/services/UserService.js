marketPlaceApp.service('userService', function(){

	'use strict';
	
	var user = {};
	
	var userService = {
		
		setUser : function(_user){
			user = _user;
		},
		
		getUser : function(){
			return user;
		}
	};	
	
	return userService;
});