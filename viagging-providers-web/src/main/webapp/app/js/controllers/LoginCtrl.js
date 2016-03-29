providersApp.controller('LoginCtrl', ['$scope', '$rootScope', '$state', 'loginService',
    function($scope, $rootScope, $state, loginService){
	
	'use strict';
	
	$scope.userLogin = {
		login: "",
		password: "",
		profile:"Proveedor"
	};
	
	var successCallback = function(userData){
		alert("Bienvenido de nuevo " + userData.primerNombre + " " + userData.primerApellido);
		$rootScope.$broadcast('USER_LOGGED_IN', userData);	
		$state.go("alimentacion");
	};
	
	var errorCallback = function(){
		alert("Las credenciales que ha ingresado no son válidas!");
		$scope.userLogin.password = "";
	};
	
	$scope.loginUser = function(){
		loginService.loginUser($scope.userLogin, successCallback, errorCallback);
	};
}]);