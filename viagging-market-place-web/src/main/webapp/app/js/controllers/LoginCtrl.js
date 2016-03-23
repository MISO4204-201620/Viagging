marketPlaceApp.controller('LoginCtrl', ['$scope', '$rootScope', '$state', 'loginService',
    function($scope, $rootScope, $state, loginService){
	
	'use strict';
	
	$scope.user = {
		login: "",
		password: "",
	};
	
	var successCallback = function(userData){
//		alert("Hola " + userData.primerNombre + "!");
		$rootScope.$broadcast('USER_LOGGED_IN', userData);	
		$state.go("home");
	};
	
	var errorCallback = function(){
		alert("Las credenciales que ha ingresado no son válidas!");
		$scope.user.password = "";
	};
	
	$scope.loginUser = function(){
		if($scope.user.login != "" && $scope.user.password != ""){
			loginService.loginUser($scope.user, successCallback, errorCallback);
		}
	};
}]);